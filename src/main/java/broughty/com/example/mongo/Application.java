package broughty.com.example.mongo;

import broughty.com.example.mongo.model.Customer;
import broughty.com.example.mongo.model.Order;
import broughty.com.example.mongo.model.lms.*;
import broughty.com.example.mongo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerChoiceRepository playerChoiceRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private List<Player> players;


    @Autowired
    private List<Team> teams;

    @Value("${name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        orderRepository.save(new Order("Beano"));
        orderRepository.save(new Order("28738273", "Dandy"));

        Order orderSaved = orderRepository.findByName("Beano");

        repository.save(new Customer("Mat", "Broughton", new Order("SomeStuff")));

        repository.save(new Customer("Dan", "Broughton", orderSaved));
        repository.save(new Customer("Dan", "Broughton", orderSaved));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
            if (customer.getOrders().size() > 0) {
                System.out.println("Found custmer with order " + customer.getFirstName());
            }
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        Round round1 = new Round(new Integer(1), LocalDate.now(), new BigDecimal("23.50"));

        roundRepository.save(round1);
        roundRepository.save(new Round(new Integer(3), LocalDate.now(), new BigDecimal("55.50")));
        roundRepository.save(new Round(new Integer(2), LocalDate.now(), new BigDecimal("55.50")));
        roundRepository.save(new Round(new Integer(5), LocalDate.now(), new BigDecimal("85.50")));
        roundRepository.save(new Round(new Integer(4), LocalDate.now(), new BigDecimal("50.00")));


        gameRepository.save(GameBuilder.aGame().withId(Integer.valueOf(1)).
                withRound(round1).withFrom(LocalDate.now()).withTo(LocalDate.now().plusDays(3)).build());

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }


        roundRepository.findAll(new Sort(Sort.Direction.ASC, "id")).stream().forEach(System.out::println);

        System.out.println("Round byfind id = " + roundRepository.findByRoundNumber(new Integer("1")));

        roundRepository.findAll(new Sort(Sort.Direction.DESC, "winnings")).stream().forEach(System.out::println);


        playerRepository.save(players);

        teamRepository.save(teams);


        Game game = gameRepository.save(GameBuilder.aGame().
                withRound(round1).
                withId(Integer.valueOf(2)).
                withPlayers(playerRepository.findAll()).
                withTeams(teamRepository.findAll()).build());


        PlayerChoice pc = PlayerChoiceBuilder.aPlayerChoice().withGame(game).withPlayer(players.get(0)).
                withTeam(teamRepository.findById("ARS")).build();

        PlayerChoice pc2 = PlayerChoiceBuilder.aPlayerChoice().withGame(game).withPlayer(players.get(1)).
                withTeam(teamRepository.findById("TOT")).build();


        pc = playerChoiceRepository.save(pc);
        pc2 = playerChoiceRepository.save(pc2);

        game.addPlayerChoice(pc);
        game.addPlayerChoice(pc2);

        gameRepository.save(game);


    }

}