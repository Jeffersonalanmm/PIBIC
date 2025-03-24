compile:
	cp BlackBox.python3 BlackBox.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO BlackBox.py 10" Python BlackBox

run:
	python3 -OO BlackBox.py 10

mem:
	/usr/bin/time -v python3 -OO BlackBox.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO BlackBox.py 10