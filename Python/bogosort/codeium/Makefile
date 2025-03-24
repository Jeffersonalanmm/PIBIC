compile:
	cp codeium.python3 codeium.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO codeium.py 10" Python codeium

run:
	python3 -OO codeium.py 10

mem:
	/usr/bin/time -v python3 -OO codeium.py 10

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO codeium.py 10