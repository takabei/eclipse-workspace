'''
Created on 2019年7月3日

@author: liuyi
'''
def main():
    outfile = open("qwer.txt", "a")
    outfile.write(input("请输入你要添加至文件中的话:"))
    outfile.close()

main()