package com.briup.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * 生成订单编号 
 */  
public class ProduceOrderNo {
	private static long orderNum = 0l;  
    private static String date ;  
      
    public static void main(String[] args) throws InterruptedException {  
        for (int i = 0; i < 100; i++) {  
            System.out.println(ProduceOrderNo.getOrderNo());  
        }  
    }  
  
    /** 
     * 生成订单编号 
     * @return 
     */  
    public static synchronized String getOrderNo() {  
        String str = new SimpleDateFormat("yyMMddHHmmS").format(new Date());  
        if(date==null||!date.equals(str)){  
            date = str;  
            orderNum  = 0l;  
        }  
        orderNum ++;  
        long orderNo = Long.parseLong((date)) * 1000;  
        orderNo += orderNum;  
        return orderNo+"";  
    }  
}
