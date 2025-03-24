compile:
	cp amazonQ.python3 amazonQ.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO amazonQ.py 10" Python amazonQ

run:
	python3 -OO amazonQ.py 10

mem:
	/usr/bin/time -v python3 -OO amazonQ.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO amazonQ.py 10