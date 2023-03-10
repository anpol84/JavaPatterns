package mirea.practice.practice5;

public class NotLazySingleton {
    private static final NotLazySingleton instance = new NotLazySingleton();
    private NotLazySingleton(){}
    public static NotLazySingleton getInstance(){
        return instance;
    }
}
