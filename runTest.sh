echo 'cleaning..'
rm -f *.class
echo "compiling..."
javac -cp junit-4.10.jar *.java
if [ $? != 0 ] 
	then exit
fi
echo "running tests.."

echo "------------------ACCEPTANCE TEST--------------------------------"

echo "------------------Collection TEST--------------------------------"

java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore CollectionUtilsTest
echo $?

echo "------------------Path TEST--------------------------------"

java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore PathTest
echo $?

echo "------------------Unit TEST--------------------------------"

echo "------------------Path Unit TEST--------------------------------"

java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore PathUnitTest
echo $?

echo "--------------------- COMPLETED ---------------------------------"

rm -f *.class
