main: main.o container_exists.o slots_vehicle.o number_occupied.o is_refrigerated.o
	gcc main.o container_exists.o slots_vehicle.o number_occupied.o is_refrigerated.o -o main

main.o: main.c container_exists.h slots_vehicle.h number_occupied.h is_refrigerated.h
	gcc -g -Wall -c main.c -o main.o

container_exists.o: container_exists.s
	gcc -g -Wall -c container_exists.s -o container_exists.o

slots_vehicle.o: slots_vehicle.s
	gcc -g -Wall -c slots_vehicle.s -o slots_vehicle.o

number_occupied.o: number_occupied.s
	gcc -g -Wall -c number_occupied.s -o number_occupied.o

is_refrigerated.o:  is_refrigerated.s
	gcc -g -Wall -c  is_refrigerated.s -o  is_refrigerated.o
	
debug:
	gdb -tui ./${EXEC}

vg:
	valgrind ./${EXEC}

clean:
	rm -f *.o main

run: main
	./main
