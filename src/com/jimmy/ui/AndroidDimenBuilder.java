package com.jimmy.ui;

import java.awt.BorderLayout;
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

public class AndroidDimenBuilder {

    private JFrame window; // ����
    private JTextField title; // �ı���
    private JButton create; // ���ɰ�ť
    private JButton cancel; // ȡ����ť
    private JTextField width;//��׿�豸��Ļ�Ŀ��
    private JTextField height;//��׿�豸��Ļ�ĸ߶�
    StringBuffer sb; // ����һ���������洢�ı����������ֵ
    Integer number1; // ����
    Integer number2; // ������
    Integer sum; // ��

    boolean b; // ������Ƿ񱻵��

    // ���췽��
   public AndroidDimenBuilder() {
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
    	window = new JFrame("Android Dimen�ļ�������");
    	window.setSize(400, 600); // ���ô��ڵĿ��
    	window.setLocation(100, 100); // ���ô��ڵ���ʼ��
        // f.setLayout(new FlowLayout()); // �����»��ƴ�С
    	window.setResizable(false); // ���ô���һ�������ã������ڸı��С��
        // f.setBackground(Color.BLUE);
        // �رմ��ڵ��¼�
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setVisible(true); // �ô��ڿɼ�
        // �ڴ�����������һ���ı���
        title = new JTextField();
        title.setBounds(20, 50, 360, 33);
        title.setText("0");
        title.setHorizontalAlignment(JTextField.RIGHT);
        title.setBackground(Color.WHITE);
        window.add(title);
        // �ڴ���������Ӱ�ť
        create = new JButton("Create");
        create.setBounds(20, 100, 50, 33);
        window.add(create);
        cancel = new JButton("Cancel");
        cancel.setBounds(create.getBounds().x + 70, 100, 50, 33);
        window.add(cancel);
        //��ʼ�������
        width = new JTextField("0");
        height = new JTextField("0");
        window.add(width,BorderLayout.CENTER);
        window.add(height,BorderLayout.CENTER);
        // ��ť����¼�
        btnEvent();
        // tf ����¼�
        tfMouseEvent();
        window.repaint();
    }
    
    private void tfMouseEvent() {
    	title.addMouseListener(new MouseListener() {
            
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
                title.setBackground(Color.white);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mouseEntered");
                title.setBackground(Color.cyan);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO �Զ����ɵķ������
                System.out.println("mouseClicked");
            }
        });
    }
    
    private void btnEvent() {
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
            	System.out.println("�����create��ť");
            }
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO �Զ����ɵķ������
            	System.out.println("�����cancel��ť");
            }
        });  
    }

}
