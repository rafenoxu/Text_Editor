package editor;

import javax.swing.*;

public class FileMenu extends JMenu {

    private final TextEditor textEditor;

    private JMenuItem loadMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem exitMenuItem;

    public FileMenu(String s, TextEditor textEditor) {
        super(s);

        this.textEditor = textEditor;

        createMenuItems();
        initMenuItems();
        addMenuItems();
    }

    private void createMenuItems() {
        loadMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");
    }

    private void initMenuItems() {
        loadMenuItem.setName("MenuOpen");
        loadMenuItem.addActionListener(new OpenTextFileOperation(textEditor));

        saveMenuItem.setName("MenuSave");
        saveMenuItem.addActionListener(new SaveTextFileOperation(textEditor));

        exitMenuItem.setName("MenuExit");
        exitMenuItem.addActionListener(actionEvent -> System.exit(0));
    }

    private void addMenuItems() {
        add(loadMenuItem);
        add(saveMenuItem);
        addSeparator();
        add(exitMenuItem);
    }
}
