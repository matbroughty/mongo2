package broughty.com.example.mongo.repository;

import broughty.com.example.mongo.model.lms.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoundRepository extends MongoRepository<Round, String> {
    public Round findByRoundNumber(Integer roundNumber);

}
