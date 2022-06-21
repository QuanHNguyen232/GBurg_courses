.text
main:
	#prompt the user
	li $v0, 4
	la $a0, prompt
	syscall

	#read an integer
	li $v0, 5
	syscall
	#result in $v0
	move $s0, $v0
	
	#read an integer
	li $v0, 5
	syscall
	#result in $v0
	move $s1, $v0
	
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
	li $v0, 1
	move $a0, $s5
	syscall

	#halt the program
	li $v0, 10
	syscall
.data
prompt: .asciiz "Enter two integers: "