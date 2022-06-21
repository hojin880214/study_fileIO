package fileIO.file;

import lombok.Getter;

@Getter
public class FileVO {

    private final String filePath;
    private final String fileName;
    private final String fileContent;

    public FileVO(String filePath, String fileName, String fileContent) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String toStringFileList(){
        return fileName + ".txt";
    }

}
