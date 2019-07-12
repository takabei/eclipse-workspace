'''
Created on 2019年7月2日

@author: liuyi

'''
import math

#eval()用于将字符串转换为字面量(直接出现在程序中的常量值)
radius = eval(input("现在立马给老子输入数字，记住是数字！:"))
if radius >= 0:
    area = radius ** 2 * math.pi
    print("the area for thr circle of radius", radius, "is", area, end = "\t")
    #end = "\t" 用于不换行输出print()内容
    print("test")
else:
    print("去你吗的")