'''
Created on 2019年7月3日

@author: liuyi
'''
def main():
    filename = input("请输入你要查询的文件的名称:")
    
    infile = open(filename + ".txt", "r")
    print("(1)Using read(): ")
    print(infile.read())
    #read()返回全部字符并作为字符串返回
    infile.close()
    
    infile = open(filename + ".txt", "r")
    print("\n(2)Using read(number)")
    bool = 'y'
    while bool == 'y':       
        num = eval(input("请输入你要查询的字符数:"))
        print(infile.read(num))
        bool = input("是否继续查询文件的某些字符数？是 (y)) 否 (n)")
        if bool != 'y':
            infile.close()
main()