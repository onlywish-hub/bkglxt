package top.onlywishes.bk.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public  class loginMainUI<txtLogin> extends JFrame {

	public JPanel contentPane;
	public JPanel panelUI;
	public static String USERNAME;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				loginMainUI frame = new loginMainUI();
				frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public loginMainUI() {
//		loginUI in = new loginUI();
//		if(in.into==1) {
//			this.dispose();
//			new MainUI().setVisible(true);
//		}

		this.setResizable(false);
		setLOGO();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 633);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(246, 253, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelUI = new JPanel();
		panelUI.setBounds(0, 0, 984, 519);
		// 将登陆面板加入

		panelUI.setVisible(true);
		panelUI = new loginUI();
		panelUI.setLocation(0, 0);
		contentPane.add(panelUI);


		//图片的绝对路径
		ImageIcon register = new ImageIcon("src\\top\\picture\\left.png");
		JLabel lblResigter = new JLabel(register);
		lblResigter.setBounds(865, 560, 54, 15);
		contentPane.add(lblResigter);

		JButton btnNewButton = new JButton("注册");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(238, 232, 170));
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(245, 255, 250));
			}
		});
		btnNewButton.setBackground(new Color(245, 255, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnNewButton.getText().equals("注册")) {
					contentPane.setBackground(new Color(255, 240, 245));
					panelUI.setVisible(false);
					panelUI = new registerUI1();
					panelUI.setBounds(0, 0, 984, 519);
					contentPane.add(panelUI);
					repaint();
					btnNewButton.setText("登陆");

				} else if (btnNewButton.getText().equals("登陆")) {
					contentPane.setBackground(new Color(245, 255, 250));
					panelUI.setVisible(false);
					panelUI = new loginUI();
					panelUI.setLocation(0, 0);
					contentPane.add(panelUI);
					repaint();
					btnNewButton.setText("注册");
				}
			}
		});
		btnNewButton.setBounds(914, 552, 60, 30);
		contentPane.add(btnNewButton);
	}

	// 设置logo
	public void setLOGO() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
		Image img = tk.getImage("src\\top\\picture\\fox.png");	//用绝对路径ye行
		// 给窗体设置图标
		this.setIconImage(img);

	}

}
