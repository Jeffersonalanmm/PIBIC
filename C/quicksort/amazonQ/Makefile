compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 -I/usr/include/apr-1.0 amazonq.c -o amazonq_run -lapr-1 -lgomp -lm
	
measure:
	sudo modprobe msr
	sudo ../../RAPL/main "./amazonq.c 1000" C quicksort

run:
	./amazonq.c 1000

mem:
	/usr/bin/time -v ./amazonq.c 1000