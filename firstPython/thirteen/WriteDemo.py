'''
Created on 2019年7月3日

@author: liuyi
'''
from os.path import isfile
def main():
    filename = input("请输入你要新建的文件名字：")
    if isfile(filename + ".txt"):
        print("文件已经存在")
    else:
        outfile = open(filename + ".txt", "w")
        outfile.write("liuyi\n")
        outfile.write("test\t\n")
        outfile.write("qwer\n")
        outfile.write("liuyi\n")
        outfile.write("刘义\n")
        outfile.close()
        print("恭喜你文件" + filename + "已经创建完毕")
main()