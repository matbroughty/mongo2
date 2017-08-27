package broughty.com.example.mongo.repository;

import broughty.com.example.mongo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    public Order findByName(String name);

}
