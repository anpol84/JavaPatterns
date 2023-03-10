package mirea.practice.practice5;

public class        Main {
    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton1.hashCode() + " " + lazySingleton2.hashCode());

        NotLazySingleton notLazySingleton1 = NotLazySingleton.getInstance();
        NotLazySingleton notLazySingleton2 = NotLazySingleton.getInstance();
        System.out.println(notLazySingleton1.hashCode() + " " + notLazySingleton2.hashCode());

        EnumSingleton enumSingleton1 = EnumSingleton.getInstance();
        EnumSingleton enumSingleton2 = EnumSingleton.getInstance();
        System.out.println(enumSingleton1.hashCode() + " " + enumSingleton2.hashCode());


    }
}
