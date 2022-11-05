package top.onlywishes.bk.model;

public class Admin {
    private int a_id;
    private String a_name;
    private String a_nichen;
    private String a_date;
    private String a_sex;
    private String a_pwd;

    public Admin() {
    }

    
//    public Admin(String a_nichen,String a_sex, String a_pwd) {
//    	this.a_nichen=a_nichen;
//    	this.a_sex=a_sex;
//    	this.a_pwd = a_pwd;
//    }
    
    public Admin(String a_name,String a_nichen,String a_sex,String a_pwd) {
        this.a_name = a_name;
        this.a_nichen = a_nichen;
        this.a_sex = a_sex;
        this.a_pwd = a_pwd;
	}
    
    
    public Admin(int a_id, String a_name, String a_nichen, String a_date, String a_sex, String a_pwd) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_nichen = a_nichen;
        this.a_date = a_date;
        this.a_sex = a_sex;
        this.a_pwd = a_pwd;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_nichen() {
        return a_nichen;
    }

    public void setA_nichen(String a_nichen) {
        this.a_nichen = a_nichen;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public String getA_sex() {
        return a_sex;
    }

    public void setA_sex(String a_sex) {
        this.a_sex = a_sex;
    }

    public String getA_pwd() {
        return a_pwd;
    }

    public void setA_pwd(String a_pwd) {
        this.a_pwd = a_pwd;
    }
}
