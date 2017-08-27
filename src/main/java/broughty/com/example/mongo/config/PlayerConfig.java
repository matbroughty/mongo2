package broughty.com.example.mongo.config;

import broughty.com.example.mongo.model.lms.Player;
import broughty.com.example.mongo.model.lms.Team;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class PlayerConfig {


    @Value("${name}")
    private String name;

    @Value("#{'${player.names}'.split(',')}")
    private List<String> playerNames;

    @Value("#{'${team.names}'.split(',')}")
    private List<String> teamNames;

    @Bean
    List<Player> getPlayers() {
        return playerNames.stream().map(s -> new Player(s, s)).collect(Collectors.toList());

    }

    @Bean
    List<Team> getTeams() {
        return teamNames.stream().map(s -> new Team(StringUtils.substringBefore(s, ":"),
                StringUtils.substringAfter(s, ":"))).collect(Collectors.toList());
    }

}
