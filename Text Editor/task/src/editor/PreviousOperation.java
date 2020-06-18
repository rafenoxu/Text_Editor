package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousOperation implements ActionListener {

    private final TextEditor textEditor;

    public PreviousOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Match matchResult = textEditor.getHistory().getPreviousMatch();
        int index = matchResult.getIndex();
        String foundText = matchResult.getWord();

        textEditor.getTextArea().setCaretPosition(index + foundText.length());
        textEditor.getTextArea().select(index, index + foundText.length());
        textEditor.getTextArea().grabFocus();
    }
}
