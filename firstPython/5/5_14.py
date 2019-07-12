'''
Created on 2019年7月2日

@author: liuyi
'''
sum = 0
for i in range(4):
    if i % 3 == 0:
        continue
    sum += i
print(sum)

i = 0
sum = 0
while i < 4:
    if i % 3 == 0:
        continue
    sum += i
print(sum)