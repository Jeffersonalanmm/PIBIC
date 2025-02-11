compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 llama-3.2-90b-vision-preview.c -o llama-3.2-90b-vision-preview_run -lm

measure:
	sudo modprobe msr
	sudo ../RAPL/main "./llama-3.2-90b-vision-preview_run 1000" C llama-3.2-90b-vision-preview

run:
	./llama-3.2-90b-vision-preview_run 1000

mem:
	/usr/bin/time -v ./llama-3.2-90b-vision-preview_run 1000
