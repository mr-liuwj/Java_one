package com.lcy.controller.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liuweijin
 * @date 2024-11-06
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            InputStream is = socket.getInputStream();
            Scanner scanner = new Scanner(is, "utf-8");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            String next = scanner.next();
            System.out.println(next);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
