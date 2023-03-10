package mirea.practice.practice6.Builder;

public class MyClass {
    private int a;
    private int b;
    private int c;
    private int d;
    private int f;
    public static class Builder{
        private int a;
        private int b;
        private int c = 0;
        private int d = 0;
        private int f = 0;

        public Builder(int a, int b){
            this.a = a;
            this.b = b;
        }
        public Builder c(int c){
            this.c = c;
            return this;
        }

        public Builder d(int d){
            this.d = d;
            return this;
        }

        public Builder f(int f){
            this.f = f;
            return this;
        }
        public MyClass build(){
            return new MyClass(this);
        }
    }

    private MyClass(Builder builder){
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
        f = builder.f;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", f=" + f +
                '}';
    }
}
