import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
public class FileOperation {

    public static String getExtension (String filename){
        return filename.substring(filename.lastIndexOf(".") + 1);
    }
    public static long copyFile (File in, File out) throws IOException {
        try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
            return is.transferTo(os);
        }
    }
        public static long copyFolder (File folderIn, File folderOut, String extension) throws IOException {
            File[] files = folderIn.listFiles();
            long fileCopy = 0;

            for (int i = 0; i < files.length; i++){
                if (files[i].isFile() && getExtension(files[i].getName()).compareTo(extension) == 0) {
                    File out = new File(folderOut, files[i].getName());
                    copyFile(files[i], out);
                    fileCopy += 1;
                }
            }
            return fileCopy;
        }
    }