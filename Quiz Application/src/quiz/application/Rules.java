package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name;JButton start,back;
    Rules(String name)
    {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel head = new JLabel("Welcome "+name+" to Tech Quiz");
        head.setBounds(50, 20, 700, 30);
        head.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
        head.setForeground(new Color(143, 0, 255));
        add(head);
            
        JLabel cond = new JLabel();
        cond.setBounds(20, 90, 700, 350);
        cond.setFont(new Font("Tahoma",Font.PLAIN,12));
        cond.setText(
                "<html>"+
   "- The quizmaster's decision is final and binding on all matters related to the quiz."+"<br><br>"+
   "- The quiz will consist of multiple-choice questions, true/false questions, and open-ended questions."+"<br><br>"+
   "- Each question will be presented on a screen"+"<br><br>"+
   "- Answers should be legible."+"<br><br>"+
   "- Each question will have a specific time limit for answering.The time will be available for each question."+"<br><br>"+
   "- Late submissions will not be accepted."+"<br><br>"+
   "- Scoring may vary depending on the question type:"+"<br><br>"+
    " - Multiple-choice questions: 2"+"<br><br>"+
     "- True/false questions: 1"+"<br><br>"+
     "- Open-ended questions: 1"+"<br><br>"+
   "- Cheating, plagiarism, or any form of dishonesty is strictly prohibited and will result in immediate disqualification of the individaul."+"<br></br>"+"<html>"
        );
        add(cond);
        
         back = new JButton("Back");
            back.setBounds(250,500,100,30);
            back.setBackground(new Color(143,0,255));
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);
            
            start = new JButton("Start");
            start.setBounds(400,500,100,30);
            start.setBackground(new Color(143,0,255));
            start.setForeground(Color.WHITE);
            start.addActionListener(this);
            add(start);
            
        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == start){
        setVisible(false);
        new quiz(name);
    }else if (ae.getSource() == back){
        setVisible(false);
        new login();
    }
    }
    
    public static void main(String[] args){
        new Rules("User");
    }
}
