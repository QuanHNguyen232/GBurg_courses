.text
.globl main
main:

# print prompt
	li $v0, 4
	la $a0, prompt
	syscall

# input integer
	li $v0, 5
	syscall
	move $t0, $v0
	
#Here you set $a1 to the max bound.
	li $a1, 10  
	li $v0, 42  #generates the random number.
	syscall
	move $t1, $a0
	addi $t1, $t1, 1

# if-else statement
# 1st condition
	slt $s1, $t0, $t1
	beqz $s1, elseif
	la $a0, output1
	jal PrintString
	b end_if

# 2nd condition
elseif:
	sgt $s1, $t0, $t1
	beqz $s1, else
	la $a0, output2
	jal PrintString
	b end_if

# else
else: 
	la $a0, output3
	jal PrintString
	b end_if
	end_if:

# print NewLine
	jal PrintNewLine

# Print Result
	li $v0, 4
	la $a0, result
	syscall

# print the random number
	move $a0, $t1
	li $v0, 1
	syscall
	 
	li $v0, 10
	syscall

.data
	prompt: .asciiz "Enter a number: "
	output1: .asciiz "Lower"
	output2: .asciiz "Higher"
	output3: .asciiz "Correct"
	result: .asciiz "Rand num = "

.include "utils.asm"
