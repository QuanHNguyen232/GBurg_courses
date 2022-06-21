.text
main:
# read integer x
	la $a0, prompt
	jal PromptForInt
	#store the value from $v0
	sw $v0, x    #store the value from $v0 into memory location x
	
# read integer y
	la $a0, prompt
	jal PromptForInt
	#store the value from $v0
	sw $v0, y    #store the value from $v0 into memory location y
	
# x = x + y
#load x into registers
	lw $s0, x
#load y into registers
	lw $s1, y
#add the values
	add $s0, $s0, $s1
#store the result in x
	sw $s0, x

#write something into "array"   array[0] = 128
	li $s2, 128
	sw $s2, array

#write array[1]=64 (offset  should be 4)
	li $s2, 64
	sw $s2, array+4   #take the memory address array and add 4
	
#EXCEPTION: word addresses must be divisible by 4 (unaligned access)
# Byte address can be anything in data
# Half-word (16 bits) addresses must be divisible by 2
#	li $s2, 256
#	sw $s2, array+6

#register offsets
	li $s3, 8   #this will represent index 2
	li $s2, 32
	sw $s2, array($s3)  #M[array + $s3] = $s2

#next item
	addi $s3, $s3, 4  #add 4 to  my index
	li $s2, 512
	sw $s2, array($s3)  #M[array + $s3] = $s2
	

#end program
	jal Exit

.data
x: .word 0  #make space in data for one word
y: .word 0
array: .space 40   #make room for 40 bytes (10 words)
prompt: .asciiz "Enter an integer: "

#include my utilities
.include "utils.asm"