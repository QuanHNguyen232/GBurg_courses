.text
main:

	#get a string from the user
	la		$a0,		prompt
	la		$a1,		string
	li		$a2,		50
	jal		PromptForString
	
	#print the user input string
	la		$a0,		string
	li		$v0, 	4
	syscall
	
	jal		Exit

.data
prompt: 		.asciiz   	"Enter a string: "
string:		.space	51

.text
# PromptForString function
#inputs:
#	$a0: address of the prompt string
#	$a1: address of the input space
#	$a2: max length of the string
#output: none
#side effect: user input in the input space

#stack frame: size 20
#   0($fp):  prompt string address (a0)
#  -4($fp): space address (a1)
#  -8($fp): max length (a2)
# -12($fp): return address (ra)
# -16($fp): caller's fp
PromptForString:
	#set up function activation frame
	sw		$fp,	-16($fp)		#save the old frame pointer
	move		$fp, 	$sp			#set fp at the start of my frame
	addi		$sp, 	$sp,	-20   		#make space for activation frame
	sw		$ra,	-12($fp)		#store the return address
	sw		$a0, 	0($fp)		#arguments
	sw		$a1,	-4($fp)		
	sw		$a2, 	-8($fp)
	
	#perform the function
	#write the prompt
	lw		$a0,		0($fp)
	li		$v0,		4
	syscall
	
	#read the result from the user
	lw		$a0, 	-4($fp)
	lw		$a1,	-8($fp)
	li		$v0, 	8
	syscall
	
	#restore state
	lw		$ra, 		-12($fp)		#restore return address
	move 		$sp, 		$fp			#restore stack pointer
	lw		$fp,		-16($fp)		#restore the old frame pointer
	
	#return
	jr		$ra



.include "utils.asm"
