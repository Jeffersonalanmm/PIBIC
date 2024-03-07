compile:
	mkdir -p com/avl
	cp blackbox.java com/avl/blackbox.java
	/usr/bin/javac -d . com/avl/blackbox.java

measure:
	sudo modprobe msr
	sudo ../../RAPL/main "/usr/bin/java -Xmx10m com.avl.blackbox 1000" Java binary-trees

run:
	/usr/bin/java -cp . BlackBox

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.blackbox 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.blackbox 1000
