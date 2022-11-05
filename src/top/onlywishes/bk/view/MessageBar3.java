package top.onlywishes.bk.view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import top.onlywishes.bk.dao.AdminDao;
import top.onlywishes.bk.model.Admin;

import javax.swing.JSeparator;
import java.awt.Component;

public class MessageBar3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean isOpenServer=false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageBar3 dialog1 = new MessageBar3();
			dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog1.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MessageBar3() {
		getContentPane().setBackground(Color.WHITE);
		setLogo();
		setBounds(100, 100, 300, 280);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 294, 151);
		contentPanel.setBackground(Color.YELLOW);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panelSet = new JPanel();
		panelSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSet.setBackground(new Color(0,255,255));
				panelSet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSet.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RemainUI ru=new RemainUI("未开放提示","picture\\兔子1.png","功能暂未开放，敬请期待",170);
				ru.setVisible(true);
			}
		});
		panelSet.setBackground(Color.WHITE);
		panelSet.setBounds(0, 2, 294, 50);
		contentPanel.add(panelSet);
		panelSet.setLayout(null);
		

		JLabel lblSet = new JLabel(new ImageIcon(MessageBar3.class.getResource("/top/picture/point.png")));
		lblSet.setBounds(10, 10, 54, 30);
		panelSet.add(lblSet);
		
		loginUI lo = new loginUI();
		JLabel lblName = new JLabel(""+lo.Username+"");		//用户名
		lblName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblName.setBounds(92, 7, 148, 20);
		panelSet.add(lblName);
		
		
		AdminDao bs = new AdminDao();
		String a = null;
		try {
			a = bs.getAdminByNM(lo.Username).getA_nichen();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel lblSethint = new JLabel(""+a+"");			//昵称
		lblSethint.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSethint.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		lblSethint.setBounds(92, 31, 136, 18);
		panelSet.add(lblSethint);
		

		
		JPanel panelBIANJI = new JPanel();
		panelBIANJI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBIANJI.setBackground(new Color(0,255,255));
				panelBIANJI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelBIANJI.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI op = new MainUI();
					// 首先获得输入框中的信息
					String userName = null;
					try {
						userName = bs.getAdminByNM(lo.Username).getA_name();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// 如果输入框有值,通过标题进行回显,如用户名输入框没有值，提示
					if (true) {
						UpdateXINXIuser ubu = new UpdateXINXIuser(userName);/////////////
						ubu.setVisible(true);////////////////////////////////////////////////////////////
					} 	
			}
		});
		panelBIANJI.setBackground(Color.WHITE);
		panelBIANJI.setBounds(0, 53, 294, 50);
		contentPanel.add(panelBIANJI);
		panelBIANJI.setLayout(null);
		
	
		JLabel lblAccessory = new JLabel(new ImageIcon(MessageBar3.class.getResource("/top/picture/刷新.png")));
		lblAccessory.setBounds(10, 10, 54, 30);
		panelBIANJI.add(lblAccessory);
		
		JLabel lbBianJi = new JLabel("编辑个人资料");
		lbBianJi.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lbBianJi.setBounds(92, 10, 112, 26);
		panelBIANJI.add(lbBianJi);
		
		JPanel panelSerive = new JPanel();
		panelSerive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSerive.setBackground(new Color(0,255,255));
				panelSerive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSerive.setBackground(Color.WHITE);
			}
			
			//点击退出
			@Override
			public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					System.exit(EXIT_ON_CLOSE);
				}
						
		});
		panelSerive.setBackground(Color.WHITE);
		panelSerive.setBounds(0, 105, 294, 50);
		contentPanel.add(panelSerive);
		panelSerive.setLayout(null);
		
	
		JLabel lblSerive = new JLabel(new ImageIcon(MessageBar3.class.getResource("/top/picture/退出.png")));
		lblSerive.setBounds(10, 10, 54, 30);
		panelSerive.add(lblSerive);
		
		JLabel lblExit = new JLabel("退出系统");
		lblExit.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblExit.setBounds(95, 21, 70, 15);
		panelSerive.add(lblExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 157, 284, 2);
		getContentPane().add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 51, 284, 2);
		getContentPane().add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 104, 284, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 0, 284, 2);
		getContentPane().add(separator_3);
	}
	
	public void setLogo() {
		this.setResizable(false);// 窗口大小不可变
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以

		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDocUI.class.getResource("/top/picture/空白.png")));
	}
}

