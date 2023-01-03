package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try {
            Socket S = new Socket("localhost", 1000);
            System.out.println("vous etes connecte avec le serveur");
            Scanner clavier = new Scanner(System.in);
            InputStream is = S.getInputStream();
            OutputStream os = S.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(os, true);
            System.out.println("donner une chaine : ");
            String ch = clavier.nextLine();
            pw.println(ch);
            System.out.println("la chaine est " + br.readLine());
            S.close();
        } catch (UnknownHostException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}