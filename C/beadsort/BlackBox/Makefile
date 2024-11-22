compile:
	/usr/bin/gcc -pipe -Wall -O3 -fomit-frame-pointer -march=native -fopenmp -D_FILE_OFFSET_BITS=64 -I/usr/include/apr-1.0 BlackBox.c -o BlackBox_run -lapr-1 -lgomp -lm
	
measure:
	sudo modprobe msr
	sudo ../../RAPL/main "./BlackBox_run 1000" C beadsort

run:
	./BlackBox_run 1000

mem:
	/usr/bin/time -v ./BlackBox_run 1000