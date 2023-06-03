package gui.Login;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    JFrame frame = new JFrame();
    JLabel hello ;
    WelcomePage(String userID){

        hello = new JLabel("HELLOOOOOO, "+ userID);
        hello.setBounds(50,50,700,50);
        hello.setFont(new Font("MV BALI",Font.PLAIN,50));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setLayout(null);

        frame.add(hello);

        frame.setVisible(true);
    }
}
