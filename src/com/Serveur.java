package com;

import java.io.IOException;
import java.io.*;
import java.net.*;
public class Serveur {

    public static void main(String[] args) {
        try {
            ServerSocket Sc = new ServerSocket(1000);
            System.out.println("J'attends une connexion");
            Socket SS = Sc.accept();
            System.out.println("un client est connecte");
            InputStream is = SS.getInputStream();
            OutputStream os = SS.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(os, true);
            String ch = br.readLine();
            boolean pal = true;
            String res;
            int j = ch.length() - 1;
            for (int i = 0; i < ch.length() / 2; i++) {
                if (ch.charAt(i) != ch.charAt(j)) {
                    pal = false;
                }
                j--;
            }
            if (pal == true)
                res = "Palindrome";
            else
                res = "Non Palindrome";
            pw.println(res);
            Sc.close();
            SS.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}