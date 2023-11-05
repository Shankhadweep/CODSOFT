
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {
    JButton rules,back;
    JTextField tf;
    login()
        {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login1.jpg"));
            JLabel pic = new JLabel(i1);
            pic.setBounds(0,0,600,500);
            add(pic);
            
            JLabel head = new JLabel("Tech Quiz");
            head.setBounds(800, 60, 300, 45);
            head.setFont(new Font("Lucida Handwriting",Font.BOLD,30));
            head.setForeground(new Color(143, 0, 255));
            add(head);
            
            JLabel name= new JLabel("Enter your name:");
            name.setBounds(830, 150, 300, 20);
            name.setFont(new Font("Times New Roman",Font.BOLD,16));
            name.setForeground(new Color(143, 0, 255));
            add(name);
            
            tf = new JTextField();
            tf.setBounds(735,200, 300, 25);
            tf.setFont(new Font("Times New Roman",Font.BOLD,20));
            add(tf);
            back = new JButton("Back");
            back.setBounds(735,270,120,25);
            back.setBackground(new Color(143,0,255));
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);
            
            rules = new JButton("Proceed to Rules");
            rules.setBounds(900,270,150,25);
            rules.setBackground(new Color(143,0,255));
            rules.setForeground(Color.WHITE);
            rules.addActionListener(this);
            add(rules);
            
            setSize(1200, 500);
            setLocation(200, 150);
            setVisible(true);
        }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == rules){
        String name = tf.getText();
        setVisible(false);
        new Rules(name);
    }else if (ae.getSource() == back){
        setVisible(false);
    }
    }
    public static void main(String[] args){
        new login();
    }
}
