package cas.chenhuanming.cn.util.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017-05-12.
 */
public class PropertiesUtil {
    private static final String CONFIG_FILE_NAME = "config.properties";
    private static Properties property;

    static {
        property = new Properties();
        try {
            property.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String name){
        return property.getProperty(name);
    }
}
