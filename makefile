# variable for java compiler
JC = javac
J = java

# damage control
.SUFFIXES: .java .class

# target for creating .class from .java in format:
#	.original_extention.target_extention:
#		rule
.java.class:
	$(JC) $*.java
	
# macro for each java source file
CLASSES = \
	Chaos.java \
	ChaosGUI.java \
	main.java
	
# default target definition
default: classes

classes: $(CLASSES:.java=.class)

samplerun:
	$(J) main 10 200 100

clean:
	$(RM) *.class
	
