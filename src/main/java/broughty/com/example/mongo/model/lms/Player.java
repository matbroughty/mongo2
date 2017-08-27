package broughty.com.example.mongo.model.lms;

import org.springframework.data.annotation.Id;

public class Player {
    @Id
    String id;

    String name;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
