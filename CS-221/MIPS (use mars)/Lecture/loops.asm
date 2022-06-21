#while loops
.text
main:

#for loop
#enter a value, n
#for(i = 0; i < n; i++) {
#   enter a value, d
#   if(i is even), add d
#   else subtract d
# }

# n: $s0
# i: $s1
# sum: $s2

		la 		$a0, n_prompt
		jal		PromptForInt
		move 	$s0, $v0		#n

		move 	$s1, $0		# i = 0
		move 	$s2, $0		# sum = 0

start_for:
		slt		$t0, $s1, $s0	# is i < n?
		beqz 	$t0,	end_for

	
		la 		$a0, d_prompt
		jal		PromptForInt

		move 	$s3, $v0
#   if(i is even), add d
# condition
		rem		$t0, $s1, 2	#calculate i % 2
		bnez	$t0, 	else		#remainder is not 0, it is odd go to else
		add		$s2, $s2, $s3	#sum = sum + d
	
		b		end_if
#   else subtract d
else:
		sub		$s2, $s2, $s3	#sum = sum - d
end_if:
				#add 		$s2, $s2, $v0	#sum = sum + d (user input)

		addi		$s1, $s1, 1		# i++
	
		b		start_for
end_for:	

		move 	$a0, $s2
		jal 		PrintInteger

		jal 		PrintNewLine
		
# enter integers until user enters a negative
# get integer from the user, d
# while (d >= 0) {
#   add it to a sum
#   get the next integer
# }

# init: put the user data in $s0
# $s1 stores the sum
		la 		$a0, prompt
		jal		PromptForInt
		move 	$s0, $v0

#test remainder
#		rem		$t3, $s0, 2
	
		move 	$s1, $0			#set sum to 0
		
#condition (can repeat)
start_loop:
		sge		$t0, $s0, $0		#set t0 to 0 if $s0 > 0
		beqz	$t0, end_loop		#if condition fails, go to end of loop
		
#add the value to sum
		add		$s1, $s1, $s0
		
#get the next integer
		la 		$a0, prompt
		jal		PromptForInt
		move 	$s0, $v0

		b 		start_loop		#branch back to the beginning of the loop
#end of loop
end_loop:
		move 	$a0, $s1
		jal 		PrintInteger		#print the result

		jal 		Exit

.data
prompt: 		.asciiz "Enter an integer. Negative to quit."
n_prompt:	.asciiz "How many items? "
d_prompt:	.asciiz "Enter an integer: "

			
.include "utils.asm"
