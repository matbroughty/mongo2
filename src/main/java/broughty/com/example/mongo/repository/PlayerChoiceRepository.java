package broughty.com.example.mongo.repository;


import broughty.com.example.mongo.model.lms.PlayerChoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerChoiceRepository extends MongoRepository<PlayerChoice, String> {

}
