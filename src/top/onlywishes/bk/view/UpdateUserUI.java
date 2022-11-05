package top.onlywishes.bk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import top.onlywishes.bk.dao.*;

import top.onlywishes.bk.model.*;


public class  UpdateUserUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text_Uname;// 
	private JTextField text_UNIchen;//

	private Admin admin = null;
	UsersManageUI usersManageUI = null;
	private JTextField text_PWD;
	private JComboBox select_SEX;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateUserUI dialog = new UpdateUserUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateUserUI() {
		showComponent();

	}

	public UpdateUserUI(UsersManageUI usersManageUI, String user_name) {
		showComponent();
		this.usersManageUI = usersManageUI;
		init(user_name);
	}

	public void showComponent() {
		setTitle("修改");
		this.setResizable(false);
		// 获取图片 三种图片格式都可以

		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateUserUI.class.getResource("/top/picture/fox.png")));

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 786);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(10, 20, 651, 719);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lbNiChen = new JLabel("昵称：");
		lbNiChen.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbNiChen.setBounds(235, 139, 36, 25);
		contentPanel.add(lbNiChen);

		text_Uname = new JTextField();
		text_Uname.setEditable(false);
		text_Uname.setBounds(303, 60, 150, 20);
		contentPanel.add(text_Uname);
		text_Uname.setColumns(10);
		
		JLabel lbUserName = new JLabel("用户名：");
		lbUserName.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbUserName.setBounds(230, 58, 60, 25);
		contentPanel.add(lbUserName);
		
		text_UNIchen = new JTextField();
		text_UNIchen.setColumns(10);
		text_UNIchen.setBounds(303, 141, 150, 20);
		contentPanel.add(text_UNIchen);


		JButton btnCancel = new JButton("取消");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.setBounds(257, 507, 75, 35);
		contentPanel.add(btnCancel);

		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getAlterComponent();// 调用修改操作的方法

			}
		});
		btnNewButton_1_1.setBounds(378, 507, 75, 35);
		contentPanel.add(btnNewButton_1_1);
		
		text_PWD = new JTextField();
		text_PWD.setColumns(10);
		text_PWD.setBounds(303, 312, 150, 20);
		contentPanel.add(text_PWD);
		
		JLabel lbUSEX = new JLabel("性别：");
		lbUSEX.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbUSEX.setBounds(235, 217, 36, 25);
		contentPanel.add(lbUSEX);
		
		JLabel lbUPWD = new JLabel("密码：");
		lbUPWD.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbUPWD.setBounds(235, 310, 36, 25);
		contentPanel.add(lbUPWD);
		
		select_SEX = new JComboBox();
		select_SEX.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		select_SEX.setBounds(303, 218, 150, 20);
		contentPanel.add(select_SEX);
	}



	// 回显的方法,就是通过用户输入的信息中的用户名在修改面板进行显示
	public void init(String user_name) {
		AdminDao bs = new AdminDao();
		try {
			admin = bs.getAdminByNM(user_name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (admin != null) {
			// 将通过名字获取到的数据添加入图形界面中
			text_Uname.setText(admin.getA_name());
			select_SEX.setSelectedItem(admin.getA_sex());
			text_UNIchen.setText(admin.getA_nichen());
			text_PWD.setText(admin.getA_pwd());
		} else {
			JOptionPane.showMessageDialog(null, "您需要修改的用户不存在", "修改", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}



	// 获取用户输入到插入信息再到显示在面板上
	public void getAlterComponent() {
		// 首先获取用户在界面上输入的值
		String u_name = text_Uname.getText();// 
		String u_nichen = text_UNIchen.getText();
		String u_sex =(String) select_SEX.getSelectedItem(); 
		String u_pwd = text_PWD.getText();
	
		// 将从界面获取到的值进行封装成用户对象
		Admin admin = new Admin(u_name,u_nichen, u_sex, u_pwd);
		AdminDao bs = new AdminDao();// 创建dao对象
		int result = bs.UpdateUser(admin);// 执行修改操作
		if (result > 0) {// 表示成功
			JOptionPane.showMessageDialog(null, "修改成功", "添加", JOptionPane.INFORMATION_MESSAGE);
			// 释放窗口资源
			this.dispose();
			// 在页面上进行显示
//			构造新的表格模型
			// 将用户修改之后的信息显示到表格控件中
			ArrayList<Admin> admins = new ArrayList<>();
			admins.add(admin);
			UserTableModel etm = new UserTableModel(admins);// 创造article模型
			usersManageUI.Tables.setModel(etm);
			usersManageUI.txtUSerName.setText("");
		}
	}
	
	
	// 用于判断输入的是否是数字
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
