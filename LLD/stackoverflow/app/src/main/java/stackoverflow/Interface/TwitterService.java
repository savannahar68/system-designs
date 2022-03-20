package stackoverflow.Interface;

import stackoverflow.Domain.Bounty;
import stackoverflow.Domain.Comment;
import stackoverflow.Domain.Member;
import stackoverflow.Domain.Question;

import java.util.UUID;

public interface TwitterService {
    Member addMember(String name);
    void removeMember(UUID id);

    // instead of this pattern have a BUILDER pattern for Question
    Question addQuestion(UUID memberId, String question);
    Question addQuestionWithCode(UUID memberId, String question, String code);
    Question addQuestionWithBounty(UUID memberId, String question, String code, Bounty bounty);

    // answer and comment
    Comment addCommentForAQuestion(UUID memberId, UUID questionId, String text);
    Comment addCommentForAAnswer(UUID memberId, UUID questionID, UUID answerId, String text);
    Comment addCommentForAComment(UUID memberId, UUID questionID, UUID commentId, String text);

    // Similar for answer and comment
    // calculation for reputation will be here
    void upvoteQuestion(UUID memberId, UUID questionId);
    void downvoteQuestion(UUID memberId, UUID questionId);

    // ReputationService can be a listener to upvote and downvote question
}
