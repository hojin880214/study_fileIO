package fileIO.file;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FileVO {

    private String fileName;
    private String fileContent;

    public FileVO(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

}
