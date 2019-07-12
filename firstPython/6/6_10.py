'''
Created on 2019年7月2日

@author: liuyi
'''
def main():
    print(min(min(5,6), min(51,6)))

def min(n,m):
    s = n
    if m < s:
        s = m
main()