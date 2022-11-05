package top.onlywishes.bk.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import top.onlywishes.bk.dao.AdminDao;
import top.onlywishes.bk.dao.ArticleDao;
import top.onlywishes.bk.model.Admin;
import top.onlywishes.bk.model.Article;
import top.onlywishes.bk.model.ArticleTableModel;

import javax.swing.JLayeredPane;


public class ArticleManageUI extends JPanel {

	/**
	 * Create the panel.
	 */

	public JTable Tables;
	public JTextField txtArticleName;
	private ArticleTableModel atl;
	private String articleTitle;// 文章标题输入框
	private String articleID;	//文章ID
	private String text_content;
	private JTextField text_ArticleID;
	int art_id = 0;


	/**
	 * Create the panel.
	 */
	public ArticleManageUI() {


		showComponent();
}

	public void showComponent() {

		setSize(1135, 724);
		setLayout(null);

		JPanel panelBig = new JPanel();
		panelBig.setBackground(new Color(255, 255, 255));
		panelBig.setBounds(0, 0, 1135, 724);
		this.add(panelBig);
		panelBig.setLayout(null);

		JPanel panelBig_Header = new JPanel();
		panelBig_Header.setBorder(null);
		panelBig_Header.setBackground(new Color(255, 250, 250));
		panelBig_Header.setBounds(21, 10, 1091, 240);
		panelBig.add(panelBig_Header);
		panelBig_Header.setLayout(null);

		JLabel lblArticleName = new JLabel("文章标题：");
		lblArticleName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblArticleName.setBounds(459, 96, 73, 20);
		panelBig_Header.add(lblArticleName);

		txtArticleName = new JTextField();
		txtArticleName.setBounds(528, 95, 150, 25);
		panelBig_Header.add(txtArticleName);
		txtArticleName.setColumns(10);

		JButton btnLend = new JButton("帮助");
		btnLend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLend.setBackground(new Color(153, 50, 204));
				btnLend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLend.setBackground(new Color(255, 0, 255));
			}
		});
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpDocUI hd=new HelpDocUI();
				hd.setVisible(true);
			}
		});
		btnLend.setForeground(new Color(255, 255, 255));
		btnLend.setBackground(new Color(255, 0, 255));
		btnLend.setBounds(771, 176, 100, 40);
		panelBig_Header.add(btnLend);


//删除操作
		JButton btnDelete = new JButton("删除");
		//增加监听操作
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleDao bs = null;
				int results = 0;// 删除结果返回值
				// 首先获得输入框中的信息
				articleTitle = txtArticleName.getText();//

				// 如果输入框是空，并且没有选中表格中的任何一行，则结束方法
				if ("".equals(articleTitle)  && Tables.getSelectedRow() < 0) {
					RemainUI ru=new RemainUI();
					ru.setVisible(true);
					return;
				}
				// 如果书名不为空则进行判断用户输入的书籍是否存在于数据库中
				if (!"".equals(articleTitle)) {
					// 对用户输入的书籍进行判断
					bs = new ArticleDao();
					Article article = null;
					try {
						article = bs.getArticlesByArticleTital(articleTitle);
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (article == null) {
						JOptionPane.showMessageDialog(null, "您需要删除的书籍不存在！");
						return;
					} else {
						int option = JOptionPane.showConfirmDialog(null, "你确定删除《" + articleTitle + "》吗？", "删除提示",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							results = bs.deleteArticle(articleTitle);
						}

						if (results > 0) {
							txtArticleName.setText("");

							JOptionPane.showMessageDialog(null, "删除成功");
							Tables.setModel(new DefaultTableModel());// 设置空的表格模型
							try {
								atl = new ArticleTableModel(bs.getAll());
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}// 调用dao类中的查询所有数据的方法进行查询
							Tables.setModel(atl);// 将查询到的结果设置为表格模型
						}
					}
				}
			}
		});



		//设置按钮颜色
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground(new Color(255, 140, 0));
				btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground(new Color(255, 160, 122));
			}

		});
		//设置按钮颜色
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 160, 122));
		btnDelete.setBounds(651, 176, 100, 40);
		panelBig_Header.add(btnDelete);


//添加操作
		JButton btnAdd = new JButton("写文章");
		//监听
		btnAdd.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
//				AddArticleUI ubu = new AddArticleUI(ArticleManageUI.this);/////////////////////////
//				ubu.setVisible(true);
				String Name = "op";
				AddArticleGO oi = new AddArticleGO(Name);
				oi.setVisible(true);
			}
		});

		//按钮颜色
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0, 191, 255));
				btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setBackground(new Color(0, 255, 255));
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(0, 255, 255));
		btnAdd.setBounds(531, 176, 100, 40);
		panelBig_Header.add(btnAdd);



//修改操作
		JButton btnAlter = new JButton("修改");
		//监听
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 首先获得输入框中的信息
				articleTitle = txtArticleName.getText();
				articleID = text_ArticleID.getText();
				System.out.println(articleID);
				if (Objects.equals(articleID, "")) {
					RemainUI ui = new  RemainUI("提示","输入文章ID为空！");
					ui.setVisible(true);
					return;
				}
				art_id = Integer.parseInt(articleID);  // 根据这个修改文章

				// 如果输入框是空，并且没有选中表格中的任何一行，则结束方法
				if("".equals(articleID)  && Tables.getSelectedRow() < 0) {
//					RemainUI ru=new RemainUI();
//					ru.setVisible(true);
					RemainUI ui = new  RemainUI("提示","请输入文章ID进行修改！");
					ui.setVisible(true);
					System.out.println("当前输入ID为空，不执行操作");
					return;
				}

				loginUI lo = new loginUI();
				ArticleDao bs = new ArticleDao();
				String a = lo.Username;
//				int author_id = 0;///文章里的用户ID
//				int ad_id =0;//用户ID
//				Admin admin ;
//				AdminDao ad = new AdminDao();
				System.out.println(a);
				if(Objects.equals(a, "apple")) {
					// 如果输入框有值,通过标题进行回显,如果书名输入框没有值，提示
//					RemainUI ui = new  RemainUI("管理员","您可以修改别人的文章");\\\\\\\\找错误
//					ui.setVisible(true);

					if (!"".equals(articleID)) {
						UpdateArticleByIDUI ubu = new UpdateArticleByIDUI(ArticleManageUI.this, art_id);/////////////
						ubu.setVisible(true);////////////////////////////////////////////////////////////
					}else {
						RemainUI op = new RemainUI("提示","出现错误！");
						op.setVisible(true);
					}
				}else {
					try {
						int author_id = 0;///文章里的用户ID
						int ad_id =0;//用户ID
						Admin admin =null;
						AdminDao ad = new AdminDao();

						Article article = bs.getArticlesByArticleID(art_id);
						author_id = article.getArticle_author_id();
						admin = ad.getAdminByNM(lo.Username);
						ad_id = admin.getA_id();
						if (article!=null && author_id==ad_id) {
							// 如果输入框有值,通过标题进行回显,如果书名输入框没有值，提示
							if (!"".equals(articleID)) {
								UpdateArticleByIDUI ubu = new UpdateArticleByIDUI(ArticleManageUI.this, art_id);/////////////
								ubu.setVisible(true);////////////////////////////////////////////////////////////
							}
						}else {
							RemainUI ui = new  RemainUI("提示","您不能修改别人的文章哦");
							ui.setVisible(true);
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (NullPointerException e1) {
						RemainUI ui = new  RemainUI("提示","您输入的文章ID不存在！");
						ui.setVisible(true);
					}
				}
/*
				// 如果输入框有值,通过标题进行回显,如果书名输入框没有值，提示
				if (!"".equals(articleID)) {
					UpdateArticleUI ubu = new UpdateArticleUI(ArticleManageUI.this, articleTitle);/////////////
					ubu.setVisible(true);////////////////////////////////////////////////////////////
				}
*/
			}
		});
		//按钮颜色
		btnAlter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlter.setBackground(new Color(46, 139, 87));
				btnAlter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAlter.setBackground(new Color(0, 255, 127));
			}
		});
		btnAlter.setForeground(Color.WHITE);
		btnAlter.setBackground(new Color(0, 255, 127));
		btnAlter.setBounds(411, 176, 100, 40);
		panelBig_Header.add(btnAlter);

//查询操作
		JButton btnSearch = new JButton("查询");
		//监听
	    btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				articleTitle = txtArticleName.getText();// 获得用户输入的文章名字
				// 如果输入框都没有信息的时候,将数据库中所有的全部查询出来
//				!"".equals(article_id) &&  String.valueOf(article_id) != null
//				|| String.valueOf(article_id) == null
				if ("".equals(articleTitle) ||  articleTitle== null) {
					Tables.setModel(new DefaultTableModel());// 设置空的表格模型
					ArticleDao bs = new ArticleDao();
					try {
						atl = new ArticleTableModel(bs.getAll());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}// 调用dao类中的查询所有数据的方法进行查询
					Tables.setModel(atl);// 将查询到的结果设置为表格模型


					// 当用户输入书名进行查询的时侯
				} else if (!"".equals(articleTitle) &&  (articleTitle!= null)) {

					Tables.setModel(new DefaultTableModel());// 设置空表格模型
					ArticleDao bs = new ArticleDao();

//					Article article = null;

					ArrayList<Article> article = new ArrayList<>();
					try {
						article = bs.getArticlesByArticleTital_MOHU("%"+articleTitle+"%");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}// 通过名字进行查询，将查询结果封装成Article对象
					System.out.println(article);
					if (article.isEmpty()) {// 如果article是空，说明数据库中没有用户输入的书名,给出提示,并将信息栏设置为空
//						JOptionPane.showMessageDialog(null, "您输入的标题名不存在,请重新输入");
						RemainUI ui = new  RemainUI("提示","您查询的文章不存在,请重新输入！");
						ui.setVisible(true);
						txtArticleName.setText("");
						Tables.setModel(new DefaultTableModel());// 设置空的表格模型
						bs = new ArticleDao();
						try {
							atl = new ArticleTableModel(bs.getAll());
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}// 调用dao类中的查询所有数据的方法进行查询
						Tables.setModel(atl);// 将查询到的结果设置为表格模型

						return;

					} else {// 有查询结果的时候，将输入栏清空，并将数据打包成表格模型,显示在表格中
						txtArticleName.setText("");
						// 构造表格模型
						ArrayList<Article> articles = new ArrayList<>();
						articles.addAll(article);
						atl = new ArticleTableModel(articles);
						Tables.setModel(atl);

	//下面这俩为展示，这里不再展示
//						LookArticle ui = new LookArticle(ArticleManageUI.this,articleTitle);
//						ui.setVisible(true);
					}
				}
			}
		});

		// 按钮的移入移除效果
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(255, 182, 193));
				btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			// 移出效果
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(new Color(147, 112, 219));
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(147, 112, 219));
		btnSearch.setBounds(291, 176, 100, 40);
		panelBig_Header.add(btnSearch);

		JLabel lblid = new JLabel("文章ID：");
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblid.setBounds(459, 41, 73, 20);
		panelBig_Header.add(lblid);

		text_ArticleID = new JTextField();
		text_ArticleID.setColumns(10);
		text_ArticleID.setBounds(528, 40, 150, 25);
		panelBig_Header.add(text_ArticleID);

		JLabel lblNewLabel = new JLabel("注：修改操作输入ID即可");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel.setBounds(528, 10, 150, 20);
		panelBig_Header.add(lblNewLabel);


		UIManager.put("ScrollBar.thumb", Color.black);


//插入表格面板
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(21, 251, 1091, 463);
		panelBig.add(scrollPane);

//
		// 表格
		Tables = new JTable();
		// 给表格模型添加鼠标点击事件
		Tables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取鼠标点击的次数
				if (e.getClickCount() == 2) {// 如果鼠标双击两次执行方法
					MouseClick();
				}
				if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 1) {	//左1  右3
					btnDelete();
				}

			}
		});
		Tables.setFillsViewportHeight(true);
		Tables.setToolTipText("");
		Tables.setForeground(new Color(0, 0, 0));
		Tables.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		Tables.setBackground(new Color(248, 248, 255));
		Tables.setBorder(null);
		Tables.setShowGrid(false);// 是否展示网格
		Tables.setSelectionBackground(new Color(0, 191, 255));// 设置所选单元格的背景色
		Tables.setSelectionForeground(Color.white);// 设置所选单元格的前景色
//		Tables.setRowMargin(2);设置单元格之间的空白间距
//		Tables.setRowHeight(20, 20);//设置指定单元格的高度
		Tables.setRowHeight(40);// 设置所有单元格的高度


		scrollPane.setViewportView(Tables);
		Tables.setModel(new DefaultTableModel());
		ArticleDao bs = new ArticleDao();
		ArticleTableModel atl = null;
		try {
			atl = new ArticleTableModel(bs.getAll());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Tables.setModel(atl);
		// 获得表格头
		JTableHeader header = Tables.getTableHeader();
		header.setBackground(new Color(255, 255, 255));// 设置表格头的背景色
		header.setReorderingAllowed(false);// 设置用户不可拖动表格头
		header.setResizingAllowed(false);// 用户不可拖动表格头

		// 设置内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);// 居中显示
		Tables.setDefaultRenderer(Object.class, tcr);// 设置渲染器
		scrollPane.setViewportView(Tables);
		Tables.setBorder(new LineBorder(new Color(255, 250, 250)));
	}

		// 鼠标双击的方法
		public void MouseClick() {
			// 获得鼠标双击的表格行
			// getSelectedRow()返回第一个选定行的索引，如果没有选择行，则返回-1。
			int rowIndex = Tables.getSelectedRow();
			System.out.println(rowIndex);
			if (rowIndex < 0) {// 没有选中表格行
				return;// 结束方法
			}

			// 获得表格模型
			ArticleTableModel atm = (ArticleTableModel) Tables.getModel();
			// 获得选中行书籍的书名,(行号,列号)
			String articleTitle = atm.getValueAt(rowIndex, 3).toString();
			System.out.println(articleTitle);
			// 打开页面修改信息
			LookArticle ubu = new LookArticle(ArticleManageUI.this, articleTitle);
			ubu.setVisible(true);
		}

		// 鼠标右键删除操作
		public void btnDelete() {
			int results=0;//受删除的语句行
			// 获得鼠标双击的表格行
			// getSelectedRow()返回第一个选定行的索引，如果没有选择行，则返回-1。
			int rowIndex = Tables.getSelectedRow();
			System.out.println(rowIndex);
			if (rowIndex < 0) {// 没有选中表格行
				return;// 结束方法
			}
			// 获得表格模型
			ArticleTableModel atm = (ArticleTableModel) Tables.getModel();
			// 获得选中行标题
			String articleTitle = atm.getValueAt(rowIndex, 3).toString();
			// 通过标题名称进行删除操作
			ArticleDao bs=new ArticleDao();
			int option = JOptionPane.showConfirmDialog(null, "你确定删除《" + articleTitle + "》吗？", "删除提示",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				results=bs.deleteArticle(articleTitle);
			}
			if(results>0) {//删除成功
				JOptionPane.showMessageDialog(null, "删除成功");
				//将删除之后的书籍显示在表格控件中
				Tables.setModel(new DefaultTableModel());// 设置空的表格模型
				try {
					atl = new ArticleTableModel(bs.getAll());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 调用service类中的查询所有数据的方法进行查询
				Tables.setModel(atl);// 将查询到的结果设置为表格模型
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
