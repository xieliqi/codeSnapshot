package com.xxx.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class IpNetFilter {
    /** 
         * 是否为内网IP flag = true 为内网 
         *  
         * @param ip 
         * @return 
         */  
        public static boolean ipNetFilter(String ip) {  
            Boolean flag = Boolean.FALSE;  
            if (StringUtils.isNotBlank(ip)) {  
                //String regex = "(127[.]0[.]0[.]1)|(localhost)|(10[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3})|(172[.]((1[6-9])|(2\\d)|(3[01]))[.]\\d{1,3}[.]\\d{1,3})|(192[.]168[.]\\d{1,3}[.]\\d{1,3})";  
                String regex = "(127[.]0[.]0[.]1)|(localhost)|(172[.]((1[6-9])|(2\\d)|(3[01]))[.]\\d{1,3}[.]\\d{1,3})|(192[.]168[.]\\d{1,3}[.]\\d{1,3})";  
                Pattern pattern = Pattern.compile(regex);  
                Matcher matcher = pattern.matcher(ip);  
                flag = matcher.matches();  
            }  
            return flag;  
        }
}

