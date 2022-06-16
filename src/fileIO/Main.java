package fileIO;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fileIO.menu.Menu;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true) {
            menu.printMenu();
            try (Scanner sc = new Scanner(System.in)) {
                int select = sc.nextInt();
                switch (select) {
                    case 1:
                        System.out.println("1. 새 파일 선택하셨습니다");
                        break;
                    case 2:
                        System.out.println("2. 열기 선택하셨습니다");
                        break;
                    case 3:
                        System.out.println("3. 나가기 선택하셨습니다");
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다. 해당하는 숫자를 다시 입력해주세요.");
                }
            } catch (InputMismatchException E) {
                System.out.println("해당하는 아라비아 숫자를 입력해주세요");
            }
        }
    }

}
