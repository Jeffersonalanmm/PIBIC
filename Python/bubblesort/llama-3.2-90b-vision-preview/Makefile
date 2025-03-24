compile:
 	cp llama-3.2-90b-vision-preview.python3 llama-3.2-90b-vision-preview.py
 measure:
 	sudo modprobe msr
 	sudo ../../RAPL/main "/usr/local/src/Python-3.6.1/bin/python3.6 -OO llama-3.2-90b-vision-preview.py 1000" Python llama-3.2-90b-vision-preview
 
 run:
 	/usr/local/src/Python-3.6.1/bin/python3.6 -OO llama-3.2-90b-vision-preview.py 1000
 
 mem:
 	/usr/bin/time -v /usr/local/src/Python-3.6.1/bin/python3.6 -OO llama-3.2-90b-vision-preview.py 1000