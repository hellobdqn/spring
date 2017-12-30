package cn.smbms.tools;
/**
 * 使用静态内部类的方式创建单例模式
 * @author Administrator
 *
 */
public class Singleton {
	private static Singleton singleton;
	private Singleton(){
		
	}
	private static class SingletionHelper{
		private static final Singleton INSTANCE = new Singleton();
	}
	public Singleton getInstance(){
		singleton = SingletionHelper.INSTANCE;
		return singleton;
	}
	
	

}
