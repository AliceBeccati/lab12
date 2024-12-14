package it.unibo.es2;

import java.util.List;

public interface Logics {

    String hit(Pair<Integer,Integer> buttonPosition);

    boolean getValue(Pair<Integer,Integer> buttonPosition);

    boolean quit();

    List<Boolean> getCol(int x);

    List<Boolean> getRow(int y);
}
