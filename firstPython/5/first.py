'''
Created on 2019年7月2日

@author: liuyi
'''
count = 0
while count < 100:
    print("count = " + str(count))
    print("count = ", count)
    #java中的+可以将字符串和字面量连接成字符串
    #python中的+只能够连接两个字符串
    #str()将字面量转换为字符串
    count += 1
    