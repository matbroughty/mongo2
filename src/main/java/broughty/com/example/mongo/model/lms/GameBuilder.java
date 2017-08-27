package broughty.com.example.mongo.model.lms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    Integer id;
    Round round;
    LocalDate from;
    LocalDate to;
    List<Team> teams = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    List<PlayerChoice> playerChoices = new ArrayList<>();

    private GameBuilder() {
    }

    public static GameBuilder aGame() {
        return new GameBuilder();
    }

    public GameBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public GameBuilder withRound(Round round) {
        this.round = round;
        return this;
    }

    public GameBuilder withFrom(LocalDate from) {
        this.from = from;
        return this;
    }

    public GameBuilder withTo(LocalDate to) {
        this.to = to;
        return this;
    }

    public GameBuilder withTeams(List<Team> teams) {
        this.teams = teams;
        return this;
    }

    public GameBuilder withPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public GameBuilder withPlayerChoices(List<PlayerChoice> playerChoices) {
        this.playerChoices = playerChoices;
        return this;
    }

    public Game build() {
        Game game = new Game();
        game.to = this.to;
        game.players = this.players;
        game.teams = this.teams;
        game.round = this.round;
        game.from = this.from;
        game.playerChoices = this.playerChoices;
        game.id = this.id;
        return game;
    }
}
