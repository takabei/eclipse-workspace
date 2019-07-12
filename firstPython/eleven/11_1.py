'''
Created on 2019年7月3日

@author: liuyi
'''
from random import randint
list1 = []
print("foreach(假的)：")
for i in range(3):
    list11 = []
    for n in range(randint(1,5)):
        list11.append(0)
    list1.append(list11)
print(list1)

list2 = []
print("数组下标：")
for row in range(3):
    list2.append([])
    for column in range(4):
        list2[row].append(column)
print(list2)

# list3 = [3][4]#IndexError: list index out of range
# print(list3)