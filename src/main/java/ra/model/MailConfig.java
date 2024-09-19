package ra.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MailConfig {
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String signature;
}
