package broughty.com.example.mongo.repository;

import broughty.com.example.mongo.model.lms.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    public Player findByName(String name);

}
