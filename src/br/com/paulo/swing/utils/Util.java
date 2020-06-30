package br.com.paulo.swing.utils;

public class Util {
    
    public static String parseString(Object obj){
        try {
            return obj.toString();
        } catch (Exception e){
            return "";
        }
    }
    
    public static java.sql.Date parseSqlDate(java.util.Date obj){
        try {
            return new java.sql.Date(obj.getTime());
        } catch (Exception e){
            return new java.sql.Date(new java.util.Date().getTime());
        }
    }
    
    public static Character parseChar(Object obj){
        try {
            return obj.toString().charAt(0);
        } catch (Exception e){
            return 'M';
        }
    }
    
    public static Long parseLong(Object obj){
        try {
            return Long.parseLong(obj.toString());
        } catch(Exception e){
            return Long.MIN_VALUE;
        }
    }

}
