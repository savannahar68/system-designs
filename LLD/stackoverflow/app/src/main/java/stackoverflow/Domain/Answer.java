package stackoverflow.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Answer {
    UUID id;
    UUID memberId;
    String answer;
    Integer upvote;
    Integer downVote;
    Boolean isSelected;

    public Answer(UUID memberId, String answer) {

    }
}
