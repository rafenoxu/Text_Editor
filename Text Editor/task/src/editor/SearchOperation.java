package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchOperation implements ActionListener {

    private final TextEditor textEditor;

    public SearchOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String wordToFind = textEditor.getTopPanel().getSearchField().getText();
        String text = textEditor.getTextArea().getText();

        Match matchResult = textEditor.getHistory().startSearch(wordToFind, text);
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
