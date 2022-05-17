# C2K Converter
Converter of C and C++ projects to Kotlin. 

# How to install
Clone this repo with git and run
```
./gradlew jar
```
for UNIX or
```
gradlew.bat jar
```
for Windows

### .jar release:
https://github.com/alf3ratz/converter/releases

# Usage
Run installed app 
```
java -jar [Downloaded release name].jar
```
or command
```
./gradlew run (UNIX)            gradlew.bat run (Windows)
```

Command itself has format
```
c2k [<options>] -o <output directory> -i <cpp.h files>
```
