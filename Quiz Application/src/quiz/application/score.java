package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener {
    score(String name,int score){
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel pic = new JLabel(i3);
        pic.setBounds(0,200,300,250);
        add(pic);
        
        JLabel head = new JLabel("Thank you "+name+" for playing Tech Quiz");
        head.setBounds(45,30, 700, 30);
        head.setFont(new Font("Lucida Handwriting",Font.PLAIN,26));
        head.setForeground(new Color(143, 0, 255));
        add(head);
        
        JLabel lblscore = new JLabel("Your score is "+score);
        lblscore.setBounds(350,200, 300, 30);
        lblscore.setFont(new Font("Lucida Handwriting",Font.PLAIN,26));
        lblscore.setForeground(new Color(143, 0, 255));
        add(lblscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();
    }
    public static void main(String[] args){
        new score("User",0);
        
    }
}
