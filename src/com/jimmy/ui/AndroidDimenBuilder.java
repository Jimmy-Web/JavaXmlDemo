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

    private JFrame window; // 窗体
    private JTextField title; // 文本框
    private JButton create; // 生成按钮
    private JButton cancel; // 取消按钮
    private JTextField width;//安卓设备屏幕的宽度
    private JTextField height;//安卓设备屏幕的高度
    StringBuffer sb; // 定义一个变量，存储文本框里面的数值
    Integer number1; // 加数
    Integer number2; // 被加数
    Integer sum; // 和

    boolean b; // 运算符是否被点击

    // 构造方法
   public AndroidDimenBuilder() {
        // 初始化原始数据
        initData();
        // 控件初始化
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
    	window = new JFrame("Android Dimen文件生成器");
    	window.setSize(400, 600); // 设置窗口的宽高
    	window.setLocation(100, 100); // 设置窗口的起始点
        // f.setLayout(new FlowLayout()); // 会重新绘制大小
    	window.setResizable(false); // 设置窗口一旦创建好，不能在改变大小。
        // f.setBackground(Color.BLUE);
        // 关闭窗口的事件
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setVisible(true); // 让窗口可见
        // 在窗口上面增加一个文本框
        title = new JTextField();
        title.setBounds(20, 50, 360, 33);
        title.setText("0");
        title.setHorizontalAlignment(JTextField.RIGHT);
        title.setBackground(Color.WHITE);
        window.add(title);
        // 在窗口上面添加按钮
        create = new JButton("Create");
        create.setBounds(20, 100, 50, 33);
        window.add(create);
        cancel = new JButton("Cancel");
        cancel.setBounds(create.getBounds().x + 70, 100, 50, 33);
        window.add(cancel);
        //初始化输入框
        width = new JTextField("0");
        height = new JTextField("0");
        window.add(width,BorderLayout.CENTER);
        window.add(height,BorderLayout.CENTER);
        // 按钮点击事件
        btnEvent();
        // tf 鼠标事件
        tfMouseEvent();
        window.repaint();
    }
    
    private void tfMouseEvent() {
    	title.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO 自动生成的方法存根
                System.out.println("mouseReleased");
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根
                System.out.println("mousePressed");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根
                System.out.println("mouseExited");
                title.setBackground(Color.white);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根
                System.out.println("mouseEntered");
                title.setBackground(Color.cyan);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                System.out.println("mouseClicked");
            }
        });
    }
    
    private void btnEvent() {
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
            	System.out.println("点击了create按钮");
            }
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
            	System.out.println("点击了cancel按钮");
            }
        });  
    }

}
