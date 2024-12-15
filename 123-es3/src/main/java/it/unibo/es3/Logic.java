package it.unibo.es3;

import java.util.List;
import java.util.Map;

import javax.swing.JButton;

public interface Logic {

    public List<Pair<Integer,Integer>> advance(Map<Pair<Integer,Integer>,JButton> cells); 

    public List<Pair<Integer,Integer>> initializeRandom(int limit);

    public boolean toQuit(Map<Pair<Integer,Integer>,JButton> cells);
}
