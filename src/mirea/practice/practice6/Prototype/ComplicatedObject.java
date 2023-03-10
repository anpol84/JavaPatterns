package mirea.practice.practice6.Prototype;

public class ComplicatedObject implements Cloneable{
    private int id;
    private String data;

    @Override
    public ComplicatedObject clone() {
        ComplicatedObject complicatedObject = new ComplicatedObject(id, data);
        return complicatedObject;
    }

    public ComplicatedObject(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ComplicatedObject{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
