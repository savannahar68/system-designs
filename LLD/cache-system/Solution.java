import java.io.*;
import java.util.*;
import org.jmock.*;
import org.junit.*;
import org.junit.runner.*;

/**

Problem statement: 
We have to do low level design for a Cache system. Cache that we will design will have to support following operations:
Put: This will allow user to put a value against a key in the cache.
Get: This will allow user to get the previously saved value using key.
Eviction: Cache should also support removal of some key in case cache is full, and we try to add new key value.

Expectations : 
Code should be functionally correct.
Code should be modular and readable. Clean and professional level code.



Requirement clarification : 
// We can use any data structure
// Can be any primitive or wrapper object 
// Cache Eviction - LRU
// Single threaded

// LinkedList <Key, Value> FIFO 
// HashMap <Key, Node>


// Domain objects
1. Cache (Data structures)


// Interfaces

1. CacheService // get put => clients
2. CacheEvictionStrategy // evictionPolicy  // Stratgy pattern
3. CacheDao // get, put // Adapter pattern // Factory 

// CacheService 

*/

// Domain 
class Node<T,K> {
  T key;
  K value;

  public Node(T key, K value) { 
    this.key = key; 
    this.value = value; 
  }
}

// Interaces 

interface CacheService <T,K> {
  K get(T key);
  void put(T key, K value);
}


interface CacheEvictionStrategy {
  void strategy(LinkedList<Node> cache, Node nodeToBeRemoved);
}

interface CacheDao<T,K> {
  K get(T key);
  void put(T key, K value);
}


// Service 

class CacheDaoImpl<T,K> implements CacheDao {

  LinkedList<Node> cache;
  Map<T, Node> evictionCheckerMap;
  Integer capactiy;
  

  public CacheDaoImpl(Integer capacity) {
    this.cache = new LinkedList<>();
    this.evictionCheckerMap = new HashMap<>();
    this.capactiy = capactiy;
  }


	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

} 

class CacheServiceImpl<T,K> implements CacheService {

  CacheDao cacheDao;
  CacheEvictionStrategy strategy;
  public CacheServiceImpl() {
    this.cacheDao = new CacheDaoImpl(10); // Factory 
    strategy = new CacheEvictionStrategyImpl() // Factory
  }

	@Override
	public Object get(Object key) {
		return cacheDao.get(key)
	}

	@Override
	public void put(Object key, Object value) {
		cacheDao.put(key, value);
	}

  private void evictData() {
    //call strategy and check
  }
}


class Solution {
  @Test
    public void testMock() {}

  public static void main(String[] args) {

  }
}


// Improvements :

/*
0. Try to clear the Requirement and start with coding in 10mins
1. Generics nameing should be good
2. Cache evictionPolicy should be part of service bcz it violates SRP if we keep in DAO
*/
