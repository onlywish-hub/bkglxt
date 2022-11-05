package top.onlywishes.bk.model;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;



public class ArticleTableModel extends AbstractTableModel {

    private String[] columnNames = null;// 表格头

    private ArrayList<Article> articles = null; // 表格体

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public ArticleTableModel(ArrayList<Article> articles) {
        this.columnNames = new String[] { "文章ID", "作者ID", "文章类别","文章标题", "文章内容", "文章权限", "发布时间" };
        this.articles = articles;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String value = null;
        if (articles.size() > 0) {
            Article article = articles.get(rowIndex);
            switch (columnIndex) {
                case 0:// 编号列
                    value = String.valueOf(article.getArticle_id());
                    break;
                case 1:// 作者ID列
                    value = String.valueOf(article.getArticle_author_id());
                    break;
                case 2:// 类别列
                    value = article.getArticle_type();
                    break;
                case 3:// 标题列
                    value = article.getArticle_title();
                    break;
                case 4:// 文章内容列
                    value = String.valueOf(article.getArticle_content());
                    break;
                case 5: // 权限列
                    value = String.valueOf(article.getArticle_limit());
                    break;
                case 6:// 发布时间列
                    value = article.getArticle_date();
                    break;
                default:
                    value = "";
            }
        }
        return (Object) value;
    }

    @Override
    public int getRowCount() {
        // 返回模型中的行数。
        return articles.size();
    }

    @Override
    public int getColumnCount() {
        // 返回模型中的列数。
        return columnNames.length;
    }

    /**
     * 取指定列的列名
     *
     * @param column
     * @return
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
