'''
Created on 2019年7月3日

@author: liuyi
'''
from eleven.initList import matrix
def main():
    m = matrix
    
    maxRow = sum(m[0])
#     indexOfRow = 0
    for i in m:
        print(sum(i))
    for i in m:
        if sum(i) > maxRow:
            maxRow = sum(i)
    print("maxRow = ", maxRow)
main()