package editor;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private enum IconType {
        SAVE, LOAD, SEARCH, PREVIOUS, NEXT
    }

    private JTextField searchField;
    private JButton saveButton;
    private JButton loadButton;
    private JButton searchButton;
    private JButton previousButton;
    private JButton nextButton;
    private JCheckBox regexCheckBox;

    private final TextEditor textEditor;

    public TopPanel(TextEditor textEditor) {
        this.textEditor = textEditor;

        createComponents();
        initComponents();
        addComponents();
    }

    private void createComponents() {
        searchField = new JTextField(15);

        saveButton = new JButton(prepareIcon(IconType.SAVE));
        loadButton = new JButton(prepareIcon(IconType.LOAD));
        searchButton = new JButton(prepareIcon(IconType.SEARCH));
        previousButton = new JButton(prepareIcon(IconType.PREVIOUS));
        nextButton = new JButton(prepareIcon(IconType.NEXT));

        regexCheckBox = new JCheckBox("Use regex");
    }

    private void initComponents() {
        searchField.setName("SearchField");

        saveButton.setName("SaveButton");
        saveButton.addActionListener(new SaveTextFileOperation(textEditor));

        loadButton.setName("OpenButton");
        loadButton.addActionListener(new OpenTextFileOperation(textEditor));

        searchButton.setName("StartSearchButton");
        searchButton.addActionListener(new SearchOperation(textEditor));

        previousButton.setName("PreviousMatchButton");
        previousButton.addActionListener(new PreviousOperation(textEditor));

        nextButton.setName("NextMatchButton");
        nextButton.addActionListener(new NextOperation(textEditor));

        regexCheckBox.setName("UseRegExCheckbox");
    }

    private void addComponents() {
        add(loadButton);
        add(saveButton);
        add(searchField);
        add(searchButton);
        add(previousButton);
        add(nextButton);
        add(regexCheckBox);
    }

    private ImageIcon prepareIcon(IconType type) {
        ImageIcon icon;
        Image image;

        switch (type) {
            case SAVE:
                icon = new ImageIcon("resources/save.png");
                image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return new ImageIcon(image);
            case LOAD:
                icon = new ImageIcon("resources/load.png");
                image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return new ImageIcon(image);
            case SEARCH:
                icon = new ImageIcon("resources/search.png");
                image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return new ImageIcon(image);
            case PREVIOUS:
                icon = new ImageIcon("resources/back.png");
                image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return new ImageIcon(image);
            case NEXT:
                icon = new ImageIcon("resources/forward.png");
                image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return new ImageIcon(image);
        }
        return null;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JCheckBox getRegexCheckBox() {
        return regexCheckBox;
    }
}
