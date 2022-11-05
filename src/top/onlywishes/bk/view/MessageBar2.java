package top.onlywishes.bk.view;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MessageBar2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public MessageBar2() {
		setBackground(Color.WHITE);
		setSize(294,271);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 294, 2);
		add(separator);
		
		JLabel lblhint = new JLabel("这里空空如也!");
		lblhint.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblhint.setBounds(10, 33, 274, 36);
		add(lblhint);
		
		JLabel lblchinese = new JLabel("您暂未收到信息");
		lblchinese.setBounds(10, 97, 250, 80);
		add(lblchinese);
		
	}
//	public static void main(String[]arg) {
//		new MessageBar2().setVisible(true);
//	}
}