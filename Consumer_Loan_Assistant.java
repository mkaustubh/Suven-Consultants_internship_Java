package com.suven.consultancy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Consumer_Loan_Assistant extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,la;
    JTextField tf1,tf2,tf3,tf4;
    JButton b1,b2,x1,x2,exit;
    JTextArea ta;
    Font flabel,fbutton;
    Boolean tf3enabled=false,tf4enabled=true;

    Consumer_Loan_Assistant(){
        super("                                                                          Consumer Loan Assistant");

        ta=new JTextArea("");
        ta.setBounds(400,40,300,150);
        ta.setFont(new Font("Segoe Script",Font.PLAIN,14));
//        ta.setBackground(Color.YELLOW);
        ta.setForeground(Color.BLACK);
        ta.setEditable(false);
        ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(ta);

        flabel =new Font("Arial", Font.PLAIN,16);
        fbutton=new Font("SANS_SERIF",Font.BOLD,13);

        la = new JLabel("Loan Analysis: ");
        l1=new JLabel("Loan Balance");
        l2=new JLabel("Interest Rate");
        l3=new JLabel("Number of Payments");
        l4=new JLabel("Monthly Payment");

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();

        b1=new JButton("Compute Monthly Payment");
        b2=new JButton("New Loan Analysis");

        setLayout(null);
        setSize(800,300);
//        getContentPane().setBackground(Color.RED);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        la.setBounds(400,0,150,50);
        la.setFont(flabel);
        add(la);

        l1.setBounds(20,0,100,50);
        l1.setFont(flabel);
        add(l1);

        l2.setBounds(20,30,150,50);
        l2.setFont(flabel);
        add(l2);

        l3.setBounds(20,60,150,50);
        l3.setFont(flabel);
        add(l3);

        l4.setBounds(20,90,150,50);
        l4.setFont(flabel);
        add(l4);

        b1.setBounds(50,140,250,30);
        b1.setFont(fbutton);
        add(b1);

        b2.setBounds(75,190,200,30);
        b2.setFont(fbutton);
        b2.setEnabled(false);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        tf1.setBounds(170,15,100,20);
        tf1.setFont(flabel);
        tf1.setHorizontalAlignment(JTextField.RIGHT);
        add(tf1);

        tf2.setBounds(170,45,100,20);
        tf2.setHorizontalAlignment(JTextField.RIGHT);
        tf2.setFont(flabel);
        add(tf2);

        tf3.setBounds(170,80,100,20);
        tf3.setHorizontalAlignment(JTextField.RIGHT);
        tf3.setFont(flabel);
        add(tf3);

        tf4.setBounds(170,110,100,20);
        tf4.setHorizontalAlignment(JTextField.RIGHT);
        tf4.setFont(flabel);
        tf4.setEditable(false);
        tf4.setForeground(Color.BLACK);
        tf4.setBackground(Color.YELLOW);
        add(tf4);

        x1=new JButton("X");
        x1.setBounds(300,70,50,25);
        x1.setFont(fbutton);
        add(x1);

        x2=new JButton("X");
        x2.setBounds(300,110,50,25);
        x2.setFont(fbutton);
        add(x2);
        x2.setVisible(false);

        x1.addActionListener(this);
        x2.addActionListener(this);

        exit= new JButton("Exit");
        exit.setBounds(500,220,100,30);
        exit.setFont(fbutton);
        add(exit);
        exit.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                if(tf2.getText().equals("") || tf2.getText().equals("0")) {
                JOptionPane.showMessageDialog(null,"Interest Rate cannot be 0%");
                }
                if ((tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("")) && (tf1.getText().equals("") || tf2.getText().equals("") || tf4.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Fill All The Required Details");
                }
                if (tf4.getText().equals("")) {
                    float A = Float.parseFloat(tf1.getText());
                    float i = Float.parseFloat(tf2.getText());
                    float n = Float.parseFloat(tf3.getText());
                    float I = i / 1200;
                    float P = (float) (I * A / (1 - Math.pow((1 + I), -n)));
                    tf4.setText(P + "");
                    String str="Loan Amount : $"+A+"\n";
                    str+="Interest Rate : "+I*1200+"%\n\n";
                    str+=n+" Payments of : $"+P;
                    ta.setText(str);
                }
                if (tf3.getText().equals("")) {
                    float A = Float.parseFloat(tf1.getText());
                    float i = Float.parseFloat(tf2.getText());
                    float P = Float.parseFloat(tf4.getText());
                    float I = i / 1200;
                    float n = (float) (-(Math.log10(1 - I * A / P)) / Math.log10(1 + I));
                    tf3.setText(n + "");
                    String str="Loan Amount : $"+A+"\n";
                    str+="Interest Rate : "+I*1200+"%\n\n";
                    str+=n+" Payments of : $"+P;
                    ta.setText(str);
                }
//                String As = ""+A;
                b1.setEnabled(false);
                b2.setEnabled(true);
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
        if(e.getSource()==b2) {
            if (tf4enabled) {
                tf4.setText(null);
//            tf3.setText(null);
            }
            if(tf3enabled){
                tf3.setText(null);
            }
            b1.setEnabled(true);
            b2.setEnabled(false);
        }
        if(e.getSource()==x1){
            x1.setVisible(false);
            x2.setVisible(true);
            tf4.setEditable(true);
            tf3.setEditable(false);
            tf3.setBackground(Color.YELLOW);
            tf4.setBackground(Color.white);
            tf3enabled=true;
            tf4enabled=false;
            tf3.setText(null);

            b1.setEnabled(true);
            b2.setEnabled(false);
        }
        if(e.getSource()==x2){
            x1.setVisible(true);
            x2.setVisible(false);
            tf4.setEditable(false);
            tf3.setEditable(true);
            tf3.setBackground(Color.white);
            tf4.setBackground(Color.yellow);
            tf3enabled=false;
            tf4enabled=true;
            tf4.setText(null);

            b1.setEnabled(true);
            b2.setEnabled(false);
        }
        if(e.getSource()==exit){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        // write your code here
         new Consumer_Loan_Assistant();
    }

}
