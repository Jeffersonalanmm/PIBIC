compile:
 	cp mixtral-8x7b-37268.python3 mixtral-8x7b-37268.py
 measure:
 	sudo modprobe msr
 	sudo ../../RAPL/main "/usr/local/src/Python-3.6.1/bin/python3.6 -OO mixtral-8x7b-37268.py 1000" Python mixtral-8x7b-37268
 
 run:
 	/usr/local/src/Python-3.6.1/bin/python3.6 -OO mixtral-8x7b-37268.py 1000
 
 mem:
 	/usr/bin/time -v /usr/local/src/Python-3.6.1/bin/python3.6 -OO mixtral-8x7b-37268.py 1000