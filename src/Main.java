import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]){
        File folderIn = new File("C:\\Test1");
        File folderOut = new File("C:\\Test2");
        folderOut.mkdirs();

        try {
            System.out.println(FileOperation.copyFolder(folderIn, folderOut, "mp4"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}