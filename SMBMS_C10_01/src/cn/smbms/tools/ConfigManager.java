package cn.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件的工具类-单例模式
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	//私有构造器-读取数据库配置文件
	private ConfigManager(){
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = 
				ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//全局访问点
	public static ConfigManager getInstance(){
		if(configManager == null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	
	public String getValue(String key){
		return properties.getProperty(key);
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				configManager = ConfigManager.getInstance();
				System.out.println(configManager);
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				configManager = ConfigManager.getInstance();
				System.out.println(configManager);
			}
		};
		t1.start();
		t2.start();
	}
}
