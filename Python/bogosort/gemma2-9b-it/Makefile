compile:
	cp gemma2-9b-it.python3 gemma2-9b-it.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO gemma2-9b-it.py 10" Python gemma2-9b-it

run:
	python3 -OO gemma2-9b-it.py 10

mem:
	/usr/bin/time -v python3 -OO gemma2-9b-it.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO gemma2-9b-it.py 10