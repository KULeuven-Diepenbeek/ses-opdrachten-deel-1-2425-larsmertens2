MAINCLASS = App
JAR = app.jar

compile:
	javac -d ./build *.java

clean:
	rm -R ./build/*

run:
	cd build && java -cp "$(JAR)" $(MAINCLASS)

jar:
	cd build && jar cvfe $(JAR) $(MAINCLASS) *
