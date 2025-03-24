compile:
	cp rosetta.python3 rosetta.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO rosetta.py 10" Python rosetta

run:
	python3 -OO rosetta.py 10

mem:
	/usr/bin/time -v python3 -OO rosetta.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO rosetta.py 10