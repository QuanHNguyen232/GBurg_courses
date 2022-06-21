.text

main:

# open input dialogBox
li      $v0, 54
la	$a0, prompt
la      $a1, input
lw      $a2, inputSize
syscall


# Display input in dialogBox
la      $a0, input
li	$a1, 1
li      $v0, 55
syscall


# exit
li      $v0, 10
syscall


.data
input: .space 81
inputSize: .word 80

prompt: .asciiz "your txt:"



