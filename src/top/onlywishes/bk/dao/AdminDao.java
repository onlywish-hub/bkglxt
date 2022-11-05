package top.onlywishes.bk.dao;


import top.onlywishes.bk.model.Admin;
import top.onlywishes.bk.model.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao extends BaseDao {
    /**
     * 管理员登陆
     */
    public Admin login(Admin admin){
        String sql = "select * from b_admin where name=? and password=?";
        Admin adminRst = null;
        try {

            PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
            prst.setString(1, admin.getA_name());
            prst.setString(2, admin.getA_pwd());
            ResultSet executeQuery = prst.executeQuery();
            if(executeQuery.next()){
                adminRst = new Admin();
                adminRst.setA_id(executeQuery.getInt("a_id"));
                adminRst.setA_name(executeQuery.getString("a_name"));
                adminRst.setA_nichen(executeQuery.getString("a_nichen"));
                adminRst.setA_date(executeQuery.getString("a_date"));
                adminRst.setA_sex(executeQuery.getString("a_sex"));
                adminRst.setA_pwd(executeQuery.getString("a_pwd"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return adminRst;
    }
    
    //修改密码
    public String editPassword(Admin admin,String newPassword){
        String sql = "select * from b_admin where a_name =? and a_pwd=?";
        PreparedStatement prst = null;
        String a_name = null;
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1, admin.getA_name());
            prst.setString(2, admin.getA_pwd());
            ResultSet executeQuery = prst.executeQuery();
            if(!executeQuery.next()){
                String retString = "旧密码错误！";
                return retString;
            }
            a_name = executeQuery.getString("a_name");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }//把sql语句传给数据库操作对象
        String retString = "修改失败";
        String sqlString = "update b_admin set a_pwd = ? where a_name = ?";
        try {
            prst = con.prepareStatement(sqlString);
            prst.setString(1, newPassword);
            prst.setString(2, a_name);
            int rst = prst.executeUpdate();
            if(rst > 0){
                retString = "密码修改成功！";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//把sql语句传给数据库操作对象
        return retString;
    }

    /*
     * 执行SQL中的插入、修改和删除操作，返回受影响的行数
     */
    public int executeSQL(String sql, ArrayList params) {
        ps = null;
        int num = 0;
        try {

            // 创建预编译的语句对象
            ps = con.prepareStatement(sql);
            // 根据传参的情况，设置？的值 ,pstat.setXXX()
            if (params != null) {
                int i = 0;
                for (Object param : params) {
                    // 根据参数的类型分别进行处理
                    if (param instanceof Integer) {
                        ps.setInt(++i, ((Integer) param).intValue());
                    } else if (param instanceof Double) {
                        ps.setDouble(++i, ((Double) param).doubleValue());
                    } else if (param instanceof String) {
                        ps.setString(++i, param.toString());
                    } else if (param instanceof Boolean) {
                        ps.setBoolean(++i, ((Boolean) param).booleanValue());
                    }
                }
            }
            // 执行SQL
            num = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
//            this.closeDao();
        }
        return num;
    }


    public void updataSex(String sex,String name){
        String sql = "update b_admin set a_sex=? where a_name=?";
        PreparedStatement prst = null;
        int re ;
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1, sex);
            prst.setString(2, name);
            re = prst.executeUpdate();
            if(re>0){
                String ret = "性别添加成功！";
                System.out.println(ret);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
    
    
    //获取所有用户
    public ArrayList<Admin> getAll() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM b_admin";
        ResultSet rs = this.execute(sql, null);

        ArrayList<Admin> admins = new ArrayList<>();
        try {
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setA_id(rs.getInt("a_id"));
      
                admin.setA_name(rs.getString("a_name"));
                admin.setA_nichen(rs.getString("a_nichen"));
                admin.setA_date(rs.getString("a_data"));
                admin.setA_sex(rs.getString("a_sex"));
                admin.setA_pwd(rs.getString("a_pwd"));


                admins.add(admin);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return admins;

    }

    // 通过用户名获取用户
    public Admin getAdminByNM(String name) throws SQLException, ClassNotFoundException {
        Admin admin1 = null;
        String sql = "SELECT * FROM b_admin WHERE a_name=?";
        ArrayList params = new ArrayList();
        params.add(name);
        ResultSet rs = this.execute(sql,params);

        try {
            while (rs.next()) {
                admin1 = new Admin();
                admin1.setA_name(rs.getString("a_name"));
                admin1.setA_pwd(rs.getString("a_pwd"));
                admin1.setA_id(rs.getInt("a_id"));
                admin1.setA_date(rs.getString("a_data"));
                admin1.setA_name(rs.getString("a_name"));
                admin1.setA_nichen(rs.getString("a_nichen"));
                
                //可以继续增加信息
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return admin1;
    }


    
    
	  //删除用户
		public int deleteUser(String name) {
			String sql="delete from b_admin where a_name=?";
			ArrayList params=new ArrayList();
			params.add(name);
			int result=this.executeSQL(sql, params);
			return result;
	 	}
		
		
//		根据用户名更新用户
	    public int UpdateUser(Admin admin) {
	        String sql = "UPDATE b_admin SET a_nichen=?,a_sex=?,a_pwd=? where a_name=?";
	        ArrayList params = new ArrayList();
	        params.add(admin.getA_nichen());
	        params.add(admin.getA_sex());
	        params.add(admin.getA_pwd());
	        params.add(admin.getA_name());

	        int result = this.upDate(sql, params);
	        return result;
	    }

    //注册使用
    // 向用户表中插入数据
    public int AddAdmin(String adminName,String pwd) {
        int results = 0;
        String sql = "INSERT INTO b_admin(a_name,a_pwd) VALUES(?,?);";
        ArrayList params = new ArrayList();
        params.add(adminName);
        params.add(pwd);
        results = this.executeSQL(sql, params);
        return results;
    }
    
    //非注册使用
    // 向用户表中插入数据
    public int AddAdminUser(Admin admin) {
        int results = 0;
        
        String sql = "INSERT INTO b_admin(a_name,a_nichen,a_sex,a_pwd) VALUES(?,?,?,?);";
        ArrayList params = new ArrayList();
        params.add(admin.getA_name());
        params.add(admin.getA_nichen());
        params.add(admin.getA_sex());
        params.add(admin.getA_pwd());
        results = this.executeSQL(sql, params);
        return results;
    }    

    // 查询admin最后一次加入的语句
    public Admin getLastAdmin_name() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM b_admin ORDER BY a_id DESC LIMIT 1;";
        Admin admin = null;
        ResultSet rs = this.execute(sql, null);

        try {
            while (rs.next()) {
                admin = new Admin();
                admin.setA_name(rs.getString("a_name"));
                admin.setA_pwd(rs.getString("a_pwd"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return admin;
    }
}

