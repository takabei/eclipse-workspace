'''
Created on 2019年7月2日

@author: liuyi
'''
def reverse(lst):
    result = []
    
    for element in lst:
        result.insert(0,element)#在指定位置0处插入元素
    
    return result
def main():
    list1 = range(10)
    print(reverse(list1))
main()