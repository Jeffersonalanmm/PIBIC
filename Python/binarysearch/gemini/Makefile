compile:
	cp gemini.python3 gemini.py

measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 -OO -OO gemini.py 1000" Python gemini

run:
	python3 -OO -OO gemini.py 1000

mem:
	/usr/bin/time -v python3 -OO -OO gemini.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO -OO gemini.py 1000