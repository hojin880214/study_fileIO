package fileIO.file;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class FileDAOImpl implements FileDAO {

    private final String projectPath = System.getProperty("user.dir");
    List<FileVO> fileList = new ArrayList<>();
    List<String> textFileList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String FONT_BLACK = "\u001B[30m";
    public static final String BACKGROUND_GREEN = "\u001B[42m";

    @Override
    public FileVO makeFile() {

        System.out.print("파일 이름을 적어주세요 : ");
        String fileName = scanner.nextLine();
        String fileFullPath = projectPath + "\\file\\" + fileName + ".txt";
        String fileContent = "";
        int lineNumber = 0;

        try (
                FileWriter fw = new FileWriter(fileFullPath, false);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            System.out.println(fileFullPath + " 이 생성되었습니다.");
            System.out.println("파일 내용을 입력해주세요.(입력 종료는 개행 후 :q 입력해주세요)" + System.lineSeparator());
            while (true) {
                System.out.print(" " + ++lineNumber + " ");
                String line = scanner.nextLine();
                if((line.equals(":q"))) break;
                fileContent = fileContent.concat(line + System.lineSeparator());
                bw.write(line);
                bw.newLine();
            }
            System.out.println(System.lineSeparator() + fileFullPath + "의 내용 입력을 완료하였습니다." + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new FileVO(fileFullPath,fileName,fileContent);

    }

    @Override
    public void addFileList(FileVO fileVO) {
        fileList.add(fileVO);
    }

    @Override
    public void printFileList() {

        System.out.println("----------------------파일목록-------------------------");
        fileList.forEach(fileVO -> System.out.println((fileList.indexOf(fileVO)) + 1 + ". " + fileVO.toStringFileList()));
        System.out.println("------------------------------------------------------" + System.lineSeparator());

    }

    @Override
    public void makeTextFileList() {

        File dir = new File(projectPath + "\\file\\");
        FilenameFilter filter = (f, name) -> name.contains("txt");
        File[] files = dir.listFiles(filter);
        textFileList.clear();
        for (File file : Objects.requireNonNull(files)) {
            textFileList.add(file.toString());
        }

    }

    @Override
    public int textFileMaxIndex() {
        return textFileList.size();
    }

    @Override
    public void showTextFileList() {

        System.out.println(System.lineSeparator() + "----------------------파일목록-------------------------");
        textFileList.forEach(String -> System.out.println((textFileList.indexOf(String)) + 1 + ". " + String.substring(String.lastIndexOf("\\") + 1)));
        System.out.println("------------------------------------------------------");

    }

    @Override
    public void readTextFileList(int selectedNumber) {

        int lineNumber = 0;
        try {
            Path path = Paths.get(textFileList.get(selectedNumber - 1));
            List<String> allLines = Files.readAllLines(path);
            System.out.println(System.lineSeparator() + path);
            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");
            for (String line : allLines) {
                System.out.println(RESET + " " + ++lineNumber + " " + BACKGROUND_GREEN + FONT_BLACK + " " + line);
            }
            System.out.println(RESET + "------------------------------------------------------");
            System.out.println("------------------------------------------------------" + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
