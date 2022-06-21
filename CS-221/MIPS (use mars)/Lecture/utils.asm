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
