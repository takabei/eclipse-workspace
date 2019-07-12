package cn.gbf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//����Ϣ���м���
public class Md5Utils {//加密
	public static String md5(String message)  {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
        md.update(message.getBytes());  
        byte b[] = md.digest();  

        int i;  
        StringBuffer buf = new StringBuffer("");  
        for (int offset = 0; offset < b.length; offset++) {  
            i = b[offset];  
            if (i < 0)  
                i += 256;  
            if (i < 16)  
                buf.append("0");  
            buf.append(Integer.toHexString(i));  
        }  
        //32λ����  
        return buf.toString(); 
	}
}
