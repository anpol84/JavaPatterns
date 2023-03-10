package mirea.practice.practice5;

public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
