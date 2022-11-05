package top.onlywishes.bk.model;



public class Article {
    private int article_id;
    private int article_author_id;
    private String article_type;
    private String article_title;
    private String article_content;
    private String article_limit;
    private String article_date;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getArticle_author_id() {
        return article_author_id;
    }

    public void setArticle_author_id(int article_author_id) {
        this.article_author_id = article_author_id;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String getArticle_limit() {
        return article_limit;
    }

    public void setArticle_limit(String article_limit) {
        this.article_limit = article_limit;
    }

    public String getArticle_date() {
        return article_date;
    }

    public void setArticle_date(String article_date) {
        this.article_date = article_date;
    }

    public Article() {
    }

    public Article(int article_id, int article_author_id, String article_type, String article_title,
                   String article_content, String article_limit, String article_date) {
    	super();
        this.article_id = article_id;
        this.article_author_id = article_author_id;
        this.article_type = article_type;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_limit = article_limit;
        this.article_date = article_date;
    }

    //不带ID 和日期的构造方法
    public Article(int article_author_id, String article_type, String article_title, String article_content,
                   String article_limit) {
    	super();
        this.article_author_id = article_author_id;
        this.article_type = article_type;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_limit = article_limit;
    }
}
