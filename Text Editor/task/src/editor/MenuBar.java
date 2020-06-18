package editor;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    private final TextEditor textEditor;

    private FileMenu fileMenu;
    private SearchMenu searchMenu;

    public MenuBar(TextEditor textEditor) {
        this.textEditor = textEditor;

        createComponents();
        initComponents();
        addComponents();
    }

    private void createComponents() {
        fileMenu = new FileMenu("File", textEditor);
        searchMenu = new SearchMenu("Search", textEditor);
    }

    private void initComponents() {
        fileMenu.setName("MenuFile");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        searchMenu.setName("MenuSearch");
        searchMenu.setMnemonic(KeyEvent.VK_S);
    }

    private void addComponents() {
        add(fileMenu);
        add(searchMenu);
    }
}
