compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 -I/usr/include/apr-1.0 gemini.c -o gemini_run -lapr-1 -lgomp -lm
	
measure:
	sudo modprobe msr
	sudo ../../RAPL/main "./gemini_run 1000" C queue

run:
	./gemini_run 1000

mem:
	/usr/bin/time -v ./gemini_run 1000