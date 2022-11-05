package top.onlywishes.bk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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


public class  AddUserUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text_Uname;// 
	private JTextField text_UNIchen;//
	UsersManageUI usersManageUI = null;
	private JTextField text_PWD;
	private JComboBox select_SEX;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddUserUI dialog = new AddUserUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddUserUI() {
		showComponent();

	}

	public AddUserUI(UsersManageUI usersManageUI) {
		showComponent();
		this.usersManageUI = usersManageUI;
	}

	public void showComponent() {
		setTitle("增加");
		this.setResizable(false);

		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(AddUserUI.class.getResource("/top/picture/fox.png")));

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

		JButton btnNewButton_1_1 = new JButton("添加");
		btnNewButton_1_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnUpdateAction(usersManageUI);

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



	// 获取用户输入到插入信息再到显示在面板上
	public void btnUpdateAction(UsersManageUI usersManageUI) {


		// 获得所有的用户输入信息
	
		String Uname = text_Uname.getText();
		String UNiChen = text_UNIchen.getText();
		String Usex = (String) select_SEX.getSelectedItem();
		String Upwd = text_PWD.getText();
		

		// 如果有为填写的信息则进行提示,并结束按键
		if ("".equals(Uname) || "".equals(UNiChen) || "".equals(Upwd) || "".equals(Usex)) {
			JOptionPane.showMessageDialog(null, "您有未输入的选项", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		}	

		try {
			// 程序若能执行至此，说明满足一切可插入条件,进行插入操作
			// 将用户输入的数据进行封装成用户对象
			Admin	admin = new Admin(Uname,UNiChen ,Usex, Uname);//
			// 创建dao对象调用插入数据方法
			AdminDao	bs = new AdminDao();
			int result = bs.AddAdminUser(admin);
			Icon icon=new ImageIcon("top\\picture\\hint2.png");
			if (result > 0) {
				text_Uname.setText("");
				text_UNIchen.setText("");
				select_SEX.setSelectedItem("");
				text_PWD.setText("");
	
				JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE,icon);
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名已存在！", "提示", JOptionPane.ERROR_MESSAGE,icon);
			}
		
			ArrayList<Admin> admins = null;
			try {
				admins = bs.getAll();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserTableModel btm = new UserTableModel(admins);
			System.out.println(btm.toString());
			// 4.2 把模型绑定在表格控件
			usersManageUI.Tables.setModel(btm);		
		} catch (Exception e) {
//			 TODO: handle exception

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
