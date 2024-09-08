measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 amazonQ.py 1000" Python amazonQ

run:
	python3 amazonQ.py 1000

mem:
	/usr/bin/time -v python3 amazonQ.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 amazonQ.py 10