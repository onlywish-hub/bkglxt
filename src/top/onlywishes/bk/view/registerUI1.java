package top.onlywishes.bk.view;


import top.onlywishes.bk.dao.AdminDao;
import top.onlywishes.bk.model.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class registerUI1 extends JPanel {
	private JLabel lblIcon;
	private JTextField txtWorkId;
	private JTextField txtPwd;
	private JRadioButton rdbWomen;
	private JRadioButton rdbMan;

	/**
	 * Create the panel.
	 */
	public registerUI1() {
		setBackground(new Color(255, 240, 245));
		setLayout(null);
		setSize(984,519);
		//添加大logo
		ImageIcon icon = new ImageIcon("src\\top\\picture\\logos.png");
		lblIcon = new JLabel(icon);
		lblIcon.setBounds(195, 216, 177, 177);
		this.add(lblIcon);
		//将“注册”加入
		ImageIcon icos = new ImageIcon("src\\top\\picture\\register.png");
		JLabel lblLoginIcon = new JLabel(icos);
		lblLoginIcon.setBounds(534, 189, 58, 32);
		this.add(lblLoginIcon);

		txtWorkId = new JTextField();
		txtWorkId.setBounds(467, 231, 196, 32);
		add(txtWorkId);
		txtWorkId.setColumns(10);

		//分隔线
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);//设置分割线竖直
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(380, 104, 1, 400);
		this.add(separator);

		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBounds(467, 282, 196, 32);
		add(txtPwd);

		 rdbMan = new JRadioButton("男");
		rdbMan.setSelected(true);
		rdbMan.setBackground(null);
		rdbMan.setBounds(489, 333, 50, 23);
		add(rdbMan);

		rdbWomen = new JRadioButton("女");
		rdbWomen.setBackground((Color) null);
		rdbWomen.setBounds(575, 333, 50, 23);
		add(rdbWomen);



		ButtonGroup a = new ButtonGroup();
		a.add(rdbMan);
		a.add(rdbWomen);

		JLabel lblName = new JLabel("用户名：");
		lblName.setBounds(396, 236, 61, 20);
		add(lblName);

		JLabel lblName_1 = new JLabel("密码：");
		lblName_1.setBounds(407, 287, 40, 20);
		add(lblName_1);

		JButton btnAdd = new JButton("注册");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnAdd.setBackground(new Color(255, 182, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(238, 130, 238));
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account=txtWorkId.getText();
				String pwd=txtPwd.getText();
				AdminDao as;

				if("".equals(account) || "".equals(pwd)) {
					RemainUI remainUI=new RemainUI("提示","您的用户名或密码未输入");

//					JOptionPane.showMessageDialog(null, "您的工作号或密码未输入");
//				}else if(!isNumeric(account)) {
//					JOptionPane.showMessageDialog(null, "您输入的用户名不正确");
				}else {
					as=new AdminDao();
					int result=as.AddAdmin(account,pwd);
					if (a.isSelected(rdbMan.getModel())){
					as.updataSex("男",account);
					}else if (a.isSelected(rdbWomen.getModel())){
						as.updataSex("女",account);
					}
					if(result>0) {
						//说明添加成功
						System.out.println("注册成功");
						JOptionPane.showMessageDialog(null, "注册成功");

						txtWorkId.setText("");
						txtPwd.setText("");
						Admin admin= null;
						try {
							admin = as.getLastAdmin_name();

						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (ClassNotFoundException ex) {
							ex.printStackTrace();
						}
						System.out.println(admin);
						JOptionPane.showMessageDialog(null, "您的登陆账号是"+admin.getA_name()+",请牢记您的账号，切勿遗忘");
					}
					System.out.println(result);

				}


			}
		});
		btnAdd.setBackground(new Color(238, 130, 238));
		btnAdd.setBounds(467, 373, 196, 38);
		add(btnAdd);

	}

	// 判断是否是数字
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
