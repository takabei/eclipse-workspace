'''
Created on 2019年7月2日

@author: liuyi
'''
def main():
    a = A()
    a.print()
    
    b = B(False)
    b.isOn()
class A:
    def __init__(self, str = "Welcome"):
        self.__str = str
    
    def print(self):
        print(self.__str)
class B:
    def __init__(self, on):
        self.__on = not on
    
    def isOn(self):
        self.__play(self.__on)
    
    def __play(self, on):
        print(on)
main()
        