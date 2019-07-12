'''
Created on 2019年7月4日

@author: liuyi
'''
import time
import threading
def music(name):
    print("%s begin listen music %s" % (name,time.ctime()))
    time.sleep(3)
    print("%s stop listen music %s" % (name,  time.ctime()))
def game(name):
    print("%s begin listen game %s" % (name,time.ctime()))
    time.sleep(3)
    print("%s stop listen game %s" % (name,  time.ctime()))
print("%s begin listen main %s" % ("刘义",time.ctime()))
t1 = threading.Thread(target = music, args = ("zhang",))
t2 = threading.Thread(target = game, args = ("liuyi",))
t1.start()
t2.start()
print("%s stop listen main %s" % ("刘义",time.ctime()))