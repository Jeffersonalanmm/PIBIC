compile:
	cp theAlgorithms.python3 theAlgorithms.py

measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 -OO theAlgorithms.py 1000" Python theAlgorithms

run:
	python3 -OO theAlgorithms.py 1000

mem:
	/usr/bin/time -v python3 -OO theAlgorithms.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO theAlgorithms.py 10