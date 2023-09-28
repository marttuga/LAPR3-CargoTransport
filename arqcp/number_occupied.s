.section .data

.section .bss

.section .text
    .global number_occupied                # int number_occupied()

# number_occupied(ptr), ptr in rdi
number_occupied:

    movl $0, %esi                       # cleans esi and moves the index to esi
    movl $0, %ecx                       # cleans ecx and this will be the counter
    movl num_positions(%rip), %ebx      # num lines matrix

loop:

    cmpl %esi, %ebx                     # checks if index = number of elements 
    je end  

    call container_exists               # calling the function from previous US

    cmpq $0, %rax                       # if is greater than 0, then container_ID exists  
    jg container                        

    incl %esi                           # increases index (i++)  
    addq $8, %rdi                       # increments the position in the matrix                                          
    jmp loop                            # goes to next iteration
            
container:
    incl %esi                           # increases index 
    incl %ecx                           # count of the slots taken 	
    addq $8, %rdi                       # increments the position in the matrix                                          
    jmp loop	                        # goes to next iteration

end:
    movl %ecx, %eax                     # copies the counter into eax. return in eax
    ret
