'''
Created on 2019年7月3日

@author: liuyi
'''
from twelve.GeometricObject import GeometricObject
class Rectanhle(GeometricObject):
    def __init__(self, width = 1, height = 1):
        super().__init__()
        #super.__init()__
            #TypeError: descriptor '__init__' of 'super' object needs an argument
        #python老版本语法 GeometricObject.__init__()
        self.__width = width
        self.__height = height
    
    def getWidth(self):
        return self.__width

    def getHeight(self):
        return self.__height
    
    def setHeight(self, height):
        self.__height = height
    
    def setWidth(self, width):
        self.__width = width
        
    def getArea(self):
        return self.__width * self.__height
    
    def getPerimeter(self):
        return 2 * (self.__width + self.__height)
    
    def __str__(self):
        return super().__str__() + " width: " + \
            str(self.__width) + " height: " + str(self.__height)
    
    
    