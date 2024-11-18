compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 -I/usr/include/apr-1.0 thealgorithms.c -o thealgorithms_run -lapr-1 -lgomp -lm
	
measure:
	sudo modprobe msr
	sudo ../../RAPL/main "./thealgorithms.c 1000" C queue

run:
	./thealgorithms.c 1000

mem:
	/usr/bin/time -v ./thealgorithms.c 1000