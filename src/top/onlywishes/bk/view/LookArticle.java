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


public class LookArticle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	ArticleManageUI ArticleUI = null;
	private Article article = null;
	private JTextField text_title;
    private JTextArea 	textArea;

	private JTextArea text_content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LookArticle dialog = new LookArticle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public LookArticle() {
		showComponent();

	}


	public LookArticle(ArticleManageUI ArticleUI, String article_Title) {
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

		JLabel lbArticle_content = new JLabel("文章内容：");
		lbArticle_content.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_content.setBounds(44, 229, 60, 25);
		contentPanel.add(lbArticle_content);

		JButton btnCancel = new JButton("退出");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleUI.txtArticleName.setText("");
				
				setVisible(false);
			}
		});
		btnCancel.setBackground(new Color(240, 230, 140));
		btnCancel.setBounds(227, 492, 98, 35);
		contentPanel.add(btnCancel);

		JButton btnAlter = new JButton("点赞+评论");
		btnAlter.setBackground(Color.GREEN);
		// 进行修改操作
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				getAlterComponent();// 调用修改操作的方法
				RemainUI ui = new RemainUI("提示","写评论功能正在玩命开发中....");
				ui.setVisible(true);
			}
		});
		btnAlter.setBounds(371, 492, 95, 35);
		contentPanel.add(btnAlter);
		
		JLabel lbArticle_title = new JLabel("文章标题：");
		lbArticle_title.setFont(new Font("新宋体", Font.PLAIN, 12));
		lbArticle_title.setBounds(227, 10, 60, 25);
		contentPanel.add(lbArticle_title);
		
		text_title = new JTextField();
		text_title.setEditable(false);
		text_title.setColumns(10);
		text_title.setBounds(297, 12, 209, 20);
		contentPanel.add(text_title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 59, 493, 399);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);

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
			
			text_title.setText(article.getArticle_title());

			textArea.setText(article.getArticle_content());
			
		} else {
			JOptionPane.showMessageDialog(null, "您查看的文章不存在", "查看", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

	}

	
	/*
	public void getAlterComponent() {
		// 首先获取用户在界面上输入的值
		String articleTitle = (String) text_title.getText();
	
		String articleContent = text_content.getText();
	
		// 将从界面获取到的值进行封装成Books对象
		Article article = new Article(articleTitle, articleContent);
		ArticleDao bs = new ArticleDao();// 创建dao对象
		int result = bs.UpdateArticle(article);// 执行修改操作
		if (result > 0) {// 表示插入成功
			JOptionPane.showMessageDialog(null, "修改成功", "添加", JOptionPane.INFORMATION_MESSAGE);
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
		}
	}
*/
	
	
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

		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(LookArticle.class.getResource("/top/picture/fox.png")));

	}
}
