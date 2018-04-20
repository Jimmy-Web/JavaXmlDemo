package com.jimmy.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AndroidDimenBuilder {

	private JFrame window; // 窗体
	private JButton create; // 生成按钮
	private JButton cancel; // 取消按钮
	private JTextField width;// 安卓设备屏幕的宽度
	private JTextField height;// 安卓设备屏幕的高度
	////////////
	private JTextField screenWidth;
	private JTextField screenHeight;
	private JLabel widthLabel, heightLabel;
	private JPanel panel1, panel2, panel3;
	Dialog alertDialog;

	// 构造方法
	public AndroidDimenBuilder() {
		// 初始化原始数据
		initData();
		// 控件初始化
		createView();
	}

	private void initData() {

	}

	
	/**
	 * 初始化界面
	 */
	private void initUI() {
		window = new JFrame("安卓dimen文件生成器");
		window.setLocation(300, 300); // 设置窗口的起始点
		// f.setLayout(new FlowLayout()); // 会重新绘制大小
		window.setResizable(true); // 设置窗口是否可以改变大小
		// f.setBackground(Color.BLUE);
		// 关闭窗口的事件
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建两个标签
		Label heightLabel = new Label("高度");
		Label widthLabel = new Label("宽度");
		// 初始化输入框
		width = new JTextField("0");
		width.setSize(50, 20);
		height = new JTextField("0");
		height.setSize(50, 20);
		// 创建一个承装高度标签以及高度输入框的面板
		Panel heightPanel = new Panel();
		// 创建一个承装宽度标签以及宽度输入框的面板
		Panel widhtPanel = new Panel();
		// 处理宽度面板
		widhtPanel.add(widthLabel);
		widhtPanel.add(width);
		// 处理高度面板
		heightPanel.add(heightLabel);
		heightPanel.add(height);
		// 定义一个垂直摆放组件的Box对象
		Box box = Box.createVerticalBox();
		box.add(widhtPanel);
		box.add(heightPanel);
		// 在窗口上面添加按钮
		create = new JButton("Create");
		// create.setBounds(20, 100, 50, 33);
		window.add(create);
		cancel = new JButton("Cancel");
		cancel.setBounds(create.getBounds().x + 70, 100, 50, 33);
		window.add(cancel);

		window.add(box);
		// window.pack();
		window.setVisible(true); // 让窗口可见
		// 按钮点击事件
		btnEvent();
		// tf 鼠标事件
		// tfMouseEvent();
		window.repaint();
	}

	// private void tfMouseEvent() {
	// title.addMouseListener(new MouseListener() {
	//
	// @Override
	// public void mouseReleased(MouseEvent e) {
	// // TODO 自动生成的方法存根
	// System.out.println("mouseReleased");
	// }
	//
	// @Override
	// public void mousePressed(MouseEvent e) {
	// // TODO 自动生成的方法存根
	// System.out.println("mousePressed");
	// }
	//
	// @Override
	// public void mouseExited(MouseEvent e) {
	// // TODO 自动生成的方法存根
	// System.out.println("mouseExited");
	// title.setBackground(Color.white);
	// }
	//
	// @Override
	// public void mouseEntered(MouseEvent e) {
	// // TODO 自动生成的方法存根
	// System.out.println("mouseEntered");
	// title.setBackground(Color.cyan);
	// }
	//
	// @Override
	// public void mouseClicked(MouseEvent e) {
	// // TODO 自动生成的方法存根
	// System.out.println("mouseClicked");
	// }
	// });
	// }

	private void createView() {
		window = new JFrame("安卓dimen文件生成器");
		window.setLocation(400, 400);
		// 创建组件
		create = new JButton("开始创建");
		cancel = new JButton("取消");
		// 创建输入框
		screenHeight = new JTextField(10);
		screenWidth = new JTextField(10);
		// 给输入框设置智能输入数字
		screenHeight.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				// 只能输入数字
				String s = screenHeight.getText();
				if (s.length() >= 5) {
					e.consume();
				} else {
					char keyCh = e.getKeyChar();
					if (keyCh >= KeyEvent.VK_0 && keyCh <= KeyEvent.VK_9) {
					} else {
						//关键，屏蔽掉非法输入
						e.consume(); 
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		screenWidth.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				// 只能输入数字
				String s = screenWidth.getText();
				if (s.length() >= 5) {
					e.consume();
				} else {
					char keyCh = e.getKeyChar();
					if (keyCh >= KeyEvent.VK_0 && keyCh <= KeyEvent.VK_9) {
					} else {
						// 关键，屏蔽掉非法输入
						e.consume(); 
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// 创建标签
		widthLabel = new JLabel("屏幕宽度：");
		heightLabel = new JLabel("屏幕高度：");
		// 创建多个panel
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		// 设置布局管理器
		window.setLayout(new GridLayout(3, 1, 5, 5));
		// 添加组件
		panel1.add(widthLabel);
		panel1.add(screenWidth);

		panel2.add(heightLabel);
		panel2.add(screenHeight);

		panel3.add(create);
		panel3.add(cancel);

		window.add(panel1);
		window.add(panel2);
		window.add(panel3);
		// 设置窗体属性
		window.setSize(280, 160);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		btnEvent();
	}

	/**
	 * 弹出alert
	 */
	private void showAlert(Frame frame) {
		alertDialog= new Dialog(frame, "提示", true);
		alertDialog.setSize(50, 30);
		alertDialog.setVisible(true);
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
