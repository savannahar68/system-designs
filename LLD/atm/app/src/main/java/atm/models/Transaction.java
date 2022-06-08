package atm.models;

import atm.enums.TxnStatus;
import atm.enums.TxnType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Transaction {
    LocalDateTime txnTime;
    Double amount;
    TxnType type;
    TxnStatus status;
}
