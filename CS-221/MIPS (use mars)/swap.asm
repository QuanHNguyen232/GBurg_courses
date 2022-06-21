.text
main:

	#read an integer
	la $a0, prompt
	jal PromptForInt
	#result in $v0
	move $s0, $v0
	
	#read an integer
	la $a0, prompt
	jal PromptForInt
	#result in $v0
	move $s1, $v0
	
	#print the integer
	move $a0, $s0
	jal PrintInteger
	jal PrintNewLine
	
	#print the integer
	move $a0, $s1
	jal PrintInteger
	jal PrintNewLine
	
	# SWAP
	jal SwapTwoInt
	
	#print the integer
	move $a0, $s0
	jal PrintInteger
	jal PrintNewLine
	
	#print the integer
	move $a0, $s1
	jal PrintInteger
	jal PrintNewLine
	
	#SWAP version2
	jal SwapTwoInt2
	
	#print the integer
	move $a0, $s0
	jal PrintInteger
	jal PrintNewLine
	
	#print the integer
	move $a0, $s1
	jal PrintInteger
	jal PrintNewLine
	
	#halt the program by calling exit
	jal Exit
.data
prompt: .asciiz "Enter an integer: "

.text
SwapTwoInt:
	addi $t0, $s0, 0
	addi $s0, $s1, 0
	addi $s1, $t0, 0
	jr $ra
	
SwapTwoInt2:
	move $t0, $s0
	move $s0, $s1
	move $s1, $t0
	jr $ra

.include "utils.asm"