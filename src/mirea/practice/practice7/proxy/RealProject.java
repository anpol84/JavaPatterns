package mirea.practice.practice7.proxy;

public class RealProject implements Project{
    private String data;

    public RealProject(String data) {
        this.data = data;
        printData();
    }

    public void printData(){
        System.out.println(data);
    }
    @Override
    public void run() {
        System.out.println("Project with data: " + data);
    }
}
