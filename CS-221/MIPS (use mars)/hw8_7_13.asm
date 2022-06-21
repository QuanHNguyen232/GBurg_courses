.text
# input integer 1
	la $a0, prompt1
	jal PromptForInt
	move $t0, $v0
	
# input integer 2
	la $a0, prompt2
	jal PromptForInt
	move $t1, $v0	
	# check if denominator is 0	
	seq $t5, $t1, $zero
	# if not:
	beqz $t5 , move_on
	
	li $v0, 4
	la $a0, error
	syscall
	
	b end
	
move_on: 
	div $t2, $t0, $t1	# num / den	
	rem $t3, $t0, $t1	# num % den

	sgt $t5, $t3, $zero	# check if Remainder = 0
	beqz $t5 , move_next	# remainder NOT 0

	# remainder = 0
	div $t4, $t1, $t3	# 
	sge $t5, $t1, 1
			
	beqz $t5, move_next
			
	add $t2, $t2, 1
				

move_next: 
# Print quotient.
	li $v0, 4
	la $a0, result		# The value to print.
	syscall			# Do it.
					
	move $a0, $t2
	jal PrintInteger		
	
	jal PrintNewLine		
	
end:
	jal Exit
	
.data
	error: .asciiz "Cannot divided by zero."
	prompt1: .asciiz "Enter x = "
	prompt2: .asciiz "Enter y = "
	result:	.asciiz "x/y = "

.include "utils.asm"
	

