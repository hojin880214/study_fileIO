package com.fileIO.shj.menu;

import com.fileIO.shj.file.FileDAOImpl;
import com.fileIO.shj.myBatis.MyBatisConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {

    private static Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    FileDAOImpl fileDAOimpl = new FileDAOImpl(MyBatisConnectionFactory.getSqlSessionFactory());
    Scanner scanner = new Scanner(System.in);

    public void printMenu() {

        System.out.println("-----------------------FileIO-------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("1. 새 파일");
        System.out.println("2. 파일 열기");
        System.out.println("3. 나가기");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.print("콘솔창에 해당하는 숫자를 입력해주세요 : ");

    }

    public boolean selectMenu(int selectedNumber) {

        switch (selectedNumber) {
            case 1:
                System.out.println("1. 새 파일 선택하셨습니다.");
                fileDAOimpl.addFileList(fileDAOimpl.makeFile());
                fileDAOimpl.printFileList();
                return false;
            case 2:
                System.out.println("2. 파일 열기 선택하셨습니다.");
                fileDAOimpl.makeTextFileList();
                fileDAOimpl.showTextFileList();
                int textFileMaxIndex = fileDAOimpl.textFileMaxIndex();
                System.out.print("읽을 파일 번호를 입력해주세요 : ");
                while (true) {
                    selectedNumber = scanner.nextInt();
                    if(textFileMaxIndex >= selectedNumber){
                        fileDAOimpl.readTextFileList(selectedNumber);
                        break;
                    }
                    System.err.print("해당하는 번호가 없습니다. 읽을 파일 번호를 다시 입력해주세요 : ");
                }

                return false;
            case 3:
                System.out.println("3. 나가기 선택하셨습니다. 종료합니다.");
                return true;
            default:
                LOGGER.error("잘못 입력하셨습니다. 해당하는 숫자를 다시 입력해주세요.");
        }

        return false;

    }
}
