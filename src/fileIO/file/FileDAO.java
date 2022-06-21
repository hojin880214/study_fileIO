package fileIO.file;

import java.util.List;

public interface FileDAO {

    FileVO makeFile();
    void addFileList(FileVO fileVO);
    void fileList();
    void textFileList();
}
