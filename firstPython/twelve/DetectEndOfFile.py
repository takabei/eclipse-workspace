'''
Created on 2019年7月3日

@author: liuyi
'''
from _pickle import load
def main():
    infile = open("pickle.dat", "rb")
    end_of_file = False
    while not end_of_file:
        try:
            print(load(infile))
        except:#所有异常都能捕获
            end_of_file = True
    infile.close()
main()