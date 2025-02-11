compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 gemma2-9b-it.c -o gemma2-9b-it_run -lm

measure:
	sudo modprobe msr
	sudo ../RAPL/main "./gemma2-9b-it_run 1000" C gemma2-9b-it

run:
	./gemma2-9b-it_run 1000

mem:
	/usr/bin/time -v ./gemma2-9b-it_run 1000
