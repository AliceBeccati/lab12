package it.unibo.es3;

import java.util.List;

public interface Logic {

    public List<Pair<Integer,Integer>> advance(List<Pair<Integer,Integer>> cells); 

    public List<Pair<Integer,Integer>> initializeRandom(int limit);
    
    public boolean toQuit();
}
