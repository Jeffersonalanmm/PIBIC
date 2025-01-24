compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 llama-3.3-70b-versatile.c -o llama-3.3-70b-versatile_run -lm

measure:
	sudo modprobe msr
	sudo ../RAPL/main "./llama-3.3-70b-versatile_run 1000" C llama-3.3-70b-versatile

run:
	./llama-3.3-70b-versatile_run 1000

mem:
	/usr/bin/time -v ./llama-3.3-70b-versatile_run 1000
