package stackoverflow.Domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Member {
    UUID id;
    LocalDateTime creationDate;
    String name;

    // Dont have these list - as this is duplicate
    List<Question> questionList;
    List<Answer> answerList;
    List<Comment> commentList;
    //

    int reputation;
    Activity activity; // basically keep track of when one got upvoted or downvoted and calculate comments or other things
    List<Reward> rewards;

    public Member(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        creationDate = LocalDateTime.now();
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public void addAnswer(Answer answer) {
        answerList.add(answer);
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }
}
