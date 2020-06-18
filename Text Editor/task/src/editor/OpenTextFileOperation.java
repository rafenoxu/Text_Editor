package editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenTextFileOperation implements ActionListener {

    private final TextEditor textEditor;

    public OpenTextFileOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String text = loadDataFromFile();
        textEditor.getTextArea().setText(text);
    }

    private String loadDataFromFile() {
        JFileChooser fileChooser = textEditor.getFileChooser();
        fileChooser.setVisible(true);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                return new String(Files.readAllBytes(Paths.get(selectedFile.toURI())));
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
        return null;
    }
}
