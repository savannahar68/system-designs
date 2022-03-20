package stackoverflow.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Question {
    UUID id;
    UUID memberId;
    String question;
    String code;
    List<String> tagList;
    List<String> keywordList; // tags can be language tags, keywords can be related to technologies or help needed
    List<Answer> answersList;
    List<Comment> commentsList;
    Integer upvote;
    Integer downVote;
    Boolean isBounty;
    Bounty bounty;

    public Question(UUID memberId, String question, String code, List<String> tagList, List<String> keywordList, List<Answer> answersList, List<Comment> commentsList, Integer upvote, Integer downVote, Boolean isBounty, Bounty bounty) {
        this.id = UUID.randomUUID();
        this.memberId = memberId;
        this.question = question;
        this.code = code;
        this.tagList = tagList;
        this.keywordList = keywordList;
        this.answersList = answersList;
        this.commentsList = commentsList;
        this.upvote = upvote;
        this.downVote = downVote;
        this.isBounty = isBounty;
        this.bounty = bounty;
    }

    public Question(UUID memberId, String question, String code, Boolean isBounty, Bounty bounty) {
        this(memberId, question, code, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), 0, 0, isBounty, bounty);
    }

    public Question(UUID memberId, String question, String code) {
        this(memberId, question, code, false, null);
    }

    public Question(UUID memberId, String question) {
        this(memberId, question, "", false, null);
    }
}
