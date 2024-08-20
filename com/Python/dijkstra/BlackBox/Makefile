measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 BlackBox.py 1000" Python BlackBox

run:
	python3 BlackBox.py 1000

mem:
	/usr/bin/time -v python3 BlackBox.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 BlackBox.py 10