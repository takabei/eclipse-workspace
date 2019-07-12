'''
Created on 2019年7月2日

@author: liuyi
'''
from audioop import reverse
def add(x, lst = []):
    if x not in lst:
        lst.append(x)
    return lst

def main():
    list1 = add(1)
    print("list1[] = ",list1)
    
    list2 = add(2)
    reverse(list2)
    print("list2[] = ",list2)
main()