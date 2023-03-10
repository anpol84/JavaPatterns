package mirea.practice.practice8.strategy;

public class Developer {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public void toDo(){
        activity.toDo();
    }
}
