compile:
	cp thealgorithms.python3 thealgorithms.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO thealgorithms.py 10" Python thealgorithms

run:
	python3 -OO thealgorithms.py 10

mem:
	/usr/bin/time -v python3 -OO thealgorithms.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO thealgorithms.py 10