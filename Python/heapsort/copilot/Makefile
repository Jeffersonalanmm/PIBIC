compile:
	cp copilot.python3 copilot.py

measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 -OO copilot.py 1000" Python copilot

run:
	python3 -OO copilot.py 1000

mem:
	/usr/bin/time -v python3 -OO copilot.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO copilot.py 10