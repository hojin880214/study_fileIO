package fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fileIO.menu.Menu;

public class Main {

    public static void main(String[] args) {
        Path filePath = Paths.get("c:\\file.txt");
        try {
            Path newFilePath = Files.createFile(filePath);
            System.out.println(newFilePath);


        } catch (IOException e) {
            e.printStackTrace();
        }
//        Menu menu = new Menu();
//
//        while (true) {
//            menu.printMenu();
//            try {
//                Scanner sc = new Scanner(System.in);
//                int selectedNumber = sc.nextInt();
//                if (menu.selectMenu(selectedNumber)) return;
//            } catch (InputMismatchException E) {
//                System.out.println("잘못 입력하셨습니다. 아라비안 숫자를 올바르게 입력해주세요.");
//            }
//        }
    }
}
