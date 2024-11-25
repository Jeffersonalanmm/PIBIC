compile:
	cp blackbox.python3 blackbox.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO blackbox.py 1000" Python blackbox

run:
	python3 -OO blackbox.py 1000

mem:
	/usr/bin/time -v python3 -OO blackbox.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO blackbox.py 1000