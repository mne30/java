package ru.geekbrains.java1.lesson6;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {

    private static String path = "/home/chubaka/IdeaProjects/java/";

    public static void main(String[] args){
        /*
            1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
            2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом
                текст из второго.
            3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле
                (работаем только с латиницей).
            4. ** Написать метод, проверяющий, есть ли указанное слово в папке
         */

        //Task1
        String text1 = "A PrintStream adds functionality to another output stream, namely the ability to print " +
                "representations of various data values conveniently. Two other features are provided as well. " +
                "Unlike other output streams, a PrintStream never throws an IOException; instead, exceptional " +
                "situations merely set an internal flag that can be tested via the checkError method. Optionally, " +
                "a PrintStream can be created so as to flush automatically; this means that the flush method is " +
                "automatically invoked after a byte array is written, one of the println methods is invoked, or a " +
                "newline character or byte ('\\n') is written.\n" + "All characters printed by a PrintStream are " +
                "converted into bytes using the platform's default character encoding. The PrintWriter class should " +
                "be used in situations that require writing characters rather than bytes.";
        String text2 = "Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired " +
                "by Oracle) and released in 1995 as a core component of Sun Microsystems' Java platform. The original " +
                "and reference implementation Java compilers, virtual machines, and class libraries were originally " +
                "released by Sun under proprietary licenses.";
        writeFile("HomeWork6_1.txt", text1);
        writeFile("HomeWork6_2.txt", text2);
        //Task 2
        textConcatenation("HomeWork6_1.txt", "HomeWork6_2.txt");
        //Task 3
        System.out.println(searchText("HomeWork6_2.txt", "Java"));
        //Task 4
        System.out.println(searchTextInFiles(path,"All"));





    }

    //write file
    private static void writeFile(String fileName, String text){
        try {
            PrintStream prtstr = new PrintStream(new FileOutputStream(fileName));
            prtstr.print(text);
            prtstr.flush();
            prtstr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    //read file
    private static String readFile(String fileName) {
        String text = "";
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNext())
                text+=scanner.nextLine();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return text;
    }
    //text concatination
    private static void textConcatenation (String fileNameFirst, String fileNameSecond){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNameFirst, true);
            fileOutputStream.write(readFile(fileNameSecond).getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   private static boolean searchText(String fileName, String fnd){
        boolean result = false;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int currentByte;
            int currentCount = 0;
            byte[] byteArray = fnd.getBytes();
            int countYes = byteArray.length - 1;
            while ((currentByte = fileInputStream.read()) != -1){
                if((char)currentByte == '\n'){
                    currentCount = 0;
                    continue;
                }
                if(currentCount == countYes){
                    result = true;
                    break;
                } else if( currentCount < countYes){
                    if( currentByte == byteArray[currentCount]){
                        currentCount++;
                    } else{
                        currentCount = 0;
                        continue;
                    }
                    if(currentCount == countYes){
                        result = true;
                        break;
                    }

                }
            }
            return result;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
    private static boolean searchTextInFiles(String dir, String fnd){
        File mainFolder = new File(dir);
        File[] files = mainFolder.listFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i].isFile()){
                if (searchText(files[i].getName(),fnd))
                    return true;
            }
        }
        return false;
    }

}
