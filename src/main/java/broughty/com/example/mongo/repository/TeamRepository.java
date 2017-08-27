package broughty.com.example.mongo.repository;

import broughty.com.example.mongo.model.lms.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
    public Team findByName(String name);

    public Team findById(String abbreviation);

}
