'''
Created on 2019年7月3日

@author: liuyi
'''
infile = open("qwer.txt", "r")
line = infile.readline()
while line != "":
    print(line, end = "")
    line = infile.readline()
print(infile.readline())
print()
infile.close()

infile = open("qwer.txt", "r")
for line in infile.readlines():
    print(line, end = "")
print()
infile.close()

infile = open("qwer.txt", "r")
for line in infile:
    print(line, end = "")
print()
infile.close()
