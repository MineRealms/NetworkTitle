package cn.minerealms.networktitle;

import org.apache.logging.log4j.*;
import net.minecraftforge.common.config.*;

public class Config
{
    public static String Url;
    public static String UA;
    public static String timeout;
    public static String ENCODE;
    
    public static void readConfig() {
        final Configuration configuration = CommonProxy.config;
        try {
            configuration.load();
            initGeneralConfig(configuration);
        }
        catch (Exception exception) {
            NetworkTitle.logger.log(Level.ERROR, "在加载配置文件时遇到问题: {}", (Throwable)exception);
        }
    }
    
    private static void initGeneralConfig(final Configuration configuration) {
        configuration.addCustomCategoryComment("general", "General configuration");
        Config.Url = configuration.getString("NetworkURL","general","https://www.minerealms.cn/tips.php","Get the window title from a URL, the web server should to return TEXT format");
        Config.UA = configuration.getString("UserAgent","general","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)","User-Agent settings, Maybe can prevent the web server return 403 CODE");
        Config.timeout = configuration.getString("Timeout","general", String.valueOf(5),"The timeout period for get text from URL, in seconds");
        Config.ENCODE = configuration.getString("String encode","general","gbk","Set the same encoding to prevent error in encoding between the Web server and the mc client");

    }
    
    static {
        Config.Url = "https://www.minerealms.cn/tips.php";
        Config.UA = "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)";
        Config.timeout = "5";
        Config.ENCODE ="gbk";
    }
}
