'''
Created on 2019年7月3日

@author: liuyi
'''
# t = lambda:1
# def get_y(a,b):
#     return lambda x : a * x + b
# def get_x():
#     return 99
# y1 = get_y(1,1)
# print(get_x())
# print(get_y(1,1))
# print(y1(2))
# # print('t:{0}'.format(t))
# # print('t2{0}'.format(t))
# # 
# # print('t&{0}'.format(t))
# x, y = 2,1
# print(y)
# 
# list1 = [3,5,-4,-1,0,-2,-6]
# print(sorted(list1, key=lambda x: abs(x)))
def inc(x):
    return x + 10
l = [1,2,3]
print(map(inc,l))