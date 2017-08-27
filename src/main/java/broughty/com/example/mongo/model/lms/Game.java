package broughty.com.example.mongo.model.lms;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {

    @Id
    Integer id;

    Round round;

    LocalDate from;

    LocalDate to;

    List<Team> teams = new ArrayList<>();

    List<Player> players = new ArrayList<>();

    List<PlayerChoice> playerChoices = new ArrayList<>();


    public Game() {
    }


    public PlayerChoice addPlayerChoice(PlayerChoice pc) {
        playerChoices.add(pc);
        return pc;
    }
}
