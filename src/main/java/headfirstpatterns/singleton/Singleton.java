package headfirstpatterns.singleton;

/**
 * Three ways to implement singletons:
 * -Synchronized getInstance method
 * -Use eager initialization
 * -Double check locking
 * */
public class Singleton {

	private volatile static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}

		return instance;
	}

}
