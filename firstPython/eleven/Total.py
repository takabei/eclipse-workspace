'''
Created on 2019年7月3日

@author: liuyi
'''
from eleven.initList import matrix
def main():
    m = matrix
    
    total = 0
    print("获取数组的总和：")
    for row in m:
        for value in row:
            total += value
    print("total = ", total)
    print("m 的行长度：",len(m))
    print("m 的列长度：", len(m[0]), end = "\n\n")
    
    print("获取每列的总和：")
    for column in range(len(m[0])):
        total = 0
        for row in range(len(m)):
            total += m[row][column]
        print("第", column, "列的总和为:", total)
main()