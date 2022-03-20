package stackoverflow.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Activity {
    Map<Timestamp, String> activity;
}
