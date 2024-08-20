measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 theAlgorithms.py 1000" Python theAlgorithms

run:
	python3 theAlgorithms.py 1000

mem:
	/usr/bin/time -v python3 theAlgorithms.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 theAlgorithms.py 10