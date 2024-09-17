measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 -OO Gemini.py 1000" Python Gemini

run:
	python3 -OO Gemini.py 1000

mem:
	/usr/bin/time -v python3 -OO Gemini.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO Gemini.py 10