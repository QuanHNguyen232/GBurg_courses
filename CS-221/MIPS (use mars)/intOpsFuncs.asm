.text
main:
	#prompt the user
	la $a0, prompt
	jal PromptForInt
	move $s0, $v0		#store the result in $s0
	
	la $a0, prompt
	jal PromptForInt
	move $s1, $v0		#store the result in $s1
	
	
	#add the values together
	add $s2, $s0, $s1
	
	#immediate add (sign extension)
	addi $s3, $s2, -256
	
	#immediate add with a 32-bit value
	#lui - load upper immediate
	#   place immediate value in upper 16 bits of the register
	#lui $at, 2 --        at: 0000 0000 0000 0010 0000 0000 0000 0000
	
	#ori $at, $at, 0x49f0  --     0000 ...             0 0100 1001 1111 0000
	#                          at: 0000 0000 0000 0010 0100 1001 1111 0000
	#add
	addi $s4, $s3, 150000
	
	#logical operators
	xori $s5, $s4, -1
	
	#shift operators
	#logical left shift: 0001 << 1 == 0010
	sll $s6, $s0, 2    #immediate value for shift amount
	
	#sllv shift amount in register
	
	#arithmetic right shift: 0011 >> 1 == 0001,  1101 >> 1 == 1110
	#logical right shift: 0011 >> 1 == 0001
	
	#print the integer
	move $a0, $s1
	jal PrintInteger
	
	#print new line
	jal PrintNewLine
	
	#print the integer
	move $a0, $s2
	jal PrintInteger
	jal PrintNewLine
	
	move $a0, $s3
	jal PrintInteger
	jal PrintNewLine
	
	#print the integer
	move $a0, $s5
	jal PrintInteger

	#halt the program by calling Exit
	jal Exit  	#"jump and link" - store the location in the program as $ra
	
.data
prompt: .asciiz "Enter an integer: "

# Exit subroutine
# input: none
# output: none
# side effects: the program ends
.text
Exit: 
	li $v0, 10
	syscall

# PrintInteger subroutine
# input: $a0 - holds the integer value to print
# output: none
# side effect: print an integer to the console
.text
PrintInteger:
	li $v0, 1
	syscall
	
	#try to print a new line
	#used t0 as a temp (might be used by PrintNewLine)
	#don't do this
	#move $t0, $ra
	#jal PrintNewLine
	#jr $t0
	jr $ra

# PrintNewLine subroutine
# input: none
# output: none
# side effects: a new line is printed on the console
.text 
PrintNewLine:	
	li $v0, 4
	la $a0, _PNL_EOL
	syscall
	# return to instruction after the call
	jr $ra   #jump to the address in $ra
.data
_PNL_EOL: .asciiz "\n"

# PromptForInt subroutine: ask the user for an int and return it
#input: $a0 - the address of the prompt message
#output: $v0 - resulting integer
#side effects: prompt message on console and user input
.text
PromptForInt:
	#print the prompt message
	li $v0, 4
	syscall
	#read the integer
	li $v0, 5
	syscall   #read int: result in $v0
	jr $ra
