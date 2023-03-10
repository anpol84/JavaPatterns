package mirea.practice.practice7.proxy;

public class Main {
    public static void main(String[] args) {
        Project project1 = new RealProject("data");
        project1.run();

        Project project = new ProxyProject("data1");
        project.run();
    }
}
