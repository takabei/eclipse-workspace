'''
Created on 2019年7月4日

@author: liuyi
'''
import threading
class FKThread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.i = 0
    def run(self):
        while self.i < 100:
            print(threading.current_thread().getName() + " " + str(self.i))
            self.i += 1
for i in range(100):
    print(threading.current_thread().getName() + " " + str(i))
    if i == 20:
        fkt1 = FKThread()
        fkt1.start()
        
        fkt2 = FKThread()
        fkt2.start()