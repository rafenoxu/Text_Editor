package editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckRegexOperation implements ActionListener {

    private final TextEditor textEditor;

    public CheckRegexOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JCheckBox checkBox = textEditor.getTopPanel().getRegexCheckBox();
        checkBox.setSelected(!checkBox.isSelected());
    }
}
