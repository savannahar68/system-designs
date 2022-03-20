package stackoverflow.Domain;

import java.util.UUID;

public class Bounty {
    UUID bountySenderMemberId;
    Integer bountyAmount;
    UUID paymentId;
    Boolean isBountyClaimed;
    UUID bountyReceiverMemberId;
}
