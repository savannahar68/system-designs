package stackoverflow.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Comment {
    UUID id;
    UUID memberId;
    String comment;
    Integer upvote;
    Integer downVote;

    public Comment(UUID memberId, String comment) {
        this.id = UUID.randomUUID();
        this.memberId = memberId;
        this.comment = comment;
        this.upvote = 0;
        downVote = 0;
    }
 }
