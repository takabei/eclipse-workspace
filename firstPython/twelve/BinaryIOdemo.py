'''
Created on 2019年7月3日

@author: liuyi
'''
from _pickle import dump, load
def main():
    outfile = open("pickle.dat", "wb")
    dump(45, outfile)
    dump(23.3, outfile)
    dump(list(range(0,99)), outfile)
    outfile.close()
    
    infile = open("pickle.dat", "rb")
    print(load(infile))
    print(load(infile))
    print(load(infile))
    
main()