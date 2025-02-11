compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 deepseek-r1-distill-llama-70b.c -o deepseek-r1-distill-llama-70b_run -lm

run:
	./deepseek-r1-distill-llama-70b_run 1000

mem:
	/usr/bin/time -v ./deepseek-r1-distill-llama-70b_run 1000
