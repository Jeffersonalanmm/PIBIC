measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 rosetta.py 1000" Python rosetta

run:
	python3 rosetta.py 1000

mem:
	/usr/bin/time -v python3 rosetta.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 rosetta.py 10