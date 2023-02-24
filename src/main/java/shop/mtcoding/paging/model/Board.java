package shop.mtcoding.paging.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private Integer id;
    private String title;
    private String content;
    private Integer usersId;
    private Timestamp createdAt; // At 시분초 다 표현할때, Dt 년원일

    public Board(String title, String content, Integer usersId) {
        this.title = title;
        this.content = content;
        this.usersId = usersId;
    }

}
