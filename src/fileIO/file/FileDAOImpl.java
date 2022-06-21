package fileIO.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDAOImpl implements FileDAO {
    List<FileVO> fileList = new ArrayList<>();

    @Override
    public void addFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("파일 이름을 적어주세요 : ");
        String fileTile = scanner.nextLine();
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "\\file\\" + fileTile + ".txt";
        String fileContent = "";
        int lineNumber = 0;
        try (
                FileWriter fw = new FileWriter(filePath, false);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            System.out.println(filePath + " 이 생성되었습니다.");
            System.out.println("파일 내용을 입력해주세요.(입력 종료는 개행 후 :q 입력해주세요)");
            while (true) {
                System.out.print(" " + ++lineNumber + " ");
                String line = scanner.nextLine();
                if((line.equals(":q"))) break;
                fileContent = fileContent.concat(line + System.lineSeparator());
                bw.write(line);
                bw.newLine();
            }
            System.out.println(filePath + "의 내용 입력을 완료하였습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileVO fileVO = new FileVO(filePath,fileContent);

        fileList.add(fileVO);

    }
}
