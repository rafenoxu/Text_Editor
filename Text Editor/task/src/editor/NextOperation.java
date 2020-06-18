package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextOperation implements ActionListener {

    private final TextEditor textEditor;

    public NextOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Match matchResult = textEditor.getHistory().getNextMatch();
        if (matchResult != null) {
            int index = matchResult.getIndex();
            String foundText = matchResult.getWord();

            textEditor.getTextArea().setCaretPosition(index + foundText.length());
            System.out.println(textEditor.getTextArea().getCaretPosition());
            textEditor.getTextArea().select(index, index + foundText.length());
            textEditor.getTextArea().grabFocus();
        }
    }
}