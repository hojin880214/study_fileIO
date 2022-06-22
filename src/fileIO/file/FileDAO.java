package fileIO.file;

import java.io.IOException;
import java.util.List;

public interface FileDAO {

    FileVO makeFile();
    void addFileList(FileVO fileVO);
    void printFileList();
    void makeTextFileList();
    int textFileMaxIndex();
    void showTextFileList();
    void readTextFileList(int selectedNumber);

}
