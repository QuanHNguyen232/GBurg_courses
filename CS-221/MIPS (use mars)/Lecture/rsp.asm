#Rock Scissors Paper
.text
main:
#get the user throw
		#prompt the user
		la $a0, prompt
		jal PromptForInt
		move $s0, $v0		#store the result in $s0

		#check range: 0, 1, 2
		#if(condition) {  #condition will be 0 or 1
		#                            false condition, skip body
		#    body
		# }
		# next
		
		#if(user input is incorrect)
		#  $s0 < 0 || $s0 > 2
		slti	$t0, $s0, 0
		sgt	$t1, $s0, 2
		or 	$t0, $t0, $t1
		beqz $t0, continue		#skip body if condition is false (0).
		#   print error message
		la	$a0, error
		li	$v0, 4
		syscall
		#  exit
		jal Exit
continue:
				
		#boolean instructions: and, or, <, <=, > , ==
		# branch: PC relative addresses
		# beqz: branch if equal to 0
		# b: unconditional branch (goto)

#print user's item
		move $a0, $s0
		jal PrintItem

#get a random computer throw in $s1
		li $a0, 1  #pick a random number stream
		li $a1, 3  #get a value between 0 and 3
		li $v0, 42 #call random int range
		syscall 
		move $s1, $a0      #store the computer's choice in $s1
		
		#jal PrintInteger  #sanity check
		
		#print message
		la $a0, pick
		li $v0, 4
		syscall
		
		#print computer's item
		move $a0, $s1
		jal PrintItem     #print what's in $a0
		


		#if $s0 == $s1, they are the same
draw:
		seq $t0, $s0, $s1
		beqz $t0, user_win
		
		la $a0, tie
		li $v0, 4
		syscall
		
		b end
		#else if user wins
user_win:  
		#user wins when: 
		#   $s0 is 0 and $s1 is 1
		seq $t0, $s0, 0   # $s0 == 0
		seq $t1, $s1, 1
		and $t0, $t0, $t1
		
		#   $s0 is 1 and $s1 is 2
		seq $t2, $s0, 1
		seq $t3, $s1, 2
		and $t2, $t2, $t3
		
		#   $s0 is 2 and $s1 is 0
		seq $t4, $s0, 2
		seq $t5, $s1, 0
		and $t4, $t4, $t5
		
		#or conditions together
		or $t0, $t0, $t2
		or $t0, $t0, $t4
		
		beqz $t0, user_lose
				
		la $a0, win
		li $v0, 4
		syscall
		
		b end
		#else (user loses)
user_lose:
		la $a0, lose
		li $v0, 4
		syscall
end:
		jal Exit


.data
prompt:	.asciiz "Rock (0), Scissors(1) or Paper(2) "
error:	.asciiz "That is not a choice"
pick:	.asciiz "I threw "
tie:		.asciiz "We'll call it a draw.\n"
win:		.asciiz "You win.\n"
lose:		.asciiz "You lose.\n"


#PrintItem
#input: $a0 0, 1 or 2
#output: none
#side effects: output rock scissors or paper
.text 
PrintItem:
		#if($a0 == 0 (rock))
_PI_rock:
		seq $t0, $a0, 0   # does $a0 represent a rock?
		beqz $t0, _PI_scissors
		#    print rock
		la $a0, rock
		li $v0, 4
		syscall
		b	_PI_END_IF
		#else if($a0 == 1 (scissors))
_PI_scissors:
		seq $t0, $a0, 1  # scissors?
		beqz $t0, _PI_paper
		#    print scissors
		la $a0, scissors
		li $v0, 4
		syscall
		b	_PI_END_IF
		#else
_PI_paper:
		#    print paper
		la $a0, paper
		li $v0, 4
		syscall
_PI_END_IF:

		jr $ra   #return
.data 
rock:	.asciiz "rock\n"
scissors:	.asciiz "scissors\n"
paper:	.asciiz "paper\n"


.include "utils.asm"
