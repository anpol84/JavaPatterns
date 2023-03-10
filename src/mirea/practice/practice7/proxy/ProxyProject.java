package mirea.practice.practice7.proxy;

public class ProxyProject implements Project{
    private String data;
    private RealProject realProject;

    public ProxyProject(String data) {
        this.data = data;
    }

    @Override
    public void run() {
        if (realProject == null){
            realProject = new RealProject(data);
        }
        realProject.run();
    }
}
