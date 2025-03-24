compile:
 	cp deepseek-r1-distill-llama-70b.python3 deepseek-r1-distill-llama-70b.py
 measure:
 	sudo modprobe msr
 	sudo ../../RAPL/main "/usr/local/src/Python-3.6.1/bin/python3.6 -OO deepseek-r1-distill-llama-70b.py 10" Python deepseek-r1-distill-llama-70b
 
 run:
 	/usr/local/src/Python-3.6.1/bin/python3.6 -OO deepseek-r1-distill-llama-70b.py 10
 
 mem:
 	/usr/bin/time -v /usr/local/src/Python-3.6.1/bin/python3.6 -OO deepseek-r1-distill-llama-70b.py 10