compile:
	cp Codeium.python3 Codeium.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO Codeium.py 1000" Python Codeium

run:
	python3 -OO Codeium.py 1000

mem:
	/usr/bin/time -v python3 -OO Codeium.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO Codeium.py 10