compile:
	cp llama-3.2-90b-vision-preview.python3 llama-3.2-90b-vision-preview.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO llama-3.2-90b-vision-preview.py 1000" Python llama-3.2-90b-vision-preview

run:
	python3 -OO llama-3.2-90b-vision-preview.py 1000

mem:
	/usr/bin/time -v python3 -OO llama-3.2-90b-vision-preview.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO llama-3.2-90b-vision-preview.py 10