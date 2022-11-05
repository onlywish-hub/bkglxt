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


public class  AddArticleGO extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAuthorID;// 作者ID
	private JTextField text_title;// 标题
	private JTextArea text_content;// 文章内容
	private JComboBox txtLimit;// 文章状态
	private JComboBox txt_category;// 文章类别
	private JLabel isbnhint;
	MainUI mainUI = null;
	private JComboBox comboBox ;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddArticleGO dialog = new AddArticleGO();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddArticleGO() {
		showComponent();
	}

	public AddArticleGO(String Users) {
		showComponent();
		init();
	}

	public void showComponent() {
		setTitle("写文章");
		this.setResizable(false);
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以

		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(AddArticleGO.class.getResource("/top/picture/fox.png")));

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 786);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(10, 20, 651, 719);
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lbArticleID = new JLabel("作者ID：");
		lbArticleID.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticleID.setBounds(233, 58, 60, 25);
		contentPanel.add(lbArticleID);

		JLabel lbArticle_cont = new JLabel("文章内容：");
		lbArticle_cont.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_cont.setBounds(44, 334, 60, 25);
		contentPanel.add(lbArticle_cont);

		JLabel lbArticle_category = new JLabel("文章类别：");
		lbArticle_category.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_category.setBounds(233, 97, 60, 25);
		contentPanel.add(lbArticle_category);

		JLabel lbArticle_limit = new JLabel("文章权限");
		lbArticle_limit.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_limit.setBounds(233, 174, 60, 25);
		contentPanel.add(lbArticle_limit);

		txtAuthorID = new JTextField();
		txtAuthorID.setEditable(false);
		txtAuthorID.setBounds(303, 60, 150, 20);
		contentPanel.add(txtAuthorID);
		txtAuthorID.setColumns(10);

		txtLimit = new JComboBox();
		txtLimit.setModel(new DefaultComboBoxModel(new String[] {"公开", "仅粉丝可见", "仅管理员可见", "私密"}));
		txtLimit.setBackground(new Color(245, 245, 220));
		txtLimit.setBounds(303, 176, 150, 20);
		contentPanel.add(txtLimit);
		
		JLabel lbArticle_title = new JLabel("文章标题：");
		lbArticle_title.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_title.setBounds(233, 139, 60, 25);
		contentPanel.add(lbArticle_title);
		
		text_title = new JTextField();
		text_title.setColumns(10);
		text_title.setBounds(303, 141, 150, 20);
		contentPanel.add(text_title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 221, 493, 237);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);


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

				btnUpdateAction();

			}
		});
		btnNewButton_1_1.setBounds(378, 507, 75, 35);
		contentPanel.add(btnNewButton_1_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"言情", "科技", "玄幻", "推理", "悬疑", "武侠", "通文"}));
		comboBox.setBounds(303, 98, 150, 23);
		comboBox.setBackground(new Color(245, 245, 220));
		contentPanel.add(comboBox);
	}


	

	
	// 回显的方法,就是通过用户输入的信息中的用户名在修改面板进行显示
	public void init() {
		AdminDao bs = new AdminDao();
		loginUI op = new loginUI();
		String user_name = op.Username;
		Admin admin = null;
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
			
			txtAuthorID.setText(String.valueOf(admin.getA_id()));
		} else {
			JOptionPane.showMessageDialog(null, "您需要修改的用户不存在", "修改", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	

	// 获取用户输入到插入信息再到显示在面板上
	public void btnUpdateAction() {
		// 获得所有的用户输入信息
		int article_authorID=0;
		loginUI op = new loginUI();
		AdminDao ad = new AdminDao();
		
		String username_login = op.Username;
		String article_auID = null;
		try {
			article_auID =String.valueOf(ad.getAdminByNM(username_login).getA_id());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtAuthorID.setText(article_auID);
		article_authorID = Integer.valueOf(article_auID);
//		String article_auID = txtAuthorID.getText();
//		 = Integer.valueOf(article_auID);

		String articleTitle = text_title.getText();

		String articleLImit = (String) txtLimit.getSelectedItem();
		String articleKind = (String) comboBox.getSelectedItem();//////////////////////////////
		String articleContent = textArea.getText();//////////////////////////
		
		// 对用户输入的id进行判断，不是数字则结束
		
			
/*
		if (!"".equals(article_auID) && isNumeric(article_auID)) {				
			article_authorID = Integer.valueOf(article_auID);
			if (article_authorID < 0 ) {
				System.out.println("作者ID必须大于0");
				JOptionPane.showMessageDialog(null, "作者ID必须大于0", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else {
			txtAuthorID.setText("");
			JOptionPane.showMessageDialog(null, "作者ID必须是数字！", "提示", JOptionPane.ERROR_MESSAGE);
//			priceHite.setText("id必须是0-1000之间的数");
			System.out.println("作者ID必须是数字");
			return;
		}	
*/
		// 如果有为填写的信息则进行提示,并结束按键
		if ("".equals(article_auID) || "".equals(articleKind) || "".equals(articleTitle) || "".equals(articleKind)
				|| "".equals(articleContent) ) {
			JOptionPane.showMessageDialog(null, "您有未输入的选项", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 程序若能执行至此，说明满足一切可插入条件,进行插入操作
		// 将用户输入的数据进行封装成Books对象
		Article article = new Article(article_authorID,articleKind,articleTitle,articleContent,articleLImit);//
		// 创建ArticleDao对象调用插入数据方法
		ArticleDao bs = new ArticleDao();
		int result = bs.AddArticle(article);
		Icon icon=new ImageIcon("top\\picture\\hint2.png");
		if (result > 0) {
//			txtAuthorID.setText("");
			comboBox.setSelectedItem("");
			text_title.setText("");
			txtLimit.setSelectedItem("");
			textArea.setText("");

			JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.ERROR_MESSAGE,icon);
		}else {
			JOptionPane.showMessageDialog(null, "添加失败，请联系工作人员", "提示", JOptionPane.ERROR_MESSAGE,icon);
		}
	}
	
	
//	// 用于判断输入的是否是数字
//	public static boolean isNumeric(String str) {
//		for (int i = str.length(); --i >= 0;) {
//			if (!Character.isDigit(str.charAt(i))) {
//				return false;
//			}
//		}
//		return true;
//	}
}
