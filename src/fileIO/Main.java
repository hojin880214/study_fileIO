package fileIO;

import java.util.InputMismatchException;
import java.util.Scanner;
import fileIO.menu.Menu;


public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true) {
            menu.printMenu();
            try {
                Scanner sc = new Scanner(System.in);
                int selectedNumber = sc.nextInt();
                if (menu.selectMenu(selectedNumber)) return;
            } catch (InputMismatchException E) {
                System.err.println("잘못 입력하셨습니다. 아라비안 숫자를 올바르게 입력해주세요.");
            }
        }

    }
}
