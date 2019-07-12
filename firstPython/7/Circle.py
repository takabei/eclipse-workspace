'''
Created on 2019年7月2日

@author: liuyi
'''
import math

class Circle:
    #self指向调用方法的对象
    def __init__(self,radius = 1):
        self.radius = radius
    
    def getPerimeter(self):
        return 2 * self.radius * math.pi
    
    def getArea(self):
        return self.radius ** 2 * math.pi
    
    def setRadius(self, radius):
        self.radius = radius
        
    def println(self):
        print(self.getArea())
def main():
    c1 = Circle(5)
    print(c1.radius)
    print(c1.getPerimeter())
main()