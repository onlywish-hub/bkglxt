package top.onlywishes.bk.view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Color;
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

public class MediumManageUI extends JPanel {

	/**
	 * Create the panel.
	 */

	int index = 0;
	private paneDate panedate;
	ImageIcon[] imageicon = { new ImageIcon("src\\top\\picture\\1lb.jpg"), new ImageIcon("src\\top\\picture\\2lb.jpg"),
			new ImageIcon("src\\top\\picture\\5lb.jpg"), new ImageIcon("src\\top\\picture\\3lb.jpg"), new ImageIcon("src\\top\\picture\\4lb.jpg"),
			new ImageIcon("src\\top\\picture\\6lb.jpg") };


	public MediumManageUI() {
		setLayout(null);

		JPanel panelBig_Header = new JPanel();
		panelBig_Header.setLayout(null);
		panelBig_Header.setBorder(null);
		panelBig_Header.setBackground(new Color(245, 255, 250));
		panelBig_Header.setBounds(0, 0, 1135, 724);
		add(panelBig_Header);

		JButton btnLend = new JButton("添加新文件");
		btnLend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RemainUI r = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
			}

		});
		btnLend.setForeground(Color.WHITE);
		btnLend.setBackground(new Color(102, 205, 170));
		btnLend.setBounds(663, 604, 100, 40);
		panelBig_Header.add(btnLend);

		JButton btnDelete = new JButton("媒体库");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ruv = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				setVisible(true);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 160, 122));
		btnDelete.setBounds(295, 604, 100, 40);
		panelBig_Header.add(btnDelete);



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
