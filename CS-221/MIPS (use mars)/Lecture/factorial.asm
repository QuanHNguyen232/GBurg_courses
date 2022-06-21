.text
#fac: factorial function
#	int fac(int n){
#	  int result = 1;
#	  if(n > 1)
#	    result = n*fac(n-1);
#  
#	  return result;
#	}
#input: $a0 is n to compute n!
#output:  $v0 is the resulting n!
#
#stack frame:  size = 20
#   0($fp): parameter n
#  -4($fp): $ra - our return address
#  -8($fp): $fp - previous frame pointer
# -12($fp): stored $s0 register
# -16($fp): local variable
Factorial:
	#set up activation frame
		sw 	$fp, -8($sp)		#store old frame pointer
		move 	$fp, $sp		#point frame pointer at top of stack
		addi 	$sp, $sp, -20      	#make room on the stack
		sw 	$a0, 0($fp)		#store argument
		sw	$s0, -12($fp)		#stored saved register
		sw 	$ra, -4($fp)		#store return address
		
	#default return value
		li	$t0, 1
		sw	$t0, -16($fp)
	#if the argument is > 1, return factorial
		lw	$s0, 0($fp)		#put the param in $s0 so it is preserved after the function call
		sgt	$t1, $s0, 1 		#if(n > 1)
		beqz	$t1, end_if		#no? skip this part
		subi	$a0, $s0, 1		#calculate n-1 and put it in the argument
		jal	Factorial		#call fac(n-1)
		mul	$t0, $s0, $v0		#multiply the result*n
		sw	$t0, -16($fp)		#store it
end_if:
	#restore stack/registers to previous state
		lw	$v0, -16($fp)		#load the return value into v0
	
		lw	$ra, -4($fp)		#put the return address back in its register
		lw	$s0, -12($fp)		#restore $s0 register
		
		move 	$sp, $fp		#reset the stack point to the fp location
		lw	$fp, -8($fp)		#restore the old fp value
	
		jr	$ra			#return