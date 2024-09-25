package ra.orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Song {
    private int id;
    private String songName;
    private String singerName;
    private String genre;
    private boolean status;
}
