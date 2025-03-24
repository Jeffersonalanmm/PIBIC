compile:
	cp chatGPT.python3 chatGPT.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO chatGPT.py 10" Python chatGPT

run:
	python3 -OO chatGPT.py 10

mem:
	/usr/bin/time -v python3 -OO chatGPT.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO chatGPT.py 10