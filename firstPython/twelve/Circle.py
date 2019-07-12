'''
Created on 2019年7月3日

@author: liuyi
'''
from twelve.GeometricObject import GeometricObject
import math
class Circle(GeometricObject):
    def __init__(self, radius = 1):
        super().__init__()
        self.__radius = radius
    
    def getRadius(self):
        return self.__radius
    
    def setRadius(self, radius):        
        if radius < 0:
            raise RuntimeError("Negative redius")
        else:
            self.__radius = radius
    
    def getArea(self):
        return self.__radius ** 2 * math.pi
    
    def getDiameter(self):
        return 2 * self.__radius
    
    def getPerimeter(self):
        return 2 * self.__radius * math.pi
    
    def printCricle(self):
        print(self.__str__() + " radius: " + str(self.getRadius()))
        
    def __str__(self):
        return super().__str__() + " radius: " + str(self.__radius)
        