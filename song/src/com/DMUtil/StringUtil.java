package com.DMUtil;

public class StringUtil {
  public static boolean isEmpty(String type){
	  if(type.equals("")){
		  return true;
	  }else{
		  return false;
	  }
  }
  public static boolean isNotEmpty(String type){
	  //if(!type.equals("")&&type!=null){
	  if(type!=null&&!type.equals("")){
		  return true;
	  }else{
		  return false;
	  }
  }
}
