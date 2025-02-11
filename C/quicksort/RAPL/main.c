#include <stdio.h>
#include <sys/time.h>
#include <math.h>
#include <string.h>
#include "rapl.h"

#define NTIMES 1000

int main(int argc, char **argv) {
    if (argc < 4) {
        fprintf(stderr, "Uso: %s <comando> <linguagem> <teste>\n", argv[0]);
        return 1;
    }
    
    char command[500] = "";
    char path[500] = "../";
    strcat(command, argv[1]);
    strcat(path, argv[2]);
    strcat(path, ".csv");
    
    FILE *fp = fopen(path, "a");
    if (!fp) {
        perror("Erro ao abrir arquivo");
        return 1;
    }
    
    int core = 0;
    rapl_init(core);
    
    for (int i = 0; i < NTIMES; i++) {
        fprintf(fp, "%s ; ", argv[3]);
        
        struct timeval tvb, tva;
        gettimeofday(&tvb, NULL);
        
        rapl_before(fp, core);
        system(command);
        rapl_after(fp, core);
        
        gettimeofday(&tva, NULL);
        double time_spent = (tva.tv_sec - tvb.tv_sec) * 1000000 + (tva.tv_usec - tvb.tv_usec);
        time_spent /= 1000;  // Converte para milissegundos
        
        fprintf(fp, " %.3f \n", time_spent);
    }
    
    fclose(fp);
    return 0;
}