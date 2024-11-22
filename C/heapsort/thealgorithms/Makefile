compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 -I/usr/include/apr-1.0 thealgorithms.c -o thealgorithms_run -lapr-1 -lgomp -lm
	
measure:
	sudo modprobe msr
	sudo ../../RAPL/main "./thealgorithms_run 1000" C heapsort

run:
	./thealgorithms_run 1000

mem:
	/usr/bin/time -v ./thealgorithms_run 1000