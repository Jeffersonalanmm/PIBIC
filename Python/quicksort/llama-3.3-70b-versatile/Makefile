compile:
	cp llama-3.3-70b-versatile.python3 llama-3.3-70b-versatile.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO llama-3.3-70b-versatile.py 1000" Python llama-3.3-70b-versatile

run:
	python3 -OO llama-3.3-70b-versatile.py 1000

mem:
	/usr/bin/time -v python3 -OO llama-3.3-70b-versatile.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO llama-3.3-70b-versatile.py 1000