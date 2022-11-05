package top.onlywishes.bk.dao;

import top.onlywishes.bk.model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDao extends BaseDao {
    public ArrayList<Article> getAll() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM article";
        ResultSet rs = this.execute(sql, null);

        ArrayList<Article> articles = new ArrayList<>();
        try {
            while (rs.next()) {
                Article article = new Article();
                article.setArticle_id(rs.getInt("article_id"));
                article.setArticle_author_id(rs.getInt("article_author_id"));
                article.setArticle_type(rs.getString("article_type"));
                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_limit(rs.getString("article_limit"));
                article.setArticle_date(rs.getString("article_date"));


                articles.add(article);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return articles;

    }

    //通过文章biaoti查询文章
    public  Article getArticlesByArticleTital(String article_tital) throws SQLException, ClassNotFoundException {
        Article article = null;
        String sql = "SELECT * FROM article WHERE article_title=?";
        ArrayList params = new ArrayList();
        params.add(article_tital);
        ResultSet rs = this.execute(sql, params);

        try {
            while (rs.next()) {
                article = new Article();
                article.setArticle_id(rs.getInt("article_id"));
                article.setArticle_author_id(rs.getInt("article_author_id"));
                article.setArticle_type(rs.getString("article_type"));
                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_limit(rs.getString("article_limit"));
                article.setArticle_date(rs.getString("article_date"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(article.toString());

        return article;
    }
    
    //通过文章ID 查询文章
    public  Article getArticlesByArticleID(int articleID) throws SQLException, ClassNotFoundException {
        Article article = null;
        String sql = "SELECT * FROM article WHERE article_id=?";
        ArrayList params = new ArrayList();
        params.add(articleID);
        ResultSet rs = this.execute(sql, params);
        try {
            while (rs.next()) {
                article = new Article();
                article.setArticle_id(rs.getInt("article_id"));
                article.setArticle_author_id(rs.getInt("article_author_id"));
                article.setArticle_type(rs.getString("article_type"));
                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_limit(rs.getString("article_limit"));
                article.setArticle_date(rs.getString("article_date"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(article.toString());

        return article;
    }
    
    
    
    
    

    //通过文章标题查询文章模糊
    public  ArrayList<Article> SelectArticlesByArticleTital(String name) throws SQLException, ClassNotFoundException {
        ArrayList<Article> articles = new ArrayList<>();
        Article article = null;
        String sql = "SELECT * FROM article WHERE article_title like ?";
        ArrayList params = new ArrayList();
        params.add(name);
        ResultSet rs = this.execute(sql, params);

        try {
            while (rs.next()) {
                article = new Article();
                article.setArticle_id(rs.getInt("article_id"));
                article.setArticle_author_id(rs.getInt("article_author_id"));
                article.setArticle_type(rs.getString("article_type"));
                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_limit(rs.getString("article_limit"));
                article.setArticle_date(rs.getString("article_date"));
articles.add(article);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return articles;
    }


    
    //通过文章biaoti查询文章模糊查询
    public ArrayList<Article> getArticlesByArticleTital_MOHU(String article_tital) throws SQLException, ClassNotFoundException {
        ArrayList<Article> articles = new ArrayList<>();
     
    	Article article = null;
        String sql = "SELECT * FROM article WHERE article_title like ?";
        ArrayList params = new ArrayList();
        params.add(article_tital);
        ResultSet rs = this.execute(sql, params);

        try {
            while (rs.next()) {
                article = new Article();
                article.setArticle_id(rs.getInt("article_id"));
                article.setArticle_author_id(rs.getInt("article_author_id"));
                article.setArticle_type(rs.getString("article_type"));
                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_limit(rs.getString("article_limit"));
                article.setArticle_date(rs.getString("article_date"));
articles.add(article);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(article.toString());

        return articles;
    }
    

    
    
    public int AddArticle(Article article) {
        String sql = "INSERT INTO article(article_author_id,article_type,article_title,article_content," +
                "article_limit) VALUES(?,?,?,?,?)";
        ArrayList params = new ArrayList();
//        params.add(article.getArticle_id());
        params.add(article.getArticle_author_id());
        params.add(article.getArticle_type());
        params.add(article.getArticle_title());
        params.add(article.getArticle_content());
        params.add(article.getArticle_limit());
//        params.add(article.getArticle_date());
        int result = this.upDate(sql, params);
        return result;
    }

//	根据标题更新文章
    public int UpdateArticle(Article article) {
        String sql = "UPDATE article SET article_author_id=?,article_type=?,article_content=?," +
                "article_title=?,article_limit=? WHERE article_title=?;";
        ArrayList params = new ArrayList();

        params.add(article.getArticle_author_id());
        params.add(article.getArticle_type());
        params.add(article.getArticle_content());

        params.add(article.getArticle_title());
        params.add(article.getArticle_limit());
        
        params.add(article.getArticle_title());
        int result = this.upDate(sql, params);
        return result;
    }

    public int deleteArticle(String ArticleTital) {
        String sql = "DELETE FROM article WHERE article_title=?";
        ArrayList params = new ArrayList();
        params.add(ArticleTital);
        int result = this.upDate(sql, params);
        return result;
    }
    
    
    //根据用户名删除文章
    public int deleteArticle_user(String username) {
        String sql = "DELETE FROM article WHERE article_author_id=(select a_id from b_admin where a_name=?)";
        ArrayList params = new ArrayList();
        params.add(username);
        int result = this.upDate(sql, params);
        return result;
    }
    
    
//    public int deleteArticle_ID(int articleID) {
//        String sql = "DELETE FROM article WHERE article_id=?";
//        ArrayList params = new ArrayList();
//        params.add(articleID);
//        int result = this.upDate(sql, params);
//        return result;
//    }
}
