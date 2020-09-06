package com.szxj.javabase.JDK.String;

/**
 * @author suzhouxj
 */
public class StringBase {
    public static void main(String[] args) {
        String s = "abc";
        //创建对象放在静态常量池，不能修改
        //String是引用类型，不是基本类型

        s ="123";
        //引用指向了123，abc还在

        s += "321";
        //123321 常量池（123，321，123321）

        String s2 = new String("efg");
        String s3 = new String(new char[]{'a','b'});
        //----------------------------------------------

        StringBuffer sb = new StringBuffer("sb");
        StringBuffer content = new StringBuffer(100);
        //可以被修改,异步
        sb.append(".c");
        sb.append(true);
        sb.append(123);
        sb.append(123).append(321).append(s);

        content.length();//=100

        sb.delete(0,3);
        sb.deleteCharAt(2);

        sb.insert(3,"o");

        sb.substring(1,3);
        //截取

        sb.reverse();
        //翻转 abc -> cba

        //----------------------------------------------
        StringBuilder sd = new StringBuilder();
        //同步 其他和StringBuff类似


    }

}
