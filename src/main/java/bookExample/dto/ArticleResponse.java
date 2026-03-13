package bookExample.dto;

import bookExample.entity.Article;
import lombok.Data;

@Data
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content=article.getContent();
    }
}
