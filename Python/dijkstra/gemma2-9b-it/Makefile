compile:
 	cp gemma2-9b-it.python3 gemma2-9b-it.py
 measure:
 	sudo modprobe msr
 	sudo ../../RAPL/main "/usr/local/src/Python-3.6.1/bin/python3.6 -OO gemma2-9b-it.py 1000" Python gemma2-9b-it
 
 run:
 	/usr/local/src/Python-3.6.1/bin/python3.6 -OO gemma2-9b-it.py 1000
 
 mem:
 	/usr/bin/time -v /usr/local/src/Python-3.6.1/bin/python3.6 -OO gemma2-9b-it.py 1000