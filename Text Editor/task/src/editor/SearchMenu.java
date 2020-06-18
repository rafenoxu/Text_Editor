package editor;

import javax.swing.*;

public class SearchMenu extends JMenu {

    private final TextEditor textEditor;

    private JMenuItem searchMenuItem;
    private JMenuItem previousMenuItem;
    private JMenuItem nextMenuItem;
    private JMenuItem useRegexMenuItem;

    public SearchMenu(String s, TextEditor textEditor) {
        super(s);

        this.textEditor = textEditor;

        createMenuItems();
        initMenuItems();
        addMenuItems();
    }

    private void createMenuItems() {
        searchMenuItem = new JMenuItem("Start search");
        previousMenuItem = new JMenuItem("Previous search");
        nextMenuItem = new JMenuItem("Next match");
        useRegexMenuItem = new JMenuItem("Use regular expressions");
    }

    private void initMenuItems() {
        searchMenuItem.setName("MenuStartSearch");
        searchMenuItem.addActionListener(new SearchOperation(textEditor));

        previousMenuItem.setName("MenuPreviousMatch");
        previousMenuItem.addActionListener(new PreviousOperation(textEditor));

        nextMenuItem.setName("MenuNextMatch");
        nextMenuItem.addActionListener(new NextOperation(textEditor));

        useRegexMenuItem.setName("MenuUseRegExp");
        useRegexMenuItem.addActionListener(new CheckRegexOperation(textEditor));
    }

    private void addMenuItems() {
        add(searchMenuItem);
        add(previousMenuItem);
        add(nextMenuItem);
        add(useRegexMenuItem);
    }
}
