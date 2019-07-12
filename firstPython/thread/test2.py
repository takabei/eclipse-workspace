'''
Created on 2019年7月4日

@author: liuyi
'''
import threading
import time
class MusicAndGame1(threading.Thread):
    def __init__(self, name):
        super().__init__()
        self.name = name
    def run(self):
        print("%s begin listen music %s" % (self.name,time.ctime()))
        time.sleep(3)
        print("%s stop listen music %s" % (self.name,  time.ctime()))
        
class MusicAndGame2(threading.Thread):
    def __init__(self, name):
        super().__init__()
        self.name = name
    def run(self):
        print("%s begin listen game %s" % (self.name,time.ctime()))
        time.sleep(3)
        print("%s stop listen game %s" % (self.name,  time.ctime()))    
for i in range(10):
    print(threading.current_thread().getName() + " " + str(i))
    if i == 5:
        t1 = MusicAndGame1("去你吗的")
        t2 = MusicAndGame2("尼玛的")
        t1.start()
        t2.start()