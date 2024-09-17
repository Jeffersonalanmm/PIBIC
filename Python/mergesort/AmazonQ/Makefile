measure:
	sudo modprobe msr
	sudo ../../RAPL/main "python3 -OO AmazonQ.py 1000" Python AmazonQ

run:
	python3 -OO AmazonQ.py 1000

mem:
	/usr/bin/time -v python3 -OO AmazonQ.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO AmazonQ.py 10