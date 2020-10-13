'''
Created on 2019年7月3日

@author: liuyi
'''
class A:
    def __init__(self, i = 0):
        self.i = i
    def m1(self):
        self.i += 1
    def getI(self):
        return self.i
class B(A):
    def __init__(self, j = 0, i = 1):
        super().__init__(3)
        self.j = j
        self.__i = i
    def m1(self):
        self.i += 1
    def println(self):
        print("A.i = ", super().getI())
def main():
    b = B()
    b.m1()
    print("b.i = ", b.i)
    b.println()
    print("b.j = ", b.j)

main()