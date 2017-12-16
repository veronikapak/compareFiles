package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = "";
        s = writeTofile();

        String sPas ="";
        InputStream is = Main.class.getResourceAsStream("/password.txt");

        //String fileName = "resource/password.txt";
        String sPas1 = "";
            try(BufferedReader br = new BufferedReader(new FileReader("resource/password.txt"))){
            sPas1 = br.readLine();
                //System.out.println(sPas1);
                br.close();
            }catch (IOException e) {
            e.printStackTrace();
        }


        try {
            sPas = getContent(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (sPas.equals(s)){
            System.out.println("Your password is correct");
        }else{
            System.out.println("Your password wrong");
        }

        if (sPas1.equals(s)){
            System.out.println("Your password is correct");
        }else{
            System.out.println("Your password wrong");
        }

    }

    private static String writeTofile() {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a text: ");
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fileInFoulder = new File("C:\\java\\CompareText\\file1.txt");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileInFoulder);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Create it");
        }

        PrintWriter bw = new PrintWriter(fos);
        bw.write(s);
        bw.flush();

        try {
            br.close();
            fos.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private static String getContent(InputStream inputStream) throws IOException {
        byte[] buff = new byte[inputStream.available()];
        while (inputStream.available()>0){
            int read = inputStream.read(buff);
            if (read==-1){
                System.out.println("finished");
                break;
            }
        }
        inputStream.close();
        return new String(buff); //str;
        //String result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining());
    }
}
