# Program to read a string from a user, and
# print that string back to the console.
.text
main:
 # Prompt for the string to enter
 li $v0, 4
 la $a0, prompt
 syscall

 # Read the string.
 li $v0, 8
 la $a0, input
 lw $a1, inputSize
 syscall

 # Output the text
 li $v0, 4
 la $a0, output1
 syscall

 # Output the user's input
 li $v0, 4
 la $a0, input
 syscall

 # Output the text
 li $v0, 4
 la $a0, output2
 syscall

 # Exit the program
 li $v0, 10
 syscall

.data
input: .space 81
inputSize: .word 80
prompt: .asciiz "Please enter an string: "
output1: .asciiz "\nSo you like: "
output2: .asciiz " pie"
answer: .asciiz "syscall records the new line charachter from the end of the user's input, so it starts a new line at the end of the user's answer."
