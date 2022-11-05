package top.onlywishes.bk.view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Color;import java.awt.Event;

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

public class LookManageUI extends JPanel {

	/**
	 * Create the panel.
	 */

	int index = 0;
	private paneDate panedate;		//绝对路径
	ImageIcon[] imageicon = { new ImageIcon("src\\top\\picture\\L1.jpg"), new ImageIcon("src\\top\\picture\\l2.jpg"),
			new ImageIcon("src\\top\\picture\\l3.jpg") };


	public LookManageUI() {
		setLayout(null);

		JPanel panelBig_Header = new JPanel();
		panelBig_Header.setLayout(null);
		panelBig_Header.setBorder(null);
		panelBig_Header.setBackground(new Color(245, 255, 250));
		panelBig_Header.setBounds(0, 0, 1135, 724);
		add(panelBig_Header);

		JButton btnSmallTools = new JButton("小工具");
		btnSmallTools.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RemainUI r = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}

		});
		btnSmallTools.setForeground(Color.WHITE);
		btnSmallTools.setBackground(new Color(102, 205, 170));
		btnSmallTools.setBounds(644, 604, 100, 40);
		panelBig_Header.add(btnSmallTools);

		JButton btnMaintheme = new JButton("主题");
		btnMaintheme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				setVisible(true);
			}
		});
		btnMaintheme.setForeground(Color.WHITE);
		btnMaintheme.setBackground(new Color(255, 160, 122));
		btnMaintheme.setBounds(263, 604, 100, 40);
		panelBig_Header.add(btnMaintheme);

		JButton btnCustomize = new JButton("自定义");
		btnCustomize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}
		});

		btnCustomize.setForeground(Color.WHITE);
		btnCustomize.setBackground(new Color(102, 205, 107));
		btnCustomize.setBounds(455, 604, 100, 40);
		panelBig_Header.add(btnCustomize);

		JButton btnBackground = new JButton("背景");
		btnBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}
		});
		btnBackground.setForeground(Color.WHITE);
		btnBackground.setBackground(new Color(255, 160, 122));
		btnBackground.setBounds(823, 604, 100, 40);
		panelBig_Header.add(btnBackground);



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
