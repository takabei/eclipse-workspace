'''
Created on 2019年7月3日

@author: liuyi
'''
from eleven.initList import matrix
def main():
    m  = matrix
    
    print("第一种遍历：")
    for row in range(len(m)):
        for column in range(len(m[row])):
            print(m[row][column], end = " ")
        print()
        
    print("第二种遍历：")
    for row in m:
        for value in row:
            print(value, end = " ")
        print()
main()