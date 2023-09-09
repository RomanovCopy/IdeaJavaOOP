package com.romanovcopy.models.dataimportexport;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFileDialog {

    private String filePath;
    public OpenFileDialog() {
        filePath=fileDialog();
    }

    public String getFilePath() { return this.filePath; }

    private String fileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("dat");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }
}
