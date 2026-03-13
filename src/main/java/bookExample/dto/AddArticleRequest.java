package bookExample.dto;

import bookExample.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AddArticleRequest {

    private Integer id;
    private String title;
    private String content;



    public Article toEntity(){
        return Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }

}
