package top.onlywishes.bk.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class MessageBar1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public MessageBar1() {
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(294, 271);
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 294, 2);
		add(separator);
		
		
		
		JPanel panelMessage = new JPanel();
		panelMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMessage.setBackground(new Color(127, 255, 212));
				panelMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMessage.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","top\\picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelMessage.setBackground(new Color(255, 255, 255));
		panelMessage.setBounds(0, 21, 294, 50);
		this.add(panelMessage);
		panelMessage.setLayout(null);

		ImageIcon imageMessage = new ImageIcon(MessageBar1.class.getResource("/top/picture/公告.png"));
		JLabel lblMessageIcon = new JLabel(imageMessage);
		lblMessageIcon.setBounds(22, 10, 54, 30);
		panelMessage.add(lblMessageIcon);

		JLabel lblMessage01 = new JLabel("Inform");
		lblMessage01.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblMessage01.setBounds(101, 10, 54, 13);
		panelMessage.add(lblMessage01);

		JLabel lblMessageunder = new JLabel("消息通知");
		lblMessageunder.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblMessageunder.setBounds(101, 25, 148, 15);
		panelMessage.add(lblMessageunder);

		JPanel panelNotice = new JPanel();
		panelNotice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelNotice.setBackground(new Color(127, 255, 212));
				panelNotice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelNotice.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","top\\picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelNotice.setLayout(null);
		panelNotice.setBackground(new Color(255, 255, 255));
		panelNotice.setBounds(0, 71, 294, 50);
		this.add(panelNotice);

		ImageIcon imageInform = new ImageIcon(MessageBar1.class.getResource("/top/picture/通知.png"));
		JLabel lblMessageIcon_1 = new JLabel(imageInform);
		lblMessageIcon_1.setBounds(22, 10, 54, 30);
		panelNotice.add(lblMessageIcon_1);

		JLabel lblremind = new JLabel("Remind");
		lblremind.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblremind.setBounds(100, 10, 54, 13);
		panelNotice.add(lblremind);

		JLabel lblYouHaveA = new JLabel("提醒");
		lblYouHaveA.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblYouHaveA.setBounds(100, 25, 148, 15);
		panelNotice.add(lblYouHaveA);

		JPanel panelResfresh = new JPanel();
		panelResfresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelResfresh.setBackground(new Color(127, 255, 212));
				panelResfresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelResfresh.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","top\\picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelResfresh.setLayout(null);
		panelResfresh.setBackground(new Color(255, 255, 255));
		panelResfresh.setBounds(0, 121, 294, 50);
		this.add(panelResfresh);


		JLabel lblMessageIcon_2 = new JLabel(new ImageIcon(MessageBar1.class.getResource("/top/picture/刷新.png")));
		lblMessageIcon_2.setBounds(22, 10, 54, 30);
		panelResfresh.add(lblMessageIcon_2);

		JLabel lblRefresh = new JLabel("Refresh");
		lblRefresh.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblRefresh.setBounds(99, 10, 54, 13);
		panelResfresh.add(lblRefresh);

		JLabel lblClean = new JLabel("清理垃圾");
		lblClean.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblClean.setBounds(99, 25, 148, 15);
		panelResfresh.add(lblClean);

		JPanel panelUpdate = new JPanel();
		panelUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUpdate.setBackground(new Color(127, 255, 212));
				panelUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUpdate.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","top\\picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		panelUpdate.setLayout(null);
		panelUpdate.setBackground(new Color(255, 255, 255));
		panelUpdate.setBounds(0, 171, 294, 50);
		this.add(panelUpdate);

//		ImageIcon upDate = new ImageIcon("top\\picture/上传.png");
		JLabel lblMessageIcon_2_1 = new JLabel(new ImageIcon(MessageBar1.class.getResource("/top/picture/上传.png")));
		lblMessageIcon_2_1.setBounds(22, 10, 54, 30);
		panelUpdate.add(lblMessageIcon_2_1);

		JLabel lblUpdate = new JLabel("Upload");
		lblUpdate.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblUpdate.setBounds(97, 10, 54, 13);
		panelUpdate.add(lblUpdate);

		JLabel lblUpdates = new JLabel("上传数据到服务器");
		lblUpdates.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblUpdates.setBounds(99, 25, 148, 15);
		panelUpdate.add(lblUpdates);

		JPanel paneldownDate = new JPanel();
		paneldownDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneldownDate.setBackground(new Color(127, 255, 212));
				paneldownDate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				paneldownDate.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI remainUI=new RemainUI("未开放提示","top\\picture\\兔子1.png","功能暂未开放，敬请期待",170);
			}
		});
		paneldownDate.setLayout(null);
		paneldownDate.setBackground(new Color(255, 255, 255));
		paneldownDate.setBounds(0, 221, 294, 50);
		this.add(paneldownDate);

//		ImageIcon downDate = new ImageIcon("top\\picture/下载.png");
		JLabel lblMessageIcon_2_2 = new JLabel(new ImageIcon(MessageBar1.class.getResource("/top/picture/下载.png")));
		lblMessageIcon_2_2.setBounds(22, 10, 54, 30);
		paneldownDate.add(lblMessageIcon_2_2);

		JLabel lbldwonload = new JLabel("Download");
		lbldwonload.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lbldwonload.setBounds(98, 10, 67, 13);
		paneldownDate.add(lbldwonload);

		JLabel lblDownloadTheData = new JLabel("下载数据到本地");
		lblDownloadTheData.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblDownloadTheData.setBounds(99, 25, 185, 15);
		paneldownDate.add(lblDownloadTheData);

	}

}