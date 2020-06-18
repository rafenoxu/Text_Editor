package editor;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TextEditor extends JFrame {
    private SearchHistory history;

    private TopPanel topPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private MenuBar menuBar;
    private JFileChooser fileChooser;

    public TextEditor() {
        createComponents();
        initComponents();
        addComponents();
        setTextEditor();
    }

    private void createComponents() {
        history = new SearchHistory();
        fileChooser = new JFileChooser(new File("."));
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        topPanel = new TopPanel(this);
        menuBar = new MenuBar(this);
    }

    private void initComponents() {
        fileChooser.setName("FileChooser");
        fileChooser.setVisible(false);

        textArea.setName("TextArea");

        scrollPane.setName("ScrollPane");
        scrollPane.setHorizontalScrollBar(new JScrollBar(Adjustable.HORIZONTAL));
        scrollPane.setVerticalScrollBar(new JScrollBar(Adjustable.VERTICAL));
    }

    private void addComponents() {
        add(fileChooser);

        add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        setJMenuBar(menuBar);
    }

    private void setTextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Text Editor");
        setVisible(true);
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public SearchHistory getHistory() {
        return history;
    }
}
