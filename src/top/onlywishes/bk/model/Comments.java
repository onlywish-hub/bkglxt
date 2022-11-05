package top.onlywishes.bk.model;

public class Comments {
    private int comm_id;
    private int comm_article_id;
    private int comm_author_id;
    private String comm_content;
    private String comm_date;

    public int getComm_id() {
        return comm_id;
    }

    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }

    public int getComm_article_id() {
        return comm_article_id;
    }

    public void setComm_article_id(int comm_article_id) {
        this.comm_article_id = comm_article_id;
    }

    public int getComm_author_id() {
        return comm_author_id;
    }

    public void setComm_author_id(int comm_author_id) {
        this.comm_author_id = comm_author_id;
    }
    

    public String getComm_content() {
        return comm_content;
    }

    public void setComm_content(String comm_content) {
        this.comm_content = comm_content;
    }

    public String getComm_date() {
        return comm_date;
    }

    public void setComm_date(String comm_date) {
        this.comm_date = comm_date;
    }


    public Comments() {
    }

    public Comments(int comm_id, int comm_article_id, int comm_author_id, 
                    String comm_content, String comm_date) {
        this.comm_id = comm_id;
        this.comm_article_id = comm_article_id;
        this.comm_author_id = comm_author_id;
        this.comm_content = comm_content;
        this.comm_date = comm_date;
    }

    //评论只需要输入文章ID和评论内容，其他的都自动补充
    public Comments(int comm_article_id, String comm_content) {
        this.comm_article_id = comm_article_id;
        this.comm_content = comm_content;
    }
}