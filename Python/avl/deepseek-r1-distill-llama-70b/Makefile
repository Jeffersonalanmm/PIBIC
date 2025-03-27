compile:
	cp deepseek-r1-distill-llama-70b.python3 deepseek-r1-distill-llama-70b.py

mem:
	/usr/bin/time -v python3 -OO deepseek-r1-distill-llama-70b.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO deepseek-r1-distill-llama-70b.py 10