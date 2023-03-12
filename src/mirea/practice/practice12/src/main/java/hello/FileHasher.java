package hello;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Service
public class FileHasher {
    private String inputFile;
    private String outputFile;

    private File fileToDelete;
    public void run(String[] args){
        if (args.length != 2){
            System.out.println("You must provide 2 files");
            return;
        }
        inputFile = args[0];
        outputFile = args[1];
    }
    public void hashing() throws IOException, NoSuchAlgorithmException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        File tempInputFile = new File(inputFile);
        if (!tempInputFile.exists()){
            fileOutputStream.write("null".getBytes());
            fileOutputStream.close();
            return;
        }
        fileToDelete = tempInputFile;
        FileInputStream fileInputStream = new FileInputStream(tempInputFile);
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        fileInputStream.close();
        data = MessageDigest.getInstance("SHA-256").digest(data);
        fileOutputStream.write(data);
        fileOutputStream.close();
    }
    @PreDestroy
    public void delete(){
        if (fileToDelete.exists()){
            System.out.println("Deleting!");
            fileToDelete.delete();
        }
    }
}
