#!/bin/bash
if [ -z "$1" ]
  then
    echo "usage: ktc <kotlin_file>"
    exit 1
fi
file=$1
filename=${file%%.*}
kotlinc ${filename}.kt -include-runtime -d ${filename}.jar
java -jar ${filename}.jar