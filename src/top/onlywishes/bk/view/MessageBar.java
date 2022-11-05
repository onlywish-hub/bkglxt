package top.onlywishes.bk.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class MessageBar extends JDialog {

	public JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageBar dialog = new MessageBar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public MessageBar() {
		getContentPane().setBackground(Color.WHITE);
		setComponent();
	}

	public void setComponent() {

		setTitle("Messages");
		setLogo();
		contentPanel = new MessageBar1();
		setBounds(1500, 80, 300, 300);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 294, 271);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 294, 2);
		contentPanel.add(separator);

	}

	public void setLogo() {
		this.setResizable(false);// 窗口大小不可变
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以

		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDocUI.class.getResource("/top/picture/fox.png")));
	}
}
