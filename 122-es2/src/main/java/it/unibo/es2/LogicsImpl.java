package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics{
    private final List<List<Boolean>> table;

    LogicsImpl(int size) {
        this.table = new ArrayList<>();
        for (int i = 0; i < size; i++) {
        	List<Boolean> l = new ArrayList<>(); 
        	this.table.add(l);
        	for (int j = 0; j < size; j++) {
        		l.add(false);
        	}
        }
    }
    
    @Override
    public String hit(Pair<Integer,Integer> buttonPosition) {
        int x = buttonPosition.getX();
        int y = buttonPosition.getY();
        this.table.get(x).set(y, !getValue(buttonPosition));
        if (this.getValue(buttonPosition)){
            return "*";   
        }
        else{
            return "";
        }
    }

    @Override
    public boolean getValue(Pair<Integer,Integer> position){
        return table.get(position.getX()).get(position.getY());
    }

    @Override
    public boolean quit() {
        for (int i = 0; i<table.size(); i++) {
            List<Boolean> row = getRow(i);
            List<Boolean> col = getCol(i);
            if(row.stream().allMatch(e -> e.equals(true)) ||
                    col.stream().allMatch(e -> e.equals(true))){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Boolean> getRow(int x) {
        return table.get(x);
    }

    @Override
    public List<Boolean> getCol(int y) {
        List<Boolean> l = new ArrayList<>();
        table.forEach(e->l.add(e.get(y)));
        return l;
    }
    
}
