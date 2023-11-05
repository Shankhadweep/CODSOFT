package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class quiz extends JFrame implements ActionListener{
    
    String questions[][]=new String[5][5];
    String answers[][]=new String[5][2];
    String usrans[][]=new String[5][1];
    JLabel qno,question;
    JRadioButton opt,opt1,opt2,opt3;
    ButtonGroup grpopt;
    JButton next,time,submit;
    public static int timer=15;
    public static int isans=0;
    public static int count=0;
    public static int score=0;
    String username;
    quiz(String username)
    {
        this.username=username;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel pic = new JLabel(i1);
        pic.setBounds(0,0,1440,392);
        add(pic);
        
        qno = new JLabel("1");
        qno.setBounds(100,450, 50, 30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahome",Font.PLAIN,24));
        add(question);
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        
        opt = new JRadioButton();
        opt.setBounds(170,520,700,30);
        opt.setBackground(Color.WHITE);
        opt.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt);
        
        opt1 = new JRadioButton();
        opt1.setBounds(170,560,700,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170,600,700,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170,640,700,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        
        grpopt = new ButtonGroup();
        grpopt.add(opt);
        grpopt.add(opt1);
        grpopt.add(opt2);
        grpopt.add(opt3);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        time = new JButton("Less options");
        time.setBounds(1100, 630, 250, 40);
        time.setFont(new Font("Tahoma",Font.PLAIN,22));
        time.setBackground(new Color(30,144,255));
        time.setForeground(Color.WHITE);
        time.addActionListener(this);
        add(time);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();
            opt.setEnabled(true);
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            
            isans=1;
             if(grpopt.getSelection()==null){
                usrans[count][0]="";
            }
            else
            {
                usrans[count][0]=grpopt.getSelection().getActionCommand();
            }
             if(count==3){
                 next.setEnabled(false);
                 submit.setEnabled(true);
             }
            count++;
            start(count);
        }else if(ae.getSource()==time){
            if(count==2 || count==4){
                opt1.setEnabled(false);
                opt2.setEnabled(false);
            }
            else
            {
                opt.setEnabled(false);
                opt3.setEnabled(false);
            }
            time.setEnabled(false);
        }else
        {
            isans=1;
            if(grpopt.getSelection()==null){
                usrans[count][0]="";
            }
            else
            {
                usrans[count][0]=grpopt.getSelection().getActionCommand();
            }
                 for(int i=0;i<usrans.length;i++)
                 {
                     if(usrans[i][0].equals(answers[i][1])){
                         score+=10;
                     }
                 }
                 setVisible(false);
                 new score(username,score);
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        String time = "Time left: "+ timer +" seconds";
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Times New Roman",Font.BOLD,20));
        if(timer>0){
            g.drawString(time,1100,500);
        }
        else
        {
            g.drawString("Times's Up!!!",1100,500);
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        if(isans==1){
            isans=0;
            timer=15;
        }else if(timer<0)
        {
            timer = 15;
            opt.setEnabled(true);
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            if(count==3){
                 next.setEnabled(false);
                 submit.setEnabled(true);
             }
            if(count==4){
                 if(grpopt.getSelection()==null){
                usrans[count][0]="";
                repaint();
            }
            else
            {
                usrans[count][0]=grpopt.getSelection().getActionCommand();
            }
                 for(int i=0;i<usrans.length;i++)
                 {
                     if(usrans[i][0].equals(answers[i][1])){
                         score+=10;
                     }
                 }
                 setVisible(false);
                 new score(username,score);
            }else{
                 if(grpopt.getSelection()==null){
                usrans[count][0]="";
                repaint();
            }
            else
            {
                usrans[count][0]=grpopt.getSelection().getActionCommand();
            }
            count++;
            start(count);
        }
            }
    }
    
    public void start (int count)
    {
        qno.setText(""+(count+1)+". ");
        question.setText(questions[count][0]);
        opt.setText(questions[count][1]);
        opt.setActionCommand(questions[count][1]);
        opt1.setText(questions[count][2]);
        opt1.setActionCommand(questions[count][2]);
        opt2.setText(questions[count][3]);
        opt2.setActionCommand(questions[count][3]);
        opt3.setText(questions[count][4]);
        opt3.setActionCommand(questions[count][4]);
        
        grpopt.clearSelection();
    }
    
    public static void main(String[] args){
        new quiz("User");
    }
}
