package top.onlywishes.bk.view;


import top.onlywishes.bk.dao.AdminDao;
import top.onlywishes.bk.model.Admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class loginUI extends JPanel {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                loginUI frame = new loginUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private JLabel lblIcon;
    public static JTextField txtLogin;
    private JPasswordField txtPassword;
    public static String Username="apple" ;
    public String UserName;
    public final String a =Username;
//	public String getUsername() {
//		return Username;
//	}
//
//	public void setUsername(String username) {
//		Username = username;
//	}

	/**
     * Create the panel.
     */
    @SuppressWarnings("deprecation")
    public loginUI() {
        setBackground(new Color(245, 255, 250));
        setLayout(null);
        setSize(984, 550);
        // 放置LOGO
        ImageIcon icon = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\logo177.png");
        lblIcon = new JLabel(icon);
        lblIcon.setBounds(195, 216, 177, 177);
        this.add(lblIcon);
        // 放置登录
        ImageIcon icos = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\login2.png");
        JLabel lblLoginIcon = new JLabel(icos);
        lblLoginIcon.setBounds(534, 189, 58, 32);
        this.add(lblLoginIcon);
        // 放置账号图
        ImageIcon iconUser = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\account.png");
        JLabel lblAccount = new JLabel(iconUser);
        lblAccount.setBounds(425, 232, 32, 32);
        this.add(lblAccount);
        // 放置密码图
        ImageIcon iconPassword = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\password.png");
        JLabel lblPassword = new JLabel(iconPassword);
        lblPassword.setBounds(425, 286, 32, 32);
        this.add(lblPassword);
        // 账号输入框
        txtLogin = new JTextField();
        txtLogin.setBounds(467, 231, 200, 35);
        this.add(txtLogin);
        txtLogin.setColumns(10);
        // 文本输入框
        txtPassword = new JPasswordField();
        txtPassword.setBounds(467, 285, 200, 35);
        this.add(txtPassword);

        // 分隔线
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);// 设置分割线竖直
        separator.setBackground(SystemColor.activeCaption);
        separator.setBounds(400, 104, 1, 400);
        this.add(separator);
        // QQ图标
        ImageIcon imageQQ = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\qq.png");
        JLabel lblQQ = new JLabel(imageQQ);
        lblQQ.setBounds(607, 375, 25, 25);
        this.add(lblQQ);
        // 微信图标
        ImageIcon imagewx = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\wx.png");
        JLabel lblwx = new JLabel(imagewx);
        lblwx.setBounds(642, 375, 25, 25);
        this.add(lblwx);
        // 微博图标
        ImageIcon imagewb = new ImageIcon("E:\\桌面\\Java\\图书管理系统\\图书管理系统最终版修改\\图书管理系统\\java\\Desktop\\LibraryManagerSystem\\picture\\wb.png");
        JLabel lblwb = new JLabel(imagewb);
        lblwb.setBounds(574, 375, 25, 25);
        this.add(lblwb);

        // 登录按钮
        JButton btnLogin = new JButton("登录");
        btnLogin.addActionListener(e -> {
//			new MainUI().setVisible(true);

            UserName = txtLogin.getText();
            
            Username = (String) UserName;
            
//			System.out.println(Username.toString());
//			System.out.println(this.UserName.toString());
//            
            String UserPwd = txtPassword.getText();
            String username = UserName;
//            System.out.println(isNumeric(UserName));
//            boolean isNumber = isNumeric(UserName);
//            if (isNumber && !"".equals(UserName)) {
//                username =UserName;
//            }

            AdminDao admin = new AdminDao();
            Admin admins = null;
            try {
                admins = admin.getAdminByNM(String.valueOf(username));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            if (admins == null) {
                RemainUI ra=new RemainUI("提示","您输入的账号不正确");     //RemainUI用来生成提示语句
                ra.setVisible(true);
                txtLogin.setText("");
                txtPassword.setText("");
            } else if ("".equals(UserPwd)) {
                JOptionPane.showMessageDialog(null, "请输入密码");
            } else if (!UserPwd.equals(admins.getA_pwd())) {
                JOptionPane.showMessageDialog(null, "您输入的密码有误,请重新输入密码");
                txtLogin.setText("");
                txtPassword.setText("");
            } else {
                JOptionPane.showMessageDialog(null,"登陆成功！");
//                this.setVisible(false);
//                new MainUI().setVisible(true);        //账号密码正确，此语句打开主页面进入///////////////////////////////////////////////
                MainUI mi = new MainUI();
                mi.setVisible(true);
                


                
            }
            

        });
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(154, 205, 50));
                btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(50, 205, 50));
            }
        });

        btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        btnLogin.setBackground(new Color(50, 205, 50));
        btnLogin.setBounds(467, 330, 200, 35);
        this.add(btnLogin);

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

