package zw.co.econet;

import javax.swing.*;
import java.io.File;

/**
 * Created by Tinashe.Chinyanga on 14/06/2017.
 */
public class FilePicker {
    JFileChooser fileChooser = new JFileChooser();
    File selectedFile;
    int result;

    public File selectFile() {
//        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }
        return selectedFile;
    }
}
