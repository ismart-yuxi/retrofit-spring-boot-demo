package com.example.fileserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class UploadServer {
    public static void main(String[] args) {
        UploadServer server=new UploadServer();
        UploadThread command=new UploadThread();
        server.start(command);
    }

    /**
     * 功能：接受连接，开启子线程，循环
     * @param command 用于下载的子线程对象，该对象实现了Runnable接口
     */
    private void start(UploadThread command){
        //局部变量
        ServerSocket serverSocket = null;
        Socket transSocket;
        //业务逻辑
        try {
            serverSocket=new ServerSocket(55555);
            while(true){
                System.out.println("等待连接……");
                transSocket=serverSocket.accept();
                int i=0;
                i++;
                System.out.println("第"+i+"个连接");
                //用不用在下载完后关闭线程呢？？？
                command.setSocket(transSocket);
                newFixedThreadPool(5).execute(command);
            }
            //异常捕获
        } catch (IOException e) {
            e.printStackTrace();
            //关闭资源
        } finally{
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//End of try
    }//End of connect


}
