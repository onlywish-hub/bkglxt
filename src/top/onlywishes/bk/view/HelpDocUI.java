package  top.onlywishes.bk.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class HelpDocUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HelpDocUI dialog = new HelpDocUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HelpDocUI() {
		this.setResizable(false);
		setTitle("帮助声明");
		setIcon();// 设置图标
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 685, 786);
		this.setLocationRelativeTo(null);// 居中显示
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 255, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(45, 77, 560, 600);
		contentPanel.add(scrollPane);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		editorPane.setBackground(new Color(240, 255, 240));
		editorPane.setText(
				"  帮助文档：\r\n    \t感谢使用本博客管理系统，本系统致力于为用户打造\r\n\t最舒适，最便捷的博客管理系统。\r\n\t本系统部分内容来源与网络，如有侵权请与我们联系。\r\n\t\r\n   使用说明：\r\n     \t 本系统默认一个全局管理员账号供您使用，当您登\r\n\t录管理员账号时，您可以使用本系统对文章进行增删\r\n\t改查等操作。同时还可以对本系统内用户信息的查看\r\n\t，修改，删除，还可以添加新用户。另外双击您选中\r\n\t的文章可进行查看文章操作，右键单击可以对文章进\r\n\t行删除。双击您选中的用户可以修改用户信息，右键\r\n\t可以删除用户。\r\n\t注： 普通用户只能进行个人的文章信息修改，删除。\r\n\t不具备用户管理功能，能够写文章，看大家的文章\r\n\t但已足够。还有更多功能正在开发中，欢迎用户为我\r\n\t们提供宝贵意见。敬请期待\r\n\r\n\t");
	}

	// 设置图标
	public void setIcon() {
		// 修改图标
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
//		java.awt.Image img = tk.getImage(HelpDocUI.class.getResource("top\\picture\\fox.png"));	//要使用反斜杠才可以
		// 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDocUI.class.getResource("/top/picture/fox.png")));
	}
}
