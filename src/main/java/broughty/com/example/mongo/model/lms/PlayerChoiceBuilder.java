package broughty.com.example.mongo.model.lms;

public final class PlayerChoiceBuilder {
    Player player;
    Game game;
    Team team;

    private PlayerChoiceBuilder() {
    }

    public static PlayerChoiceBuilder aPlayerChoice() {
        return new PlayerChoiceBuilder();
    }

    public PlayerChoiceBuilder withPlayer(Player player) {
        this.player = player;
        return this;
    }

    public PlayerChoiceBuilder withGame(Game game) {
        this.game = game;
        return this;
    }

    public PlayerChoiceBuilder withTeam(Team team) {
        this.team = team;
        return this;
    }

    public PlayerChoice build() {
        PlayerChoice playerChoice = new PlayerChoice(player, game, team);
        return playerChoice;
    }
}
