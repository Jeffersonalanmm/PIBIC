compile:
 	cp llama-3.3-70b-versatile.python3 llama-3.3-70b-versatile.py
 measure:
 	sudo modprobe msr
 	sudo ../../RAPL/main "/usr/local/src/Python-3.6.1/bin/python3.6 -OO llama-3.3-70b-versatile.py 1000" Python llama-3.3-70b-versatile
 
 run:
 	/usr/local/src/Python-3.6.1/bin/python3.6 -OO llama-3.3-70b-versatile.py 1000
 
 mem:
 	/usr/bin/time -v /usr/local/src/Python-3.6.1/bin/python3.6 -OO llama-3.3-70b-versatile.py 1000