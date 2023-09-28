.section .data
    .global containers_ptr		           # Pointer of array defined as global variable in C
	.global num_containers_atual           # Total of positions on the arra
    .equ DATA_SIZE, 120                    # Total size of struct container
    .equ x, 4                              # Position x starts at byte 4
    .equ y, 8                              # Position y starts at byte 8
    .equ z, 12                             # Position z starts at byte 12
    .equ refrigeration, 88                 # Refrigeration starts at byte 88

.section .bss

.section .text
    .global is_refrigerated                #int is_refrigerated(int x_value, int y_value, int z_value);
             
is_refrigerated:
    # Prologue
	pushq %rbp                             # Save the original value of rbp
	movq %rsp , %rbp                       # Copy the current stack pointer to rbp
	
    movq $0, %rax                          # Cleans rax register
   
    movq containers_ptr(%rip), %rbx        # Copies start of struct to rbx register
    movq num_containers_atual(%rip), %r11  # Copies number of containers to r11 register

loop:
    cmpq $0,  %r11                         # Checks if there's no more containers
    je end                                 # Jumps end if equal

    movl x(%rbx), %r12d                    # Moves value of rbx offseted by 4 bytes to r12 register (Coordinate x of container)
    cmpl %r12d,%edi                        # Compares coordinate to first parameter (Checks if container is the wanted x position)
    je check_y                             # Jumps to next coordinate because x corresponded to the wanted position
    decq %r11                              # If x did not correspond decrements the number of containers
    addq $DATA_SIZE, %rbx                  # Goes to next container
    jmp loop                               # Repeats process

    
    check_y:
    movl y(%rbx), %r8d                     # Moves value of rbx offseted by 8 bytes to r8d register (Coordinate y of container)
    cmpl %r8d,%esi                         # Compares coordinate to second parameter (Checks if container is the wanted y position)
    je check_z                             # goes to check 
    decq %r11                              # If y did not correspond decrements the number of containers
    addq $DATA_SIZE, %rbx                  # Goes to next container
    jmp loop                               # Repeats process
    
    
    check_z:                               
    movl z(%rbx), %r9d                     # Moves value of rbx offseted by 12 bytes to r9d register (Coordinate z of container)
    cmpl %r9d,%edx                         # Compares coordinate to third parameter (Checks if container is the wanted z position)
    je check_temperature                   # If all the coordinates match then we jump to see if it's refrigerated or not
    decq %r11                              # If z did not correspond decrements the number of containers
    addq $DATA_SIZE, %rbx                  # Goes to next container
    jmp loop                               # Repeats process
    
    
    check_temperature:
    movl refrigeration(%rbx), %r10d        # Moves value of rbx offseted by 88 bytes to r10d register (Refrigeration situation)
    cmpl $1, %r10d                         # Compares refrigeration situation (1- is refrigerated / 0- not refrigerated)
    je refrigerated                        # Jumps to refrigerated if the register equals 1
    movq $0, %rax                          # Puts 0 in rax  container if it's not refrigerated (returns 0)
    jmp end                                 
    
   
    refrigerated:
    movq $1, %rax                          # Puts 1 in rax  container if it's refrigerated (returns 1)
    jmp end             
   
end:
    # Epilogue
	movq %rbp , %rsp                       # Retrieve the original rsp value
	popq %rbp                              # Restore the original rbp value
    ret
