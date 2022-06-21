package fileIO.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class FileDAOImpl implements FileDAO {
    List<FileVO> fileList = new ArrayList<>();

    @Override
    public FileVO makeFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("파일 이름을 적어주세요 : ");
        String fileName = scanner.nextLine();
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "\\file\\" + fileName + ".txt";
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
            System.out.println(filePath + "의 내용 입력을 완료하였습니다." + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileVO fileVO = new FileVO(filePath,fileName,fileContent);

        return fileVO;
    }

    @Override
    public void addFileList(FileVO fileVO) {
        fileList.add(fileVO);
    }

    @Override
    public void fileList() {
        System.out.println("----------------------파일목록-------------------------");
        fileList.forEach(fileVO -> {
            System.out.println((fileList.indexOf(fileVO)) + 1 + ". " + fileVO.toStringFileList());
        });
        System.out.println("------------------------------------------------------" + System.lineSeparator());
//        fileList.forEach(new Consumer<FileVO>() {
//            @Override
//            public void accept(FileVO fileVO) {
//                System.out.println(fileVO.toStringFileList());
//            }
//        });
    }

    @Override
    public void textFileList() {

    }


}
