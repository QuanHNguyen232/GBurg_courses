#Create a text area for the program
.text
main:
#print message
	li $v0, 4		#set up for print string syscall
	la $a0, hello  	#use the label as the address of the string
	syscall		#call print string

#print new line
	li $v0, 4		#set up for print string syscall
	la $a0, eol  	#use the label as the address of the string
	syscall
	
	lw $a0, myInt	#load word into a0 for print int
	#li $v0, 1		#set up call to print int
	li $v0, 34		#set up call to print int in hex
	syscall
	
#print new line
	li $v0, 4		#set up for print string syscall
	la $a0, eol  	#use the label as the address of the string
	syscall
	
#print a byte of the word
	lb $a0, myInt 	#load a byte
	li $v0, 34		#set up call to print int in hex
	syscall

#print new line
	li $v0, 4		#set up for print string syscall
	la $a0, eol  	#use the label as the address of the string
	syscall
	
#print the next byte of the word
	lb $a0, myInt+1 	#load a byte at the address plus 1
	li $v0, 34			#set up call to print int in hex
	syscall
	
	
#end the program
	li $v0, 10   	#load the value 10 into register $v0
				#10 is the value for the halt system call
	syscall		#call the function

#space for data
.data
hello:	.asciiz "Hello\n world!"
eol: 		.asciiz "\n"
myInt: 	.word 0x1A2B3C4D