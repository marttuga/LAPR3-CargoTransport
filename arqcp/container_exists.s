.section .data

.section .bss

.section .text
    .global container_exists                # int container_exists()

container_exists:

    movq $0, %rax
    movq $0, %rdx

    movl (%rdi), %edx                       # puts the pointer 

    cmpl $0, %edx                           # compares the value pointed at by rsi with 0
    jg is_true                              # if greater than 0, then container_ID exists

    jmp end                                 # else, goes to the end. result in eax (eax = 0)   

is_true:

    movl $1, %eax                           # puts 1 in eax (int)
    jmp end                                 # goes to the end. result is in eax                 

end:
    ret
