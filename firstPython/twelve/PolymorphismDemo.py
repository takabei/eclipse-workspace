'''
Created on 2019年7月3日

@author: liuyi
'''
from twelve.Circle import Circle
from twelve.RectangleFromGeometricObject import Rectanhle
def main():
    c = Circle(4)
    r = Rectanhle(width = 1, height = 3)
    displayObject(c)
    displayObject(r)
#     displayObject("00")
#     print("Are the circle and rectangle the same size?", 
#           isSameArea(c,r))
    
def displayObject(g):
    print(g.__str__())
    if isinstance(g, Circle):
        print("Diameter is ", g.getDiameter())
    elif isinstance(g, Rectanhle):
        print("width is ", g.getWidth())
        print("Height is ", g.getHeight())

def isSameArea(g1, g2):
    return g1.getArea() == g2.getArea()
main()