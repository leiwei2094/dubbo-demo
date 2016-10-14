package com.leolei.dubbodemo.provider;

import com.leolei.dubbodemo.api.IFileService;

import java.io.*;

public class FileService implements IFileService{
    @Override
    public void upload(String destPath, InputStream stream)  {

        try {
            int b = 0;
            //FileInputStream in = null;
            FileOutputStream out = null;
            try{
                // 源文件路径
                //in = new FileInputStream("D:\\text.txt");
                // 结果文件路径
                out = new FileOutputStream(destPath);
                while((b = stream.read()) != -1){
                    out.write(b);
                }
                stream.close();
                out.close();
            }catch(FileNotFoundException e1){
                System.out.println("file is not found!");
                System.exit(-1);
            }catch(IOException e2){
                System.out.println("文件复制错误！！");
                System.exit(-1);
            }
            System.out.println("文件复制成功了~~！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
