compile:
	mkdir -p com/avl
	cp BlackBox.java com/avl/BlackBox.java
	/usr/bin/javac -d . com/avl/BlackBox.java

measure:
	/usr/bin/java -Xmx10m BlackBox 1000

run:
	/usr/bin/java -cp . BlackBox

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.BlackBox.BlackBox 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.BlackBox.BlackBox 1000
