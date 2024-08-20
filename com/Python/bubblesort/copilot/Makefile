measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 copilot.py 1000" Python copilot

run:
	python3 copilot.py 1000

mem:
	/usr/bin/time -v python3 copilot.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 copilot.py 10