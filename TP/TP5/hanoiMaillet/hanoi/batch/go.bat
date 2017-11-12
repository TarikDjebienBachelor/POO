copy manifest-ex ..
copy Hanoi.png ..\docs
cd ..
javac -classpath src src/Hanoi.java -d classes
javac -classpath src src/HanoiIt.java -d classes
javac -classpath src src/HanoiManuel.java -d classes
javac -classpath src src/ChoixHanoi2.java -d classes
java -classpath classes Hanoi 4
cd src
javadoc -d ../docs -subpackages util hanoi.java HanoiIt.java HanoiManuel.java ChoixHanoi2.java
cd ..
@pause
jar cvfm hanoi.jar manifest-ex batch src docs -C classes .
java -classpath hanoi.jar HanoiIt 5
java -jar hanoi.jar 
@pause
@echo pour voir : jar tvf Hanoi.jar
@echo pour extraire : jar xvf Hanoi.jar
@pause
rem schema Uml réalisé avec http://sourceforge.net/projects/umlsculptor/