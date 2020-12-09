package com.example.fileserver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadThread  implements Runnable {

    Socket socket;
    public UploadThread(){}
    public UploadThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        InputStream in;
        try {

            in = socket.getInputStream();
            down(in);

            //异常处理
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //测试代码
		/*try {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+",复制完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
    }//End of run
    public void setSocket(Socket socket){
        this.socket=socket;
    }
    //下载方法
    /**
     * 目标：把InputStream中的数据写入到本地
     * 思路：
     * 1.获取输入流,最好传入输入流，而不是直接从Socket获取，传入有利用单元测试
     * 2.从输入流中读到文件名
     * 3.新建文件和文件输出流
     * 4.从输入流中读到文件内容到文件输出流
     * 5.
     * @throws IOException
     */
    public void down(InputStream in) throws IOException {
        //局部变量
        char ch;
        char[] nameArr=new char[256];
        byte[] buf=new byte[1024];
        String name="";
        OutputStream out = null;
        //业务逻辑
        try {
            //第一步：获取文件名，构造文件输出流
            int i=0;
            while((ch=(char) in.read())!='\n'){
                nameArr[i++]= ch;
            }
            //name=nameArr.toString();//这句话无法将字符数组转换为字符串，需用下面的语句
            name=new String(nameArr);
            System.out.println("要下载的文件为："+name);
            out=new FileOutputStream("src\\down\\"+name);
            //第二步：将输入流中的其他内容写入到文件
            int len;
            while((len=in.read(buf))!=-1){
                out.write(buf,0,len);
            }
            out.flush();
            //异常捕获
        } catch (IOException e) {
            e.printStackTrace();
            //关闭资源
        }finally{
            //疑问：两个捕获可不可以放到一块呢，怎样处理关闭流时的异常最好呢？
            in.close();
            out.close();
        }
        //调试
        System.out.println(name);
    }
}
