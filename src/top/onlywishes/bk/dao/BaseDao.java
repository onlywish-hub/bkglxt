package top.onlywishes.bk.dao;



import top.onlywishes.bk.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 *
 *创建对数据库连接对象，整个项目与数据库打交道都用这一个对象.
 */
public class BaseDao {
//    public Connection con;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    {
        con = new DbUtil().getCon();
    }

    public void closeDao(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //	执行查询语句
    public ResultSet execute(String sql, ArrayList params) throws ClassNotFoundException, SQLException {
        rs = null;
        ps = null;
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
            rs = ps.executeQuery();
        } finally {
            // this.closeAll();
        }
        return rs;
    }

    /*
     * 执行SQL中的插入、修改和删除操作，返回受影响的行数
     */
    public int upDate(String sql, ArrayList params) {
        ps = null;// 获得预编译的SQL对象
        int num = 0;
        try {
            ps = con.prepareStatement(sql);
            if (params != null) {
                int i = 0;
                for (Object param : params) {
                    if (param instanceof Integer) {
                        ps.setInt(++i, ((Integer) param).intValue());
                    } else if (param instanceof String) {
                        ps.setString(++i, param.toString());
                    } else if (param instanceof Double) {
                        ps.setDouble(1, ((Double) param).doubleValue());
                    }

                }
                num = ps.executeUpdate();

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return num;
    }

}



