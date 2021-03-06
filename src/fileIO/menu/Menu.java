package fileIO.menu;

import fileIO.file.FileDAOImpl;

public class Menu {

    FileDAOImpl fileDAOimpl = new FileDAOImpl();

    public void printMenu() {
        System.out.println("------------------------------------------------------");
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
                fileDAOimpl.fileList();
                return false;
            case 2:
                System.out.println("2. 파일 열기 선택하셨습니다.");
                return false;
            case 3:
                System.out.println("3. 나가기 선택하셨습니다. 종료합니다.");
                return true;
            default:
                System.err.println("잘못 입력하셨습니다. 해당하는 숫자를 다시 입력해주세요.");
        }
        return false;
    }
}
