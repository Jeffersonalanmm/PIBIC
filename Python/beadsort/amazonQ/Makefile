compile:
	cp amazonq.python3 amazonq.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO amazonq.py 1000" Python amazonq

run:
	python3 -OO amazonq.py 1000

mem:
	/usr/bin/time -v python3 -OO amazonq.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO amazonq.py 10