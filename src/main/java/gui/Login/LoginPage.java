package gui.Login;

import gui.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {


    JFrame frame = new JFrame();
    JButton loginButton =  new JButton("login");
    JButton resetButton =  new JButton("reset");
    JTextField userIDfield = new JTextField();
    JPasswordField userPWfield = new JPasswordField();
    JLabel userIDlabel = new JLabel("user id: ");
    JLabel userPWlabel = new JLabel("user pw: ");
    JLabel msglabel = new JLabel();



    HashMap<String,String> loginInfo = new HashMap<>();

    public LoginPage(HashMap<String, String> sentLoginInfo){
        loginInfo = sentLoginInfo; // so we can use the hash map all over this class


        //?     designing the labels
        userIDlabel.setBounds(50,50,150,25);
        userPWlabel.setBounds(37,100,150,25);

        userIDlabel.setFont(new Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        userIDlabel.setForeground(new Color(255, 255, 255));

        userPWlabel.setFont(new Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        userPWlabel.setForeground(new Color(255, 255, 255));

        frame.add(userIDlabel);
        frame.add(userPWlabel);


        //?     designing the text fields
        userIDfield.setBounds(150,50,200,25);
        userPWfield.setBounds(150,100,200,25);

        userIDfield.setBackground(new Color(44, 52, 58));
        userIDfield.setFont(new Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        userIDfield.setForeground(new Color(255, 255, 255));
        userIDfield.setBorder(BorderFactory.createLineBorder(new Color(44, 52, 58)));
        userIDfield.setCaretColor(new Color(204, 204, 204));
        userIDfield.setDoubleBuffered(true);


        userPWfield.setBackground(new Color(44, 52, 58));
        userPWfield.setFont(new Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        userPWfield.setForeground(new Color(255, 255, 255));
        userPWfield.setBorder(BorderFactory.createLineBorder(new Color(44, 52, 58)));
        userPWfield.setCaretColor(new Color(204, 204, 204));
        userPWfield.setDoubleBuffered(true);


        frame.add(userIDfield);
        frame.add(userPWfield);


        //?     designing the buttons
        loginButton.setBounds(150,140,80,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        resetButton.setBounds(270,140,80,25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);



        frame.add(loginButton);
        frame.add(resetButton);

        //?     designing the page
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground( new Color(34, 40, 44) );
        frame.setSize(400,250);
        frame.setLayout(null);



        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton){
            userIDfield.setText("");
            userPWfield.setText("");
        }
        if (e.getSource()==loginButton){
            String userID = userIDfield.getText();
            String userPW = String.valueOf(userPWfield.getPassword());

            if (loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(userPW)){
                    frame.dispose();
                    //Home.main(userID);
                    new Home(userID).setVisible(true);
                    //new WelcomePage(userID);
                }
                else {
                    JOptionPane.showMessageDialog(null,"wrong password","bad login",JOptionPane.ERROR_MESSAGE);
                    userPWfield.setText("");
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"user not found","bad login",JOptionPane.ERROR_MESSAGE);
                userIDfield.setText("");
                userPWfield.setText("");
            }
        }

    }
}
