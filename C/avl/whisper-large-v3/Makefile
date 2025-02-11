compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 whisper-large-v3.c -o whisper-large-v3_run -lm

measure:
	sudo modprobe msr
	sudo ../RAPL/main "./whisper-large-v3_run 1000" C whisper-large-v3

run:
	./whisper-large-v3_run 1000

mem:
	/usr/bin/time -v ./whisper-large-v3_run 1000
