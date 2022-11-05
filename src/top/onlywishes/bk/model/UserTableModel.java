package top.onlywishes.bk.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import top.onlywishes.bk.model.*;

public class UserTableModel extends AbstractTableModel {
	private String[] columnNames;// 表格头
	private ArrayList<Admin> admins = null;

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public ArrayList<Admin> getReader() {
		return admins;
	}

	public void setReader(ArrayList<Admin> admins) {
		this.admins = admins;
	}

	public UserTableModel(ArrayList<Admin> admins) {
		this.columnNames = new String[] { "用户ID", "用户名", "用户昵称", "性别", "登录密码", "创建日期" };
		this.admins = admins;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return admins.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		String value = null;
		if (admins.size() > 0) {
			Admin admin = admins.get(arg0);
			switch (arg1) {
			case 0:// 用户ID列
				value = String.valueOf(admin.getA_id());
				break;
			case 1:// 用户名列
				value = admin.getA_name();
				break;
			case 2:// 昵称列
				value = admin.getA_nichen();
				break;
			case 3:// 性别列
				value = admin.getA_sex();
				break;
			case 4: // 登录密码列
				value = admin.getA_pwd();
				break;
			case 5: // 创建日期列
				value = admin.getA_date();
				break;

			default:
				value = "";
			}
		}
		return (Object) value;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
