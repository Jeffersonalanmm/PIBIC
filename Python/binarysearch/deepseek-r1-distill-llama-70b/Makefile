compile:
	cp deepseek-r1-distill-llama-70b.python3 deepseek-r1-distill-llama-70b.py

measure:
	sudo modprobe msr
	sudo ../RAPL/main "python3 -OO deepseek-r1-distill-llama-70b.py 1000" Python deepseek-r1-distill-llama-70b

run:
	python3 -OO deepseek-r1-distill-llama-70b.py 1000

mem:
	/usr/bin/time -v python3 -OO deepseek-r1-distill-llama-70b.py 1000

valgrind:
	valgrind --tool=massif --stacks=yes python3 -OO deepseek-r1-distill-llama-70b.py 10