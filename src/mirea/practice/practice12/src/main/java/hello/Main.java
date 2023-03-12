package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private FileHasher fileHasher;

    public Main(FileHasher fileHasher) {
        this.fileHasher = fileHasher;
    }

    public static void main(String[] args){
        args = new String[]{"C:\\Users\\User\\IdeaProjects\\JavaPattrens\\src\\mirea\\practice\\practice12\\file1.txt",
        "C:\\Users\\User\\IdeaProjects\\JavaPattrens\\src\\mirea\\practice\\practice12\\file2.txt"};
        SpringApplication.run(Main.class, args);
        //http://localhost:8080/actuator
    }

    @Override
    public void run(String... args) throws Exception {
        fileHasher.run(args);
        fileHasher.hashing();
    }
}
