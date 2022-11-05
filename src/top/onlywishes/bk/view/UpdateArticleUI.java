package top.onlywishes.bk.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import top.onlywishes.bk.dao.*;

import top.onlywishes.bk.model.*;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class UpdateArticleUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAuthorID;// 
	ArticleManageUI ArticleUI = null;
	private Article article = null;
	private JTextField text_title;
	private JComboBox txt_category;
	private String text_categy;
	private JTextArea text_content;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextArea textArea ;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateArticleUI dialog = new UpdateArticleUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public UpdateArticleUI() {
		showComponent();

	}


	public UpdateArticleUI(ArticleManageUI ArticleUI, String article_Title) {
		this.ArticleUI = ArticleUI;
		showComponent();
		init(article_Title);
	}

	public void showComponent() {

		setLOGO();

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
		lbArticleID.setBounds(233, 132, 60, 25);
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
		txtAuthorID.setBounds(303, 137, 150, 20);
		contentPanel.add(txtAuthorID);
		txtAuthorID.setColumns(10);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleUI.txtArticleName.setText("");
				
				setVisible(false);
			}
		});
		btnCancel.setBackground(new Color(240, 230, 140));
		btnCancel.setBounds(250, 492, 75, 35);
		contentPanel.add(btnCancel);

		JButton btnAlter = new JButton("\u4FEE\u6539");
		btnAlter.setBackground(Color.GREEN);
		// 进行修改操作
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAlterComponent();// 调用修改操作的方法
			}
		});
		btnAlter.setBounds(371, 492, 75, 35);
		contentPanel.add(btnAlter);
		
		JLabel lbArticle_title = new JLabel("文章标题：");
		lbArticle_title.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_title.setBounds(233, 55, 60, 25);
		contentPanel.add(lbArticle_title);
		
		text_title = new JTextField();
		text_title.setColumns(10);
		text_title.setBounds(303, 57, 150, 20);
		contentPanel.add(text_title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 221, 493, 237);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"言情", "科技", "玄幻", "推理", "悬疑", "武侠", "通文"}));
		comboBox.setBounds(303, 98, 150, 23);
		contentPanel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"公开", "管理员可见", "粉丝可见", "私密"}));
		comboBox_1.setBounds(303, 175, 150, 23);
		contentPanel.add(comboBox_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(303, 26, 150, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("文章ID：");
		lblNewLabel.setBounds(235, 29, 58, 15);
		contentPanel.add(lblNewLabel);

	}



	// 回显的方法,就是通过用户输入的信息中的书名在修改面板进行显示
	public void init(String article_Title) {
		ArticleDao bs = new ArticleDao();
		try {
			article = bs.getArticlesByArticleTital(article_Title);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (article != null) {
			// 将通过名字获取到的数据添加入图形界面中
			txtAuthorID.setText(String.valueOf(article.getArticle_author_id()));

			text_title.setText(article.getArticle_title());


			comboBox.setSelectedItem(article.getArticle_type());
			comboBox_1.setSelectedItem(article.getArticle_limit());
			textArea.setText(article.getArticle_content());
			textField.setText(String.valueOf(article.getArticle_id()));
			
		} else {
			JOptionPane.showMessageDialog(null, "您需要修改的文章不存在", "修改", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

	}

	public void getAlterComponent() {
		// 首先获取用户在界面上输入的值
		int articleAuthorID = Integer.valueOf(txtAuthorID.getText());// 
		String articleCategory =(String) comboBox.getSelectedItem();// 
		String articleTitle = (String) text_title.getText();
		String articleLimit =(String) comboBox_1.getSelectedItem(); 
		String articleContent = textArea.getText();
	
		// 将从界面获取到的值进行封装成Books对象
		Article article = new Article(articleAuthorID, articleCategory, articleTitle, articleContent, articleLimit);
		ArticleDao bs = new ArticleDao();// 创建dao对象
		int result = bs.UpdateArticle(article);// 执行修改操作
		if (result > 0) {// 表示插入成功
			JOptionPane.showMessageDialog(null, "修改成功", "修改", JOptionPane.INFORMATION_MESSAGE);
			// 释放窗口资源
			this.dispose();
			// 在页面上进行显示
//			构造新的表格模型
			// 将用户修改之后的信息显示到表格控件中
			ArrayList<Article> articles = new ArrayList<>();
			articles.add(article);
			ArticleTableModel etm = new ArticleTableModel(articles);// 创造article模型
			ArticleUI.Tables.setModel(etm);
			ArticleUI.txtArticleName.setText("");

		}else {
			JOptionPane.showMessageDialog(null, "修改失败", "修改", JOptionPane.INFORMATION_MESSAGE);
			return;
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

	// 设置logo
	public void setLOGO() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
//		java.awt.Image img = tk.getImage(UpdateArticleUI.class.getResource("top/picture/fox.png"));
		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDocUI.class.getResource("/top/picture/fox.png")));

	}
}
