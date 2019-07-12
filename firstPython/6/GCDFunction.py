'''
Created on 2019年7月2日

@author: liuyi
'''
def gcd(n,m):
    gcd = 1
    k = 2
    
    while k <= n and k <= m:
        if n % k == 0 and m % k == 0:
            gcd = k
        k += 1
        
    return  gcd