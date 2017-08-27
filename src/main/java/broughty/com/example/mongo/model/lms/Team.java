package broughty.com.example.mongo.model.lms;

import org.springframework.data.annotation.Id;

public class Team {

    @Id
    String id;

    String name;


    public Team() {
    }

    public Team(String name, String abbreviation) {

        this.name = name;
        this.id = abbreviation;
    }
}
