compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 -I/usr/include/apr-1.0 chatGPT.c -o chatGPT_run -lapr-1 -lgomp -lm
	
measure:
	sudo modprobe msr
	sudo ../../RAPL/main "./chatGPT.c 1000" C binarysearch

run:
	./chatGPT.c 1000

mem:
	/usr/bin/time -v ./chatGPT.c 1000