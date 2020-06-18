package editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTextFileOperation implements ActionListener {

    private final TextEditor textEditor;

    public SaveTextFileOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        saveDataToFile(textEditor.getTextArea().getText());
    }

    private void saveDataToFile(String text) {
        JFileChooser fileChooser = textEditor.getFileChooser();
        fileChooser.setVisible(true);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (FileWriter fileWriter = new FileWriter(selectedFile)) {
                fileWriter.write(text);
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
