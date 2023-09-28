.section .data

.section .bss

.section .text
    .global slots_vehicle                    # int slots_vehicle()

slots_vehicle:

    movq $0, %rax
    movq $0, %rdx
    movq $0, %rcx
    movq $0, %rsi
    movq $0, %rbx
    movq size_matrix(%rip), %rcx             # size of matrix[10][10][10]
	
	loop:

        cmpq $0, %rcx                        # checks if it has reached the end of the matrix    
        je end                               # if equal, goes to end

        cmpl $0, (%rdi,%rcx,4)               # gets the value pointed at the index and copies into esi 
		jg occupied                          # if is greater than 0, then container_ID exists
		
		incl %ebx                            # EBX = EBX + 1
        decq %rcx
		# addq $8, %rdi                      # increments pointer
		jmp loop                             # goes to next iteration. ecx--   

	occupied:
		incl %edx							 # EDX = EDX + 1
        decq %rcx                            # ecx--
        # addq $8, %rdi                      # increments the position in the matrix  
		jmp loop
        
end:
    movl %edx, %eax                          # copies the number of occupied slots to eax
    shlq $5, %rax                            # shifts 2^5 bits (32) to the left, leaving the 4 least significant bytes with the occupied slots
    movl %ebx, %eax                          # copies the number of free slots to eax, leaving the most significant bytes with the free slots
    ret
