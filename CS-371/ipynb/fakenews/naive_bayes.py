# imports
from collections import Counter
import math
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import random
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.naive_bayes import MultinomialNB
from sklearn.tree import DecisionTreeClassifier, plot_tree

# set random seeds for reproducibility
random.seed(0)
np.random.seed(0)

real_lines = [line.strip() for line in open('clean_real.txt', 'r').readlines()]
print('# real headlines', len(real_lines))
fake_lines = [line.strip() for line in open('clean_fake.txt', 'r').readlines()]
print('# fake headlines', len(fake_lines))
real_words = ' '.join(real_lines).split(' ')
fake_words = ' '.join(fake_lines).split(' ')
all_words = list(set(real_words).union(set(fake_words)))

# create shuffled 70/15/15 train/validation/test datasets
real_label, fake_label = (1, 0)
X = real_lines + fake_lines
y = len(real_lines) * [real_label] + len(fake_lines) * [fake_label]
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, shuffle=True, random_state=0)
X_test, X_val, y_test, y_val = train_test_split(X_test, y_test, test_size=0.5, shuffle=True, random_state=0)

def get_nb_df(X, y):
    real_lines = [x for i, x in enumerate(X) if y[i] == real_label]
    fake_lines = [x for i, x in enumerate(X) if y[i] == fake_label]
    real_fake_data = {word:[sum([word in line.split(' ') for line in real_lines]), 
                        sum([word in line.split(' ') for line in fake_lines])]
                        for word in all_words}
    df = pd.DataFrame(data=real_fake_data).T
    df.columns = ['real_count', 'fake_count']
    return (df, len(real_lines), len(fake_lines))

df, num_real, num_fake = get_nb_df(X, y)
num_top_words = 20
print(f'Top {num_top_words} Real Headline Frequent Words:')
df.sort_values('real_count', ascending=False, inplace=True)
df[:20].plot(kind='barh', y='real_count')
plt.show() 

print(f'Top {num_top_words} Fake Headline Frequent Words:')
df.sort_values('fake_count', ascending=False, inplace=True)
df[:20].plot(kind='barh', y='fake_count')
plt.show() 

nb_hash = 0
nb_df = pd.DataFrame()
nb_log_likelihood = 1

def naive_bayes(headline, df, num_real_lines, num_fake_lines, m, p_hat):
    global nb_hash, nb_df, nb_log_likelihood
    new_hash = hash(num_real_lines) + hash(num_fake_lines) + hash(m) + hash(p_hat)
    if nb_hash != new_hash or not df.equals(nb_df):  # If there's been a change...
        # ... recompute empty headline log likelihood
        nb_hash = new_hash
        nb_df = df
        nb_log_likelihood = math.log(num_real_lines / num_fake_lines)
        for word in df.index:
            real_prob = 1 - (df.loc[word]['real_count'] + m * p_hat) / (num_real_lines + m)
            fake_prob = 1 - (df.loc[word]['fake_count'] + m * p_hat) / (num_fake_lines + m)
            nb_log_likelihood += math.log(real_prob / fake_prob)
    words = headline.strip().split(' ')
    # Start with the assumption of precomputed empty headline log_likelihood and adjust for headline words
    log_likelihood = nb_log_likelihood
    for word in words:
        if word in df.index:
            # subtract default absent word term
            real_prob = 1 - (df.loc[word]['real_count'] + m * p_hat) / (num_real_lines + m)
            fake_prob = 1 - (df.loc[word]['fake_count'] + m * p_hat) / (num_fake_lines + m)
            log_likelihood -= math.log(real_prob / fake_prob)
            # add present word term
            real_prob = 1 - real_prob
            fake_prob = 1 - fake_prob
            log_likelihood += math.log(real_prob / fake_prob)
        else: # optional
            log_likelihood += math.log((num_fake_lines + m) / (num_real_lines + m))
    return real_label if log_likelihood > 0 else fake_label


def get_accuracy(X, y, df, num_real_lines, num_fake_lines, m, p_hat):
    correct = sum([naive_bayes(x, df, num_real_lines, num_fake_lines, m, p_hat) == correct_label for x, correct_label in zip(X, y)])
    return correct / len(X)


df_train, num_real_lines_train, num_fake_lines_train = get_nb_df(X_train, y_train)

m = 0.5
p_hat = 1

print('Using a Naive Bayes Classifier based on 70% training data:')
print(f'Training accuracy = {get_accuracy(X_train, y_train, df_train, num_real_lines_train, num_fake_lines_train, m, p_hat)} for m={m}, p_hat={p_hat}')

df_val, num_real_lines_val, num_fake_lines_val = get_nb_df(X_val, y_val)
print(f'Validation accuracy = {get_accuracy(X_val, y_val, df_train, num_real_lines_train, num_fake_lines_train, m, p_hat)} for m={m}, p_hat={p_hat}')

df_test, num_real_lines_test, num_fake_lines_test = get_nb_df(X_test, y_test)
print(f'Testing accuracy = {get_accuracy(X_test, y_test, df_train, num_real_lines_train, num_fake_lines_train, m, p_hat)} for m={m}, p_hat={p_hat}')