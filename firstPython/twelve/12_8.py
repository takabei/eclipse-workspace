'''
Created on 2019年7月3日

@author: liuyi
'''
class A:
    def __init__(self, i = 0):
        self.i = i
    
    def m1(self):
        self.i += 1
    def __str__(self):
        return str(self.i)
x = A(8)
print(x)