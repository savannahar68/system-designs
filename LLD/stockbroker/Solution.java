import java.io.*;
import java.time.Instant;
import java.util.*;

/**
Design stock broker System => Assuming only client side needs to be catered and 
Depository and Exchange side is black box here - 

1. User registers to broker
2. User adds stocks in watch list 
3. User buy and sells stock
4. User can watch his portfolio in realtime
5. At year end User can get Profit and loss and other statements 
6. Expose APIs so that user can build automated strategies on top of it.   

Assumptaions : 

Client is connected to load balancer or the server using socket/tcp (we don't worry about this part)

Server(acting as a client) is connected to Exchanges using either Server side events or Sockets or Grpc - We don't worry about this either 

// High level thought 

Build a observer based system where clients (Mobile application) subscribe to list of stocks and broker receives updates from publisher (which then notifies the subscribers)

Entities of the system : 

1. User 
    Name,
    Docuemnts for compliance etc,
    List of stocks in its watchlist
    List of orders 
    List of transactions 
    Portfolio 
2. Broker 
    List of User
3. Exchange - For now we'll create our own interface and have it as a adapter based pattern so that in future new implementation of Exchanges won't affect our system
    - Name of the exchange
    - Polling rate 
    - Configurations defined for connection with Exchange
4. Depository 
    List<User> 
    User documents
5. Stock 
    Tick
    queue<Price> 

Services which we'll be having is :

1. User side 
    createAccount
    deleteAccount
    createWatchList()
    addToWatchList()
    buy()
    sell()

2. Broker Observable (Indirectly it queries service from exchange)
    subscribeUser(User, list<Stock>)
    updateSubscriberList(User, list<Stock>)
    deregisterSubscriber(User)
    notify() => 
3. Exchange
    1. SubscribeTick()
    2. getTickPrice(); => Listener
*/  

// ENUM

enum StockBuySellType {
  AT_MARKET,
  STOPLOSS,
  AT_LIMIT,
  BO_ORDER,
}

enum TransactionStatus {
  INITIALIZED,
  PENDING,
  COMPLETE,
  REJECTED,
  FAILED; // This is when Exchange server crashes or something, we should ask for retry on client side 
}

enum AccountStatus {
  CREATED,
  PENDING,
  REQUESTED,
  CANCELLED,
  DELETED,
  BLOCKED,
  HOLD,
  UNKNWON;
}

// Domain
class User {
  UUID id;
  String name;
  String document; // this is going to be a object created via Document builder

  public User(String name, String document) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.document = document;
  }

  public String getName() { return this.name; }
  // similarly have getters on other fields
}


// This will be in factory 
class UserObservableImpl implements UserObservable {
  User user;
  public UserObservableImpl (User user) { this.user = user; }
  
  @Override
  public void getStockUpdatesForWatchList(Stock stock) {
    // call some other internal service which handles has connection details and send the tick update
  }
}

class WatchList {
  String name;
  List<Stock> stocksList;
  public WatchList(String name) {
    this.name = name;
  }

  void setStockList(List<Stock> stockList) { this.stocksList = stockList; }
  void addStocksToTheList(Stock stock) { this.stocksList.add(stock); } // TODO: check for duplicates
}

class Stock {
  String tick;
  Queue<Double> price; // TODO: think if we need to extract it to a class
  // Price will be a object having Double value and timestamp

  public Stock(String tick) { this.tick = tick; }

  void setPrice(List<Double> price) { this.price.addAll(price); }
  void addPriceToThequeue(Double price, Instant time) {
    this.price.add(price);
  }
}

class Transaction {
  Stock stock;
  Double price;
  TransactionStatus status;
  UUID id;
  UUID userId;

  public Transaction (Stock stock, Double price, TransactionStatus status, UUID userId) {
    this.stock = stock;
    this.price = price;
    this.status = status;
    this.userId = userId;
  }
}

// Interfaces 

interface UserServce {
    User createAccount(String name, String document); // here we'll use document builder
    void deleteAccount(User user);
    WatchList createWatchList(UUID id, String watchListName);
    void addToWatchList(UUID id, WatchList watchList, Stock stock);
    Transaction buy(UUID id,Stock stock, Double price); // return status
    Transaction sell(UUID id, Stock stock, Double price, StockBuySellType buySellTypeEnum); // return status
}

interface UserDao {
    User addAccount(String name, String document); // here we'll use document builder
    void deleteAccount(User user);
    WatchList createWatchListForUser(UUID id, String watchListName);
    void addToWatchListForUser(WatchList watchList, Stock stock);
    Transaction buyForUser(UUID id, Stock stock, Double price); // return status
    Transaction sellForUser(UUID id, Stock stock, Double price, StockBuySellType buySellTypeEnum); // return status
    List<User> getAllUserSubscriberToAStock(Stock stock);
}

interface UserObservable {
  void getStockUpdatesForWatchList(Stock stock);
}

// Observabel 

class Broker {
  Map<User, UserObservable> userObserableMap;
  UserDao userDao;
  public Broker() {
    // call factory for getting UserDao 
    // userDao = new Factory().get<UserDao>("UserDao");
  }

  void notify(Stock stock, Double price) {
    // update the Stock price queue  
    // userDao gives list of user to send stock
    if (userObserableMap.containsKey(new User("", ""))) {
      userObserableMap.get(new User("", "")).getStockUpdatesForWatchList(stock);
    }
  }
}


class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}
