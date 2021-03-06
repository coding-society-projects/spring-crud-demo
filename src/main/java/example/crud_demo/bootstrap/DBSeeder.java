package example.crud_demo.bootstrap;

import example.crud_demo.model.Article;
import example.crud_demo.model.Comment;
import example.crud_demo.repository.ArticleRepository;
import example.crud_demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DBSeeder {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        Article article1 = new Article();
        article1.setContent("Java is cool.");
        articleRepository.save(article1);
        Article article2 = new Article();
        article2.setContent("Java will fail.");
        articleRepository.save(article2);

        Comment comment1 = new Comment();
        comment1.setContent("I don't agree");
        comment1.setArticle(article1);
        commentRepository.save(comment1);
        Comment comment2 = new Comment();
        comment2.setContent("Not really");
        comment2.setArticle(article2);
        commentRepository.save(comment2);
    }
}
