package broughty.com.example.mongo.model.lms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class PlayerChoice {

    @Id
    String id;

    Player player;

    @DBRef
    Game game;

    Team team;

    public PlayerChoice(Player player, Game game, Team team) {
        this.player = player;
        this.game = game;
        this.team = team;
    }


}
