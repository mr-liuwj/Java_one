package com.lcy.controller.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.zip.ZipFile;

/**
 * @author liuweijin
 * @date 2024-11-06
 * @desc
 */
public class Server1Socket {


    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8888);
             Socket socket = server.accept();
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();

             Scanner scanner = new Scanner(is)) {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
            pw.println("你好啊，欢迎关注「沉默王二」 公众号，回复关键字「2048」 领取程序员进阶必读资料包");

            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                if ("2048".equals(line)) {
                    done = true;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
