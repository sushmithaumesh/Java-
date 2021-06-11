all:
	javac Main.java

run: all
	java Main 
clean:
	rm -f *.class
