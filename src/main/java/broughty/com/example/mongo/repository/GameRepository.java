package broughty.com.example.mongo.repository;

import broughty.com.example.mongo.model.lms.Game;
import broughty.com.example.mongo.model.lms.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
    public Game findByRound(Round roundNumber);

    public Game findById(Integer gameNumber);

}
