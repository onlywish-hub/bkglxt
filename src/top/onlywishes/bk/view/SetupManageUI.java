package top.onlywishes.bk.view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import top.onlywishes.bk.view.bkManagerPanel.paneDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SetupManageUI extends JPanel {

	/**
	 * Create the panel.
	 */

	int index = 0;
	private paneDate panedate;
	ImageIcon[] imageicon = { new ImageIcon("src\\top\\picture\\sz1.jpg"), new ImageIcon("src\\top\\picture\\sz2.jpg"),
			new ImageIcon("src\\top\\picture\\sz4.jpg") };


	public SetupManageUI() {
		setLayout(null);

		JPanel panelBig_Header = new JPanel();
		panelBig_Header.setLayout(null);
		panelBig_Header.setBorder(null);
		panelBig_Header.setBackground(new Color(245, 255, 250));
		panelBig_Header.setBounds(0, 0, 1135, 724);
		add(panelBig_Header);

		JButton btnTaoLun = new JButton("讨论");
		btnTaoLun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RemainUI r = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}

		});
		btnTaoLun.setForeground(Color.WHITE);
		btnTaoLun.setBackground(new Color(102, 205, 170));
		btnTaoLun.setBounds(586, 604, 100, 40);
		panelBig_Header.add(btnTaoLun);

		JButton btnChangGui = new JButton("常规");
		btnChangGui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				setVisible(true);
			}
		});
		btnChangGui.setForeground(Color.WHITE);
		btnChangGui.setBackground(new Color(255, 160, 122));
		btnChangGui.setBounds(77, 604, 100, 40);
		panelBig_Header.add(btnChangGui);

		JButton btnZhuanXie = new JButton("撰写");
		btnZhuanXie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}
		});

		btnZhuanXie.setForeground(Color.WHITE);
		btnZhuanXie.setBackground(new Color(102, 205, 107));
		btnZhuanXie.setBounds(249, 604, 100, 40);
		panelBig_Header.add(btnZhuanXie);

		JButton btnYinSi = new JButton("隐私");
		btnYinSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrivacyUI ui = new PrivacyUI();
				ui.setVisible(true);
			}
		});
		btnYinSi.setForeground(Color.WHITE);
		btnYinSi.setBackground(new Color(255, 160, 122));
		btnYinSi.setBounds(747, 604, 100, 40);
		panelBig_Header.add(btnYinSi);

		JButton btnYueDu = new JButton("阅读");
		btnYueDu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}
		});
		btnYueDu.setForeground(Color.WHITE);
		btnYueDu.setBackground(new Color(255, 160, 122));
		btnYueDu.setBounds(422, 604, 100, 40);
		panelBig_Header.add(btnYueDu);

		JButton btnGYWM = new JButton("关于我们");
		btnGYWM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}
		});
		btnGYWM.setForeground(Color.WHITE);
		btnGYWM.setBackground(new Color(102, 205, 170));
		btnGYWM.setBounds(913, 604, 100, 40);
		panelBig_Header.add(btnGYWM);



		panedate = new paneDate();	//这里定义pandDate类对象
		panedate.setBounds(20, 30, 1080, 540);
		panedate.setBorder(new LineBorder(Color.blue));
		add(panedate);
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panedate.repaint();
			}
		});
		timer.start();
	}

class paneDate extends JPanel {
		/**
		 *
		 */
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(imageicon[index % imageicon.length].getImage(), 0, 0, this);
			index++;
		}

	}
}
