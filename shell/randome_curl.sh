#!/bin/bash

while :
do

  RESULT=$(($RANDOM % 3))
  echo '今回の値は' $RESULT

  if [ $RESULT -eq 1 ]; then 

    curl http://localhost:8080/operation/sleep 
    echo 'sleep process executed.';

  elif [ $RESULT -eq 2 ]; then

    curl http://localhost:8080/operation/memory
    echo 'memory process executed.';

  else

    curl http://localhost:8080/hello
    echo 'hello process executed.';
  fi
done

