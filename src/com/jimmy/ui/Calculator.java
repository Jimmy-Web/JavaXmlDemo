package com.jimmy.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator {

    private JFrame f; // ����
    private JTextField tf; // �ı���

    private JButton btn1; // ��ť 1
    private JButton btn2; // ��ť 2
    private JButton btnAdd; // ��ť �Ӻ� +
    private JButton btnEqual; // ��ť ���� =
    private JButton btnClear; // ��ť ���

    StringBuffer sb; // ����һ���������洢�ı����������ֵ
    Integer number1; // ����
    Integer number2; // ������
    Integer sum; // ��

    boolean b; // ������Ƿ񱻵��

    // ���췽��
   public Calculator() {
        // ��ʼ��ԭʼ����
        initData();
        // �ؼ���ʼ��
        initUI();
    }

    private void initData() {
        sb = new StringBuffer("");
        number1 = 0;
        number2 = 0;
        sum = 0;
        b = false;
    }

    private void initUI() {
        f = new JFrame("������");
        f.setSize(400, 200); // ���ô��ڵĿ��
        f.setLocation(100, 100); // ���ô��ڵ���ʼ��
        // f.setLayout(new FlowLayout()); // �����»��ƴ�С
        f.setResizable(false); // ���ô���һ�������ã������ڸı��С��
        // f.setBackground(Color.BLUE);
        // �رմ��ڵ��¼�
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true); // �ô��ڿɼ�

        // �ڴ�����������һ���ı���
        tf = new JTextField();
        tf.setBounds(20, 50, 360, 33);
        tf.setText("0");
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setBackground(Color.WHITE);
        f.add(tf);
        // tf ����¼�
        tfMouseEvent();
        
        // �ڴ���������Ӱ�ť
        btn1 = new JButton("1");
        btn1.setBounds(20, 100, 50, 33);
        f.add(btn1);

        btn2 = new JButton("2");
        btn2.setBounds(btn1.getBounds().x + 70, 100, 50, 33);
        f.add(btn2);

        btnAdd = new JButton("+");
        btnAdd.setBounds(btn2.getBounds().x + 70, 100, 50, 33);
        f.add(btnAdd);

        btnEqual = new JButton("=");
        btnEqual.setBounds(btnAdd.getBounds().x + 70, 100, 50, 33);
        f.add(btnEqual);

        btnClear = new JButton("C");
        btnClear.setBounds(btnEqual.getBounds().x + 70, 100, 50, 33);
        f.add(btnClear);

        // ��ť����¼�
        btnEvent();

        f.repaint();
    }
    private void tfMouseEvent() {
        tf.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mouseReleased");
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mousePressed");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mouseExited");
                tf.setBackground(Color.white);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mouseEntered");
                tf.setBackground(Color.cyan);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mouseClicked");
            }
        });
    }
    
    private void btnEvent() {
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
                if (b) {
                    sb = new StringBuffer("");
                    b = false;
                }
                sb.append(btn1.getText());
                tf.setText(sb.toString());
            }
        });

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
                if (b) {
                    sb = new StringBuffer("");
                    b = false;
                }
                sb.append(btn2.getText());
                tf.setText(sb.toString());
            }
        });
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
                b = true;
                number1 += new Integer(tf.getText());
                tf.setText(number1.toString());
            }
        });
        btnEqual.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
                b = false;
                number2 = new Integer(tf.getText());
                sum = number1 + number2;
                tf.setText(sum.toString());
            }
        });
        btnClear.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
                initData();
                tf.setText("0");
            }
        });
        
    }

}
