

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CHENDaoUtils {
	
	public void transfer(User user, String username, String count) {
		draw(user,count);
		deposit(setUser(username), count);
	}
	
	public void draw(User user, String count) {
		File file = new File(user.getName()+".user");
		BufferedWriter bufferedWriter = null;
		try {			
			double num = Double.parseDouble(user.getCount()) - Double.parseDouble(count);
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("username=" + user.getName() +"\n");
			bufferedWriter.write("password=" + user.getPass() +"\n");
			bufferedWriter.write("count=" + num +"\n");
			user.setCount(""+num);
			System.out.println(user.getName() + " 取款 " + count + " 成功 " + "账户余额 " + num);
			bufferedWriter.flush();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deposit(User user, String count) {
		File file = new File(user.getName()+".user");
		BufferedWriter bufferedWriter = null;
		try {			
			double num = Double.parseDouble(user.getCount()) + Double.parseDouble(count);
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("username=" + user.getName() +"\n");
			bufferedWriter.write("password=" + user.getPass() +"\n");
			bufferedWriter.write("count=" + num +"\n");
			user.setCount(""+num);
			System.out.println(user.getName() + " 存款 " + count + " 成功 " + "账户余额 " + num);
			bufferedWriter.flush();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean createUser(String username, String password) {
		File file = new File(username+".user");
		BufferedWriter bufferedWriter = null;
		try {
			if(!file.exists())
				file.createNewFile();
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("username=" + username +"\n");
			bufferedWriter.write("password=" + password +"\n");
			bufferedWriter.write("count=" + 0 +"\n");
			bufferedWriter.flush();
			return true;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private String setProperty(String str) {
		Pattern p = Pattern.compile("(?<==).*");
		Matcher m = p.matcher(str);
		while(m.find()) {
			return m.group();
		}
		return "";
	}
	
	public User setUser(String username) {
		File file = new File(username+".user");		
		BufferedReader bReader = null;
		User user = null;
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			bReader = new BufferedReader(new FileReader(file));
			String str = "";	
			user = new User();
			while((str = bReader.readLine()) != null) {
				if(str.contains("username")) {
					user.setName(setProperty(str));					
				}else if(str.contains("password")){
					user.setPass(setProperty(str));
				} else if(str.contains("count")) {
					user.setCount(setProperty(str));
				}	
			}
			return user;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public boolean login(String username, String password) {
		User user = setUser(username);
		if(user == null)
			return false;
		if(user != null) {
			return user.getName().equals(username) 
					&& user.getPass().equals(password);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int i = 1;
		int num = 2;
		i = num = 8;
		System.out.println(i + " " + num );
//		CHENDaoUtils chenDaoUtils = new CHENDaoUtils();
		
//		System.out.println(chenDaoUtils.login("陈十七", "111"));
//		chenDaoUtils.createUser("陈十七", "111");
//		System.out.println(chenDaoUtils.login("liuyi","1234"));
//		User user = chenDaoUtils.setUser("liuyi");
//		System.out.println(user);
//		chenDaoUtils.deposit(user, "11111");
//		System.out.println(user);
//		chenDaoUtils.transfer(user, "陈十七", "233");
//		chenDaoUtils.draw(user, "4.0");
		
	}
}
