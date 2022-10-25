/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compressdecompress;
import java.io.*;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author Lenovo
 */
public class CompressDecompress {

    /**
     * @param args the command line arguments
     */
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
        
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len = fis.read(buffer)) != -1){
            gzipOS.write(buffer,0,len);
        }
//        for(int i=0;i<5;i++){
//                    System.out.println(buffer[i]);
//        } 
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
    public static void main(String[] args) throws IOException {
        File p = new File("D:\\DSA\\hello\\text.txt");
        method(p);
    }
    
}
