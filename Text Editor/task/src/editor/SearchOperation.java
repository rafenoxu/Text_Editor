package editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchOperation implements ActionListener {

    private final TextEditor textEditor;

    public SearchOperation(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                String wordToFind = textEditor.getTopPanel().getSearchField().getText();
                String text = textEditor.getTextArea().getText();

                boolean regex = textEditor.getTopPanel().getRegexCheckBox().isSelected();
                Match matchResult = textEditor.getHistory().startSearch(wordToFind, text, regex);
                if (matchResult != null) {
                    int index = matchResult.getIndex();
                    String foundText = matchResult.getWord();

                    textEditor.getTextArea().setCaretPosition(index + foundText.length());
                    textEditor.getTextArea().select(index, index + foundText.length());
                    textEditor.getTextArea().grabFocus();
                }
                return null;
            }
        };

        worker.execute();
    }
}
