compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 mixtral-8x7b-32768.c -o mixtral-8x7b-32768_run -lm

measure:
	sudo modprobe msr
	sudo ../RAPL/main "./mixtral-8x7b-32768_run 1000" C mixtral-8x7b-32768

run:
	./mixtral-8x7b-32768_run 1000

mem:
	/usr/bin/time -v ./mixtral-8x7b-32768_run 1000
