package top.onlywishes.bk.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javazoom.jl.player.Player;

import top.onlywishes.bk.util.musicStuff;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.Icon;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_3;
	private JMenuBar menuBar;
	private JTextField textField_1;
	private JButton btnNewButton_2;
	private JMenuBar menuBar_3;
	private JMenu mnNewMenuNH;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;








	private JTextField txtSearch;
	private JTable Tables;
	private JPanel panelBigerMain;
	private JLabel txtheader;
	private JLabel lblLibraryMessage;
	private JLabel lblMainMenu;
	private JLabel lblUserManae;
	private JPanel panelIcon;
	private JPanel panelheadIcon;
	private MessageBar mb = new MessageBar();
	private boolean isShow = false;// 定义是否显示，默认不显示
	private MessageBar3 mb3=new MessageBar3();
	private JPanel panelSetupManagepanel;
	private JLabel lblSetup;
	private JLabel lblManager_1_1_2;
	private JLabel lblNewLabel;
	private JTextField textPerson;
	private JLabel lblNewLabel_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_6;
	public static JPanel panelUsermanage;
	private JLabel lbbioaqian;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}





	/**
	 * Create the frame.
	 */
	public MainUI() {




		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainUI.class.getResource("/top/picture/header.png")));
		setTitle("博客管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 802);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		btnNewButton_3 = new JButton("写文章");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Name = "op";
				AddArticleGO oi = new AddArticleGO(Name);
				oi.setVisible(true);

			}
		});




		btnNewButton_3.setBackground(new Color(127, 255, 212));
		btnNewButton_3.setBounds(397, 7, 84, 30);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_3.setFocusable(false);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		textField_1.setBounds(571, 7, 222, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton_2 = new JButton("搜索");
		btnNewButton_2.setBackground(new Color(255, 182, 193));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_2.setIcon(new ImageIcon(MainUI.class.getResource("/top/picture/search.png")));
		btnNewButton_2.setBounds(792, 7, 97, 30);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFocusable(false);





		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 249, 769);
		contentPane.add(panel);
		panel.setLayout(null);

		panelheadIcon = new JPanel();
		panelheadIcon.setBackground(new Color(255, 239, 213));
		panelheadIcon.setBounds(21, 10, 206, 190);
		panel.add(panelheadIcon);
		panelheadIcon.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 235, 205));
		lblNewLabel.setIcon(new ImageIcon(MainUI.class.getResource("/top/picture/11.jpg")));
		lblNewLabel.setBounds(20, 0, 186, 190);
		panelheadIcon.add(lblNewLabel);



		JPanel panelMenu = new JPanel();
		panelMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMenu.setBackground(new Color(43, 187, 173));
				panelMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMenu.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lbbioaqian.setText(lblMainMenu.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new bkManagerPanel();
				panelBigerMain.setBounds(250, 45, 1670, 996);
				contentPane.add(panelBigerMain);
				repaint();
			}
		});
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 320, 249, 44);
		panel.add(panelMenu);
		panelMenu.setLayout(null);

		lblMainMenu = new JLabel("主页");
		lblMainMenu.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblMainMenu.setForeground(Color.BLACK);
		lblMainMenu.setBounds(47, 13, 45, 20);
		panelMenu.add(lblMainMenu);

		JLabel lblMenu1 = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/lblMenu.png")));
		lblMenu1.setBounds(15, 12, 22, 22);
		panelMenu.add(lblMenu1);


		JPanel panelMedium = new JPanel();
		panelMedium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMedium.setBackground(new Color(43, 187, 173));
				panelMedium.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMedium.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				panelBigerMain.setVisible(false);
				panelBigerMain = new MediumManageUI();//////////////////////////
				panelBigerMain.setBackground(new Color(51,166,184));
				panelBigerMain.setBounds(250, 45, 1135, 724);
				contentPane.add(panelBigerMain);
				lbbioaqian.setText("媒体");

				repaint();

			}
		});
		panelMedium.setLayout(null);
		panelMedium.setBackground(Color.WHITE);
		panelMedium.setBounds(0, 413, 249, 44);
		panel.add(panelMedium);

		lblLibraryMessage = new JLabel("媒体");
		lblLibraryMessage.setForeground(Color.BLACK);
		lblLibraryMessage.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblLibraryMessage.setBounds(47, 13, 74, 20);
		panelMedium.add(lblLibraryMessage);

		ImageIcon imageManager = new ImageIcon("picture\\LibraryManage.png");
		JLabel lblManager = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/LibraryManage.png")));
		lblManager.setBounds(15, 12, 22, 22);
		panelMedium.add(lblManager);

		ImageIcon imagelend = new ImageIcon("picture\\lendManager.png");






		panelUsermanage = new JPanel();
		panelUsermanage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelUsermanage.setBackground(new Color(43, 187, 173));
				panelUsermanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUsermanage.setBackground(Color.white);

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				panelBigerMain.setVisible(false);
				panelBigerMain = new UsersManageUI();/////////////////////////////////////////////////
				panelBigerMain.setBounds(250, 45, 1135, 724);
				contentPane.add(panelBigerMain);
				lbbioaqian.setText("用户");
				repaint();

			}
		});



		panelUsermanage.setLayout(null);
		panelUsermanage.setBackground(Color.WHITE);
		panelUsermanage.setBounds(0, 551, 249, 44);
		panel.add(panelUsermanage);

		lblUserManae = new JLabel("用户管理");
		lblUserManae.setForeground(Color.BLACK);
		lblUserManae.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblUserManae.setBounds(47, 13, 74, 20);
		panelUsermanage.add(lblUserManae);

		JLabel lblManager_1_1 = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/UserManage.png")));
		lblManager_1_1.setBounds(15, 12, 22, 22);
		panelUsermanage.add(lblManager_1_1);

		JPanel panelLookManage = new JPanel();
		panelLookManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelLookManage.setBackground(new Color(43, 187, 173));
				panelLookManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelLookManage.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBigerMain.setVisible(false);
				panelBigerMain = new LookManageUI();					/////////////////////////////////////////////////
				panelBigerMain.setBounds(250, 45, 1135, 724);
				contentPane.add(panelBigerMain);
				lbbioaqian.setText("外观");
				repaint();

			}
		});
		panelLookManage.setLayout(null);
		panelLookManage.setBackground(Color.WHITE);
		panelLookManage.setBounds(0, 459, 249, 44);
		panel.add(panelLookManage);

		JLabel lblLookmManage = new JLabel("外观");
		lblLookmManage.setForeground(Color.BLACK);
		lblLookmManage.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblLookmManage.setBounds(47, 13, 74, 20);
		panelLookManage.add(lblLookmManage);

		ImageIcon imagestatistics = new ImageIcon("picture\\游戏.png");
		JLabel lblManager_1_1_1 = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/游戏.png")));
		lblManager_1_1_1.setText("");
		lblManager_1_1_1.setBounds(15, 12, 22, 22);
		panelLookManage.add(lblManager_1_1_1);

		panelSetupManagepanel = new JPanel();
		panelSetupManagepanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSetupManagepanel.setBackground(new Color(43, 187, 173));
				panelSetupManagepanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelSetupManagepanel.setBackground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				panelBigerMain.setVisible(false);
				panelBigerMain = new SetupManageUI();       /////////////////////////////////////////////////
				panelBigerMain.setBounds(250, 45, 1135, 724);
				contentPane.add(panelBigerMain);
				lbbioaqian.setText("设置");
				repaint();

			}
		});



		panelSetupManagepanel.setLayout(null);
		panelSetupManagepanel.setBackground(Color.WHITE);
		panelSetupManagepanel.setBounds(0, 505, 249, 44);
		panel.add(panelSetupManagepanel);

		lblSetup = new JLabel("设置");

		lblSetup.setForeground(Color.BLACK);
		lblSetup.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblSetup.setBounds(47, 13, 74, 20);
		panelSetupManagepanel.add(lblSetup);

		lblManager_1_1_2 = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/设 置1.png")));
		lblManager_1_1_2.setText("");
		lblManager_1_1_2.setBounds(15, 12, 22, 22);
		panelSetupManagepanel.add(lblManager_1_1_2);

		JButton btnNewButton = new JButton("点击我~");
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setBounds(55, 277, 128, 33);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(MainUI.class.getResource("/top/picture/hint.png")));



		btnNewButton.addActionListener(new ActionListener() {
			int a = 1;
			int b = 2;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField_1.setText(a+":年轻人好自为之~");
				a = a+1;
				textPerson.setText(a*10+"万+访问  "+b*3+"原创");
				b = b+2;
			}

		});
		btnNewButton.setFocusable(false);

		textPerson = new JTextField();
		textPerson.setBackground(new Color(240, 255, 240));
		textPerson.setForeground(new Color(0, 0, 0));
		textPerson.setText("1万+访问  50原创");
		textPerson.setEditable(false);
		textPerson.setBounds(55, 237, 128, 21);
		panel.add(textPerson);
		textPerson.setColumns(10);

		lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(73, 210, 100, 18);
		panel.add(lblNewLabel_1);

//		loginUI x = new loginUI();

		lblNewLabel_1.setText(loginUI.Username);/////////////


		if(lblNewLabel_1.getText().equals("apple")) {
			panelUsermanage.setVisible(true);
            JOptionPane.showMessageDialog(null, "当前身份为管理员");
		}else {
			panelUsermanage.setVisible(false);
//            JOptionPane.showMessageDialog(null, "您不是是管理员");
		}



		separator_2 = new JSeparator();
		separator_2.setBounds(0, 365, 249, 2);
		panel.add(separator_2);

		separator_4 = new JSeparator();
		separator_4.setBounds(0, 549, 249, 2);
		panel.add(separator_4);

		separator_6 = new JSeparator();
		separator_6.setBounds(0, 458, 249, 2);
		panel.add(separator_6);

		separator_3 = new JSeparator();
		separator_3.setBounds(0, 504, 249, 2);
		panel.add(separator_3);

		JPanel panelArticleManage = new JPanel();
		panelArticleManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelArticleManage.setBackground(new Color(43, 187, 173));
				panelArticleManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelArticleManage.setBackground(Color.WHITE);
			}



			@Override
			public void mouseClicked(MouseEvent e) {

				panelBigerMain.setVisible(false);
				panelBigerMain = new ArticleManageUI();/////////////////////////////////////////////////
				panelBigerMain.setBounds(250, 45, 1135, 724);
				contentPane.add(panelBigerMain);

				lbbioaqian.setText("文章");
				repaint();

			}
		});
		panelArticleManage.setLayout(null);
		panelArticleManage.setBackground(Color.WHITE);
		panelArticleManage.setBounds(0, 367, 249, 44);
		panel.add(panelArticleManage);



		JLabel lblArticle = new JLabel("文章");
		lblArticle.setForeground(Color.BLACK);
		lblArticle.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblArticle.setBounds(47, 13, 74, 20);
		panelArticleManage.add(lblArticle);

		JLabel lblManager_1_1_2_1 = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/statistics.png")));
		lblManager_1_1_2_1.setText("");
		lblManager_1_1_2_1.setBounds(15, 12, 22, 22);
		panelArticleManage.add(lblManager_1_1_2_1);

		JSeparator separator_6_1 = new JSeparator();
		separator_6_1.setBounds(0, 412, 249, 2);
		panel.add(separator_6_1);

		JLabel lbBQ = new JLabel("言为心声，字为心画");
		lbBQ.setFont(new Font("方正剪纸简体", Font.PLAIN, 18));
		lbBQ.setBounds(38, 653, 201, 33);
		panel.add(lbBQ);
		lblNewLabel_1.setVisible(true);


		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(211, 211, 211));
		separator.setBounds(250, 45, 1670, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(211, 211, 211));
		separator_1.setBounds(250, 1, 1670, 2);
		contentPane.add(separator_1);






		JLabel lblInform = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/inform.png")));
		lblInform.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// 鼠标悬浮时变成手
				lblInform.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}

			// 鼠标点击事件
			@Override
			public void mouseClicked(MouseEvent e) {
				mb.setTitle("Message");
				mb.contentPanel.setVisible(false);
				mb.contentPanel = new MessageBar1();
				mb.getContentPane().add(mb.contentPanel);
				if (isShow == false) {
					mb.setVisible(false);
					isShow = !isShow;
				} else if (isShow) {
					mb.setVisible(true);
					mb.setBounds(1000, 100, 300, 300);
					isShow = !isShow;
				}

			}

			// 鼠标移除事件
			@Override
			public void mouseExited(MouseEvent e) {
//				mb.setVisible(false);
			}
		});
		lblInform.setBounds(1180, 8, 32, 20);
		contentPane.add(lblInform);

		ImageIcon imageMessage = new ImageIcon("/top/picture/message.png");
		JLabel lblMessage = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/message.png")));
		lblMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mb.setTitle("Inform");
				mb.contentPanel.setVisible(false);
				mb.contentPanel = new MessageBar2();
				mb.getContentPane().add(mb.contentPanel);
				if (isShow == false) {
					mb.setVisible(false);
					isShow = !isShow;
				} else if (isShow) {
					mb.setVisible(true);
					mb.setBounds(1000, 100, 300, 300);
					isShow = !isShow;
				}

			}

		});
		lblMessage.setBounds(1100, 3, 32, 32);
		contentPane.add(lblMessage);

		loginUI op = new loginUI();
		String a = op.Username;

		JLabel lblSoMany = new JLabel(new ImageIcon(MainUI.class.getResource("/top/picture/表情.png")));
		lblSoMany.setText("您好 "+a+"");
		lblSoMany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSoMany.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

//				if (isShow == false) {
//					mb3.setVisible(false);
//					isShow = !isShow;
//				} else if (isShow) {
					mb3.setVisible(true);
					mb3.setBounds(1100, 100, 300, 280);
					isShow = !isShow;
//				}

			}
		});
		lblSoMany.setBounds(1221, 8, 155, 25);
		contentPane.add(lblSoMany);






		panelBigerMain = new JPanel();
		panelBigerMain.setBackground(new Color(255, 255, 255));
		panelBigerMain.setBounds(250, 45, 1135, 724);
		contentPane.add(panelBigerMain);
		panelBigerMain.setLayout(null);

		panelBigerMain.setVisible(false);
		panelBigerMain = new bkManagerPanel();
		panelBigerMain.setBounds(250, 45, 1135, 724);
		getContentPane().add(panelBigerMain);

		lbbioaqian = new JLabel("主页");
		lbbioaqian.setIcon(new ImageIcon(MainUI.class.getResource("/top/picture/menu.png")));
		lbbioaqian.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lbbioaqian.setHorizontalAlignment(SwingConstants.CENTER);
		lbbioaqian.setBackground(new Color(255,160, 122));
		lbbioaqian.setBounds(255, 8, 116, 30);
		contentPane.add(lbbioaqian);

		JButton btnNewButton_1 = new JButton("播放音乐");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String filepath = "Music\\YYTZ.wav";
				musicStuff musicObject = new musicStuff();
				musicObject.playMusic(filepath);//音乐播放
			}

		});
		btnNewButton_1.setBackground(new Color(255, 160, 122));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_1.setBounds(944, 7, 106, 30);
		contentPane.add(btnNewButton_1);
	}
}
