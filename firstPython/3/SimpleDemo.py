'''
Created on 2019年7月2日

@author: liuyi
'''
y = eval(input("输入y的值："))
if y > 0 and y - 1 >= 0:
    number = eval(input("Enter an integer:"))
    x = 1
    if number % 5 == 0:
        print("去你吗的")
    else:
        print("呵呵 去你美的")        
else:
    x = 9
print(x)