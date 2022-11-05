package top.onlywishes.bk.view;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class bkManagerPanel extends JPanel {


	int index = 0;
	private paneDate panedate;			//显示不出来，这里要用绝对路径
	ImageIcon[] imageicon = { new ImageIcon("src\\top\\picture\\lb1.png"), new ImageIcon("src\\top\\picture\\lb2.jpg"),
			new ImageIcon("src\\top\\picture\\lb3.jpg"), new ImageIcon("src\\top\\picture\\环游地球.jpg"), new ImageIcon("src\\top\\picture\\lb4.jpg"),
			new ImageIcon("src\\top\\picture\\lb5.jpg") };

	/**
	 * Create the panel.
	 */
	public bkManagerPanel() {
		setBackground(new Color(255, 255, 255));
		setSize(1135, 724);
		setLayout(null);

		JPanel panel_two = new JPanel();
		panel_two.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_two.setBackground(Color.WHITE);
		panel_two.setBounds(296, 10, 166, 100);
		this.add(panel_two);
		panel_two.setLayout(null);


		JLabel lblTwo = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/lblTwo1.png")));
		lblTwo.setBackground(Color.WHITE);
		lblTwo.setBounds(36, 20, 60, 60);
		panel_two.add(lblTwo);

		JLabel lblNumber1_1 = new JLabel("16");
		lblNumber1_1.setForeground(new Color(0, 191, 255));
		lblNumber1_1.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		lblNumber1_1.setBounds(116, 30, 40, 25);
		panel_two.add(lblNumber1_1);

		JLabel lblmessage_1 = new JLabel("Date");
		lblmessage_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblmessage_1.setBounds(116, 65, 35, 15);
		panel_two.add(lblmessage_1);

		JPanel panel_one = new JPanel();
		panel_one.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_one.setBackground(Color.WHITE);
		panel_one.setBounds(10, 10, 166, 100);
		this.add(panel_one);
		panel_one.setLayout(null);


		JLabel lblOne = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/lblOne.png")));
		lblOne.setBackground(Color.WHITE);
		lblOne.setBounds(10, 20, 60, 60);
		panel_one.add(lblOne);

		JLabel lblNumber1 = new JLabel("23");
		lblNumber1.setForeground(new Color(220, 20, 60));
		lblNumber1.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		lblNumber1.setBounds(96, 32, 54, 25);
		panel_one.add(lblNumber1);

		JLabel lblmessage = new JLabel("Message");
		lblmessage.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblmessage.setBounds(84, 65, 66, 15);
		panel_one.add(lblmessage);

		JPanel panel_Three = new JPanel();
		panel_Three.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Three.setBackground(Color.WHITE);
		panel_Three.setBounds(593, 10, 190, 100);
		this.add(panel_Three);
		panel_Three.setLayout(null);


		JLabel lblThree = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/lblThree1.png")));
		lblThree.setBackground(Color.WHITE);
		lblThree.setBounds(43, 20, 60, 60);
		panel_Three.add(lblThree);

		JLabel lblNumber1_2 = new JLabel("118");
		lblNumber1_2.setForeground(new Color(32, 178, 170));
		lblNumber1_2.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		lblNumber1_2.setBounds(131, 30, 47, 25);
		panel_Three.add(lblNumber1_2);

		JLabel lblmessage_2 = new JLabel("Phone");
		lblmessage_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblmessage_2.setBounds(134, 65, 40, 15);
		panel_Three.add(lblmessage_2);

		JPanel panel_Four = new JPanel();
		panel_Four.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_Four.setBackground(Color.WHITE);
		panel_Four.setBounds(888, 10, 166, 100);
		this.add(panel_Four);
		panel_Four.setLayout(null);


		JLabel lblFive = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/lblFour1.png")));
		lblFive.setBackground(Color.WHITE);
		lblFive.setBounds(36, 21, 60, 60);
		panel_Four.add(lblFive);

		JLabel lblNumber1_3 = new JLabel("51");
		lblNumber1_3.setForeground(new Color(153, 50, 204));
		lblNumber1_3.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		lblNumber1_3.setBounds(110, 31, 26, 25);
		panel_Four.add(lblNumber1_3);

		JLabel lblmessage_3 = new JLabel("Path");
		lblmessage_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblmessage_3.setBounds(107, 66, 32, 15);
		panel_Four.add(lblmessage_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_2.setBounds(10, 120, 1125, 190);
		this.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblpicture = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/主页.png")));
		lblpicture.setBounds(10, 10, 1115, 189);
		panel_2.add(lblpicture);

		JLabel lbllegend = new JLabel("Legend 1");
		lbllegend.setFont(new Font("宋体", Font.PLAIN, 14));
		lbllegend.setBackground(Color.GREEN);
		lbllegend.setBounds(796, 258, 66, 15);
		panel_2.add(lbllegend);




		JPanel panel_right = new JPanel();
		panel_right.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_right.setBackground(Color.WHITE);
		panel_right.setBounds(10, 320, 252, 394);
		this.add(panel_right);
		panel_right.setLayout(null);

		JPanel panel_JiNengShu = new JPanel();
		panel_JiNengShu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_JiNengShu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_JiNengShu.setBackground(new Color(0, 139, 139));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_JiNengShu.setBackground(new Color(60, 179, 113));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});
		panel_JiNengShu.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_JiNengShu.setBackground(new Color(255, 204, 255));
		panel_JiNengShu.setBounds(26, 10, 105, 60);
		panel_right.add(panel_JiNengShu);
		panel_JiNengShu.setLayout(null);


		JLabel lblOrdermessage = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/orderMessage1.png")));
		lblOrdermessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_JiNengShu.setBackground(new Color(0, 139, 139));
				lblOrdermessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblOrdermessage.setBounds(24, 6, 55, 50);
		panel_JiNengShu.add(lblOrdermessage);

		JPanel panel_XueXi = new JPanel();
		panel_XueXi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_XueXi.setBackground(new Color(154, 223, 191));
				panel_XueXi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_XueXi.setBackground(new Color(173, 255, 47));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});
		panel_XueXi.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_XueXi.setBackground(new Color(173, 255, 47));
		panel_XueXi.setBounds(26, 116, 105, 60);
		panel_right.add(panel_XueXi);
		panel_XueXi.setLayout(null);

		JLabel lblNote = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/note.png")));
		lblNote.setBounds(25, 5, 55, 50);
		panel_XueXi.add(lblNote);

		JPanel panel_ReBang = new JPanel();
		panel_ReBang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_ReBang.setBackground(new Color(160, 192, 240));
				panel_ReBang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_ReBang.setBackground(new Color(0, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});
		panel_ReBang.setBackground(new Color(0, 255, 255));
		panel_ReBang.setBounds(26, 225, 105, 60);
		panel_right.add(panel_ReBang);
		panel_ReBang.setLayout(null);

		JLabel lblLogistics = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/logisticsManageMent.png")));
		lblLogistics.setBounds(24, 5, 55, 50);
		panel_ReBang.add(lblLogistics);

		JPanel panel_ZhuanJia = new JPanel();
		panel_ZhuanJia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_ZhuanJia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_ZhuanJia.setBackground(new Color(219, 112, 147));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_ZhuanJia.setBackground(new Color(187, 234, 213));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru = new RemainUI("未开放提示", "/top/picture/兔子1.png", "功能暂未开放，敬请期待", 170);
				ru.setVisible(true);
			}
		});

		panel_ZhuanJia.setBackground(new Color(187, 234, 213));
		panel_ZhuanJia.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_ZhuanJia.setBounds(26, 322, 105, 60);
		panel_right.add(panel_ZhuanJia);
		panel_ZhuanJia.setLayout(null);

		JLabel lblBackList = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/blacklist.png")));
		lblBackList.setBounds(27, 5, 55, 50);
		panel_ZhuanJia.add(lblBackList);

		ImageIcon imagegreenWire = new ImageIcon("picture\\greenwire.png");
		JLabel lblGreenwire = new JLabel(imagegreenWire);
		lblGreenwire.setBackground(Color.RED);
		lblGreenwire.setBounds(26, 127, 235, 4);
		panel_right.add(lblGreenwire);

		JLabel lblOrder = new JLabel("技术树");
		lblOrder.setForeground(SystemColor.windowBorder);
		lblOrder.setBackground(Color.WHITE);
		lblOrder.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblOrder.setBounds(168, 20, 60, 25);
		panel_right.add(lblOrder);

		ImageIcon imageyellowWire = new ImageIcon("picture\\yellowwire.png");
		JLabel lblYellowWire = new JLabel(imageyellowWire);
		lblYellowWire.setBackground(Color.RED);
		lblYellowWire.setBounds(26, 246, 235, 4);
		panel_right.add(lblYellowWire);

		JLabel lblInform = new JLabel("学习");
		lblInform.setForeground(SystemColor.windowBorder);
		lblInform.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblInform.setBackground(Color.WHITE);
		lblInform.setBounds(168, 126, 60, 25);
		panel_right.add(lblInform);



		JLabel lbltransportation = new JLabel("热榜");
		lbltransportation.setForeground(SystemColor.windowBorder);
		lbltransportation.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lbltransportation.setBackground(Color.WHITE);
		lbltransportation.setBounds(161, 236, 75, 25);
		panel_right.add(lbltransportation);

		JLabel lblBlackList = new JLabel("专家推荐");
		lblBlackList.setForeground(SystemColor.windowBorder);
		lblBlackList.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblBlackList.setBackground(Color.WHITE);
		lblBlackList.setBounds(161, 337, 75, 25);
		panel_right.add(lblBlackList);

		JLabel lblBlacklistMessageOf = new JLabel("BlackList Message of Users");
		lblBlacklistMessageOf.setForeground(SystemColor.windowBorder);
		lblBlacklistMessageOf.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblBlacklistMessageOf.setBounds(76, 406, 150, 15);
		panel_right.add(lblBlacklistMessageOf);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 91, 252, 5);
		panel_right.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 197, 252, 5);
		panel_right.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 307, 252, 5);
		panel_right.add(separator_2);

		panedate = new paneDate();	//这里定义pandDate类对象
		panedate.setBounds(728, 320, 390, 390);
		panedate.setBorder(new LineBorder(Color.blue));
		add(panedate);
		Timer timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panedate.repaint();
			}
		});
		timer.start();

		JPanel panelUser = new JPanel();
		panelUser.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelUser.setBackground(Color.WHITE);
		panelUser.setBounds(282, 320, 432, 253);
		this.add(panelUser);
		panelUser.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/河马.png")));
		lblNewLabel_1_1.setBounds(202, 86, 220, 157);
		panelUser.add(lblNewLabel_1_1);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("楷体", Font.PLAIN, 13));
		textArea.setText("静守时光以待流年\r\n回首熟悉的风景\r\n摘一枚秋日的青叶\r\n揽一串眷恋的花香\r\n站在风华之外，期待一片安宁。\r\n流年似水，似水流年。\r\n看浅浅清秋，染一抹淡淡的蓝色悲欢。");
		textArea.setBounds(10, 10, 214, 127);
		panelUser.add(textArea);


		JPanel panel_friend = new JPanel();
		panel_friend.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_friend.setBackground(Color.WHITE);
		panel_friend.setBounds(282, 583, 432, 131);
		this.add(panel_friend);
		panel_friend.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/圆头.png")));
		lblNewLabel_2.setBounds(10, 10, 100, 100);
		panel_friend.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 0));
		panel.setBounds(120, 62, 120, 5);
		panel_friend.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(237, 62, 70, 5);
		panel_friend.add(panel_1);

		JLabel lblNewLabel_3 = new JLabel("Jean");
		lblNewLabel_3.setForeground(new Color(112, 128, 144));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 17));
		lblNewLabel_3.setBounds(120, 30, 70, 25);
		panel_friend.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(bkManagerPanel.class.getResource("/top/picture/动漫.png")));
		lblNewLabel_4.setBounds(317, 0, 86, 122);
		panel_friend.add(lblNewLabel_4);

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
