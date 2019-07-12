'''
Created on 2019年7月3日

@author: liuyi
'''
class InvalidRadiusException(RuntimeError):
    def __init__(self, radius):
        super().__init__()
        self.radius = radius