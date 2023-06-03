package gui;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

@SuppressWarnings("serial")
public
class TextAreaOutputStreamTest extends JPanel {

    private JTextArea textArea = new JTextArea(15, 30);
    private TextAreaOutputStream taOutputStream = new TextAreaOutputStream(
            textArea, "");

    public TextAreaOutputStreamTest(String in) {
        setLayout(new BorderLayout());

        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(250, 40));
        textArea.setFont(new Font("Microsoft JhengHei UI", 0, 24));
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setBackground(new Color(21, 25, 28));
        textArea.setCaretColor(Color.cyan);


        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        System.setOut(new PrintStream(taOutputStream));

        System.out.println(in);

    }

    private static void createAndShowGui(String in) {
        JFrame frame = new JFrame("results");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(new TextAreaOutputStreamTest(in));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String in) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui(in);
            }
        });
    }
}
