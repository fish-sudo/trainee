package cn.com.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * 解析log4.properties,content.properties配置jdbc连接参数
 */
public abstract class JDBCAndChatContentCconfig {
    private static Properties properties = null;
    private static String path;
    private static String jdpath;
    public static String ccpath;
    static {
        Class c = JDBCAndChatContentCconfig.class;
        URL url = c.getResource("/");
        path = url.getPath();
        path = path.substring(1,path.lastIndexOf("classes"));
        ccpath = path+"chatcontent/content.txt";
        path += "jdbc/log4.properties";
        jdpath = path;
        System.out.println(path);
        //得到服务器中的AdminConfig.xml文件
    }
    private JDBCAndChatContentCconfig(){

    }
    public static Properties getJDBCConfig(){
        if(properties == null){
            properties = new Properties();
            try {
                properties.load(new FileReader(new File(jdpath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
