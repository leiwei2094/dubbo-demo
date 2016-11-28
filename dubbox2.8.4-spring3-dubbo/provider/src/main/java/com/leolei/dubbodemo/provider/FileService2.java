//package com.leolei.dubbodemo.provider;
//
//import com.leolei.dubbodemo.api.IFileService2;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class FileService2 implements IFileService2 {
//    @Override
//    public void upload(String destPath, byte[] bytes) {
//
//        try {
//            int b = 0;
//            //FileInputStream in = null;
//            FileOutputStream out = null;
//            try{
//                // 源文件路径
//                //in = new FileInputStream("D:\\text.txt");
//                // 结果文件路径
//                out = new FileOutputStream("/users/leiwei/baidu2.png");
//
//                for (int i =0; i < bytes.length;i++){
//                    out.write(bytes[i]);
//                }
//
////                while((b = stream.read()) != -1){
////                    out.write(b);
////                }
//                //stream.close();
//                out.close();
//            }catch(FileNotFoundException e1){
//                System.out.println("file is not found!");
//                System.exit(-1);
//            }catch(IOException e2){
//                System.out.println("文件复制错误！！");
//                System.exit(-1);
//            }
//            System.out.println("文件复制成功了~~！");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
