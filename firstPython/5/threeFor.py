'''
Created on 2019年7月2日

@author: liuyi
'''
import time
startTime = time.time()
for i in range(10):
    for j in range(100):
        for k in range(1000):
            print("i = ", i, "\tj = ", j, "\tk = ", k)
endTime = time.time()
s = int(endTime - startTime) / 60 
print("s = ", s)