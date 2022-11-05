package  top.onlywishes.bk.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class PrivacyUI extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            PrivacyUI dialog = new PrivacyUI();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public PrivacyUI() {
        this.setResizable(false);
        setTitle("隐私政策");
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
        scrollPane.setBounds(45, 56, 560, 621);
        contentPanel.add(scrollPane);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        scrollPane.setViewportView(editorPane);
        editorPane.setBackground(new Color(240, 255, 240));
        editorPane.setText(
                "更新日期:2022年6月20日\r\n生效日期:2022年6月20日\r\n      欢迎使用“博客管理系统”提供的服务!我们深知个人信息对您的重要性，并庄严承诺保护使用用户(以下统称“用户”或“您”)的个人信息及隐私安全。您在使用博客管理系统时，我们可能会收集和使用您的相关个人信息。我们希望通过《隐私政策》(以下简称“本政策”）向您说明我们在收集和使用您的相关个人信息时对应的处理规则等相关事宜，以便更好的保障您的权益。\r\n    【特别提示】请您在使用博客管理前，仔细阅读（未成年人请在监护人陪同下阅读）并了解本政策，您应重点阅读，在确认充分理解并同意后再开始使用。如果您不同意本政策的内容，将可能导致服务无法正常运行，或者无法达到我们拟达到的服务效果，您应立即停止访问/使用该系统服务。");
    }

    // 设置图标
    public void setIcon() {
        // 修改图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        // 获取图片 三种图片格式都可以

        // 给窗体设置图标
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(HelpDocUI.class.getResource("/top/picture/fox.png")));
    }
}
