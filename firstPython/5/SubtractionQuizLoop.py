'''
Created on 2019年7月2日

@author: liuyi
'''
import random
import time

correctCount = 0
continueLoop = 'Y'
startTime = time.time()

while continueLoop == 'Y':
    number1 = random.randint(1,9)
    number2 = random.randint(1,9)
    
    if number1 < number2:
       number1,number2 = number2,number1
       # number1,number2 = number2,number1 if number1 < number2 else print("number1 = ",number1, "\tnumber2 = ",number2)
    answer = eval(input("What is " + str(number1) + " - " + str(number2) +  "？"))
    
    if number1 - number2 == answer:
        print("You are correct!")
        correctCount += 1
    else:
        print("Your answer is wrong.\n", number1, "-",\
               number2, "is", number1 - number2)
    continueLoop = input("Enter Y to continue and N to quit")