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

	private JFrame window; // ����
	private JButton create; // ���ɰ�ť
	private JButton cancel; // ȡ����ť
	private JTextField width;// ��׿�豸��Ļ�Ŀ��
	private JTextField height;// ��׿�豸��Ļ�ĸ߶�
	////////////
	private JTextField screenWidth;
	private JTextField screenHeight;
	private JLabel widthLabel, heightLabel;
	private JPanel panel1, panel2, panel3;
	Dialog alertDialog;

	// ���췽��
	public AndroidDimenBuilder() {
		// ��ʼ��ԭʼ����
		initData();
		// �ؼ���ʼ��
		createView();
	}

	private void initData() {

	}

	
	/**
	 * ��ʼ������
	 */
	private void initUI() {
		window = new JFrame("��׿dimen�ļ�������");
		window.setLocation(300, 300); // ���ô��ڵ���ʼ��
		// f.setLayout(new FlowLayout()); // �����»��ƴ�С
		window.setResizable(true); // ���ô����Ƿ���Ըı��С
		// f.setBackground(Color.BLUE);
		// �رմ��ڵ��¼�
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����������ǩ
		Label heightLabel = new Label("�߶�");
		Label widthLabel = new Label("���");
		// ��ʼ�������
		width = new JTextField("0");
		width.setSize(50, 20);
		height = new JTextField("0");
		height.setSize(50, 20);
		// ����һ����װ�߶ȱ�ǩ�Լ��߶����������
		Panel heightPanel = new Panel();
		// ����һ����װ��ȱ�ǩ�Լ�������������
		Panel widhtPanel = new Panel();
		// ���������
		widhtPanel.add(widthLabel);
		widhtPanel.add(width);
		// ����߶����
		heightPanel.add(heightLabel);
		heightPanel.add(height);
		// ����һ����ֱ�ڷ������Box����
		Box box = Box.createVerticalBox();
		box.add(widhtPanel);
		box.add(heightPanel);
		// �ڴ���������Ӱ�ť
		create = new JButton("Create");
		// create.setBounds(20, 100, 50, 33);
		window.add(create);
		cancel = new JButton("Cancel");
		cancel.setBounds(create.getBounds().x + 70, 100, 50, 33);
		window.add(cancel);

		window.add(box);
		// window.pack();
		window.setVisible(true); // �ô��ڿɼ�
		// ��ť����¼�
		btnEvent();
		// tf ����¼�
		// tfMouseEvent();
		window.repaint();
	}

	// private void tfMouseEvent() {
	// title.addMouseListener(new MouseListener() {
	//
	// @Override
	// public void mouseReleased(MouseEvent e) {
	// // TODO �Զ����ɵķ������
	// System.out.println("mouseReleased");
	// }
	//
	// @Override
	// public void mousePressed(MouseEvent e) {
	// // TODO �Զ����ɵķ������
	// System.out.println("mousePressed");
	// }
	//
	// @Override
	// public void mouseExited(MouseEvent e) {
	// // TODO �Զ����ɵķ������
	// System.out.println("mouseExited");
	// title.setBackground(Color.white);
	// }
	//
	// @Override
	// public void mouseEntered(MouseEvent e) {
	// // TODO �Զ����ɵķ������
	// System.out.println("mouseEntered");
	// title.setBackground(Color.cyan);
	// }
	//
	// @Override
	// public void mouseClicked(MouseEvent e) {
	// // TODO �Զ����ɵķ������
	// System.out.println("mouseClicked");
	// }
	// });
	// }

	private void createView() {
		window = new JFrame("��׿dimen�ļ�������");
		window.setLocation(400, 400);
		// �������
		create = new JButton("��ʼ����");
		cancel = new JButton("ȡ��");
		// ���������
		screenHeight = new JTextField(10);
		screenWidth = new JTextField(10);
		// �����������������������
		screenHeight.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				// ֻ����������
				String s = screenHeight.getText();
				if (s.length() >= 5) {
					e.consume();
				} else {
					char keyCh = e.getKeyChar();
					if (keyCh >= KeyEvent.VK_0 && keyCh <= KeyEvent.VK_9) {
					} else {
						//�ؼ������ε��Ƿ�����
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
				// ֻ����������
				String s = screenWidth.getText();
				if (s.length() >= 5) {
					e.consume();
				} else {
					char keyCh = e.getKeyChar();
					if (keyCh >= KeyEvent.VK_0 && keyCh <= KeyEvent.VK_9) {
					} else {
						// �ؼ������ε��Ƿ�����
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
		// ������ǩ
		widthLabel = new JLabel("��Ļ��ȣ�");
		heightLabel = new JLabel("��Ļ�߶ȣ�");
		// �������panel
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		// ���ò��ֹ�����
		window.setLayout(new GridLayout(3, 1, 5, 5));
		// ������
		panel1.add(widthLabel);
		panel1.add(screenWidth);

		panel2.add(heightLabel);
		panel2.add(screenHeight);

		panel3.add(create);
		panel3.add(cancel);

		window.add(panel1);
		window.add(panel2);
		window.add(panel3);
		// ���ô�������
		window.setSize(280, 160);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		btnEvent();
	}

	/**
	 * ����alert
	 */
	private void showAlert(Frame frame) {
		alertDialog= new Dialog(frame, "��ʾ", true);
		alertDialog.setSize(50, 30);
		alertDialog.setVisible(true);
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
