'''
Created on 2019年7月3日

@author: liuyi
'''
from random import randint
matrix = []

numberOfRows = eval(input("请输入二维数组的行数："))
numberOfColumns = eval(input("请输入二维数组的列数："))

for row in range(numberOfRows):
    matrix.append([])
    for columns in range(numberOfColumns):
#         value = eval(input("请输入元素："))
#         matrix[row].append(value)
          matrix[row].append(randint(0,99))
print(matrix)