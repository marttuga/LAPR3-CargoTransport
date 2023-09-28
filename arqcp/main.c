#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "container_exists.h"
#include "slots_vehicle.h"
#include "number_occupied.h"
#include "is_refrigerated.h"

#define NUM_CONTAINERS 3

typedef struct{                     // K = 4 
    int container_id;               // 4 bytes   0-3
    int x;                          // 4 bytes   4-7
    int y;                          // 4 bytes   8-11
    int z;                          // 4 bytes   12-15
    char inner_material[20];        // 20 bytes  16-35
    float inner_thickness;          // 4 bytes   36-39
    char middle_material[20];       // 20 bytes  40-59
    float middle_thickness;         // 4 bytes   60-63
    char outer_material[20];        // 20 bytes  64-83
    float outer_thickness;          // 4 bytes   84-87
    int refrigeration;              // 4 bytes   88-91 
    float height;                   // 4 bytes   92-95
    float length;                   // 4 bytes   96-99
    float width;                    // 4 bytes   100-103
    float temperature;              // 4 bytes   104-107
    float inner_resistivity;        // 4 bytes   108-111
    float middle_resistivity;       // 4 bytes   112-115
    float outer_resistivity;        // 4 bytes   116-119
} Container;                        // total bytes = 120

//Container containers[NUM_CONTAINERS];
 Container* containers_ptr;
int num_containers_atual;
int size_matrix = 1000;
int num_positions = 0;
int energyGenerationUnits=0;
int counter=0;


/*US410*/
/*Fuction that calculates the energy to supply to a refrigerated container*/
float  energyToSupply(int x_value,int y_value, int z_value){
	float areaContainer = 0.0;   //area of the container
    float intResistence = 0.0;   // resistence of the interior layer of the container wall
    float midResistence = 0.0;   // resistence of the mid layer of the container wall
    float extResistence = 0.0;   // resistence of the exterior layer of the container wall
    float totalResistenceContainer = 0.0;  // resistence total of the of the container
    float energy = 0.0;          //energy to supply

	for(int i=0; i<num_containers_atual; i++){
		if((containers_ptr[i].x==x_value) && (containers_ptr[i].y==y_value) && (containers_ptr[i].z==z_value)){
            areaContainer = (2 * containers_ptr[i].length * containers_ptr[i].height) + (4 * containers_ptr[i].length * containers_ptr[i].height);
            intResistence = containers_ptr[i].inner_thickness/(containers_ptr[i].inner_resistivity*areaContainer);
            midResistence = containers_ptr[i].middle_thickness/(containers_ptr[i].middle_resistivity*areaContainer);
            extResistence = containers_ptr[i].outer_thickness/(containers_ptr[i].outer_resistivity*areaContainer);
            totalResistenceContainer = intResistence + midResistence + extResistence;
            energy = ((20-containers_ptr[i].temperature)/totalResistenceContainer) * 3600;   
        }
    }
    	return energy;
}

/*Fuction that calls another assembly function that checks if container
  is refrigerated or not (return 1 if it is and 0 if not)*/
 float checkRefrigeration(int x_value,int y_value, int z_value){
	
	float energyToSupply();
	
	if(is_refrigerated(x_value,y_value,z_value)==1){   
        //calling the us410 part1 function to check if is refrigerated to calculate the energy
		
		return energyToSupply(x_value,y_value,z_value);
		
	}

	return 0;

} 

/*US411*/
/*Fuction that calls us410 function energyToSupply to check if the chosen number
of generators produce enough energy to mantain the temperature of the
 refrigerated containers */
void allertEnergyNotSufficient(int energyGenerationUnits){
    float totalEnergy=0;         //necessary energy for all containers
    float energyGenerators=0;    //energy produced by the generators
    for(int i = 0; i < num_containers_atual; i++){
        if(containers_ptr[i].refrigeration==1){
            totalEnergy += energyToSupply(containers_ptr[i].x,containers_ptr[i].y,containers_ptr[i].z);
            counter++;           //number of refrigerated containers
        }
    }
    energyGenerators= energyGenerationUnits * 25 *3600;    //instead of 25 it was 75000 however it was too high so an alert was always sent and 3600 (1 hour voyage)
    printf("\nEnergy needed for %d refrigerated containers: %.2fJ\n", counter,totalEnergy);
    printf("\nEnergy sourced by %d generators: %.2fJ\n", energyGenerationUnits,energyGenerators);
    if (energyGenerators < totalEnergy)
    {
        printf("\nFor %d energy generation units it's not possible to supply all the refrigerated containers during an hour.\n", counter);
    }
}

/*US315*/
/* function that calls assembly declared function to check wether a given 
    position contains container or not
    returns 0 if false
    returns 1 if true
*/
int container_position(int ptr){

    int exists = 0;

    exists = container_exists(&ptr);

    return exists;
}

/*US314*/
/* function that calls assembly declared function
returns an eight-byte value, where the number of free
slots is placed in the four most significant bytes and the number of
occupied slots in the four least significant bytes.
*/
void slots_situation(int *ptr){
    long *situation;
    long res = slots_vehicle(ptr);
    situation = &res;

    int *x = (int *)situation;
    
	printf("The number of free slots is: %d and the number of occupied slots is: %d\n", *(x + 0), *(x + 1));
}

/*US316*/
/*determines the total number of occupied slots*/
int total_occupied(int *ptr){
    int occupied = 0;

    occupied = number_occupied(ptr);
    
    return occupied;
}

void print_array(Container container){
    printf("%d; %d; %d; %d; %s; %.2f; %s; %.2f; %s; %.2f; %d; %.2f; %.2f; %.2f; %.2f; %.3f; %.3f; %.3f\n", container.container_id, container.x, container.y, container.z,
    container.inner_material, container.inner_thickness, container.middle_material, container.middle_thickness, container.outer_material, container.outer_thickness,
    container.refrigeration, container.height, container.width, container.length, container.temperature, container.inner_resistivity, container.middle_resistivity, container.outer_resistivity);
}

int main(void){

    //cria a area de memory para o array de estruturas, e reserva o espaco na memoria
    containers_ptr = malloc(NUM_CONTAINERS * sizeof(Container));
    if(containers_ptr == NULL){
        perror("Error reserving memory.\n");
        exit(-1);
    }

    //opens the file
    FILE *file;
    file = fopen("container_info.csv", "r");
    if(file == 0){
        printf("Error opening container_info.csv file\n");
        exit(-1);
    }
    char line[1000];
    int i = 0, pos = 0;
    num_containers_atual = NUM_CONTAINERS;
    
    // le do ficheiro, e coloca a struct no array
    while(fgets(line, 100, file) != NULL){
        
        // caso hajam mais contentores que os inicialmente previstos, realloc um novo espacao
        if(pos >= NUM_CONTAINERS){
            
            Container* containers_ptr_tmp = realloc(containers_ptr, (pos + 1) * sizeof(Container)); 
            if(containers_ptr_tmp == NULL){
                perror("Error reallocating memory space");
                exit(-1);
            }
            containers_ptr = containers_ptr_tmp;

            // le do ficheiro e coloco na posicao do array
            fscanf(file, "%d;%d;%d;%d;%[^;\n];%f;%[^;\n];%f;%[^;\n];%f;%d;%f;%f;%f;%f;%f;%f;%f", &(containers_ptr[i].container_id), &(containers_ptr[i].x),&(containers_ptr[i].y),&(containers_ptr[i].z), 
            containers_ptr[i].inner_material, &(containers_ptr[i].inner_thickness), containers_ptr[i].middle_material, &(containers_ptr[i].middle_thickness), containers_ptr[i].outer_material, &(containers_ptr[i].outer_thickness),
            &containers_ptr[i].refrigeration, &(containers_ptr[i].height), &(containers_ptr[i].width), &(containers_ptr[i].length), &(containers_ptr[i].temperature), &(containers_ptr[i].inner_resistivity), &(containers_ptr[i].middle_resistivity),&(containers_ptr[i].outer_resistivity));

            // incrementa o numero total de containers
            num_containers_atual++;
            //incrementa o numero extra de containers
            pos++;
            // "incrementa" no pointer
            i++;

        } else{
            // le do ficheiro e coloco na posicao do array
            fscanf(file, "%d;%d;%d;%d;%[^;\n];%f;%[^;\n];%f;%[^;\n];%f;%d;%f;%f;%f;%f;%f;%f;%f", &(containers_ptr[i].container_id), &(containers_ptr[i].x),&(containers_ptr[i].y),&(containers_ptr[i].z), 
            containers_ptr[i].inner_material, &(containers_ptr[i].inner_thickness), containers_ptr[i].middle_material, &(containers_ptr[i].middle_thickness), containers_ptr[i].outer_material, &(containers_ptr[i].outer_thickness),
            &containers_ptr[i].refrigeration, &(containers_ptr[i].height), &(containers_ptr[i].width), &(containers_ptr[i].length), &(containers_ptr[i].temperature), &(containers_ptr[i].inner_resistivity), &(containers_ptr[i].middle_resistivity),&(containers_ptr[i].outer_resistivity));

            //incrementa o numero extra de containers
            pos++;
            // "incrementa" no pointer
            i++;
        } 
    }

    // array that contains all the positions addresses
    int positions_pointers[1000];
    int index = 0;

    int x_value;
    int y_value;
    int z_value;
    printf("Choose the operation:\n");
    printf("1 - US314; 2 - 315; 3 - US316; 4 - US409; 5 - US410; 6 - US411\n");
    int opt;
    scanf("%d", &opt);

    switch (opt)
    {
    case 1:

        //slots_situation(matrix);
    
        break;
    case 2:
        //US315
       
        printf("Insert x position:\n");
        scanf("%d", &x_value);
        printf("Insert y position:\n");
        scanf("%d", &y_value);
        printf("Insert z position:\n");
        scanf("%d", &z_value);

        // prints result
        //printf("%d\n", container_position(matrix[x_value][y_value][z_value]));
        break;
    case 3:

        printf("How many positions do you wish to introduce?\n");
        scanf("%d", &num_positions);  

        for(i = 0; i < num_positions; i++){
            printf("\n");
            printf("Insert x position:\n");
            scanf("%d", &x_value);
            printf("Insert y position:\n");
            scanf("%d", &y_value);
            printf("Insert z position:\n");
            scanf("%d", &z_value);

            // gets position address and adds to array
            //int *temp = &matrix[x_value][y_value][z_value];
            //positions_pointers[index] = temp;

            //increments array index
            index++;
        }

        // calls C function, receiving the array that contains all the addresses of the wanted positions
        printf("The total of occupied slots is: %d\n", total_occupied(positions_pointers));
        break;
    case 4:

        for(i = 0; i < num_containers_atual; i++){
            print_array(containers_ptr[i]);
        }

        break;
    case 5:

        //US410   
        printf("\nInsert x position:\n");
        scanf("%d", &x_value);
        printf("Insert y position:\n");
        scanf("%d", &y_value);
        printf("Insert z position:\n");
        scanf("%d", &z_value);

        //Prints result
        printf("\nRefrigeration situation: ");
        printf("%d\n\n", is_refrigerated(x_value,y_value,z_value));
        printf("Energy to supply: %.2fJ\n\n", checkRefrigeration(x_value,y_value,z_value));
        break;
        
    case 6:
    //US411   
        
        printf("\nNumber of energy generator units:\n");
        scanf("%d", &energyGenerationUnits);
        allertEnergyNotSufficient(energyGenerationUnits);
        break;
    }
    
    free(containers_ptr);
    fclose(file);

    return 0;

}