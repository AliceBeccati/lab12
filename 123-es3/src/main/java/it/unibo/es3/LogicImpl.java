package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class LogicImpl implements Logic{
    List<Pair<Integer,Integer>> s;
    private final int width;

    LogicImpl(int width) {
        s = new ArrayList<>();
        this.width = width;
    }

    @Override
    public List<Pair<Integer,Integer>> advance(List<Pair<Integer,Integer>> cells) {
        s.addAll(cells.stream().filter(p -> nextButton(p)).toList());
        return s;
    }

    private boolean  nextButton(Pair<Integer,Integer> p){
        for(Pair<Integer,Integer> star :s ) {
            if(Math.abs(star.getX() - p.getX()) <= 1 && Math.abs(star.getY() - p.getY()) <= 1 && !star.equals(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Pair<Integer,Integer>> initializeRandom(int limit) {
        for(int i = 0; i < 3; i++){
            Random rand = new Random();
            s.add(new Pair<>(rand.nextInt(limit),rand.nextInt(limit)));
        }
        return s;
    }

    @Override
    public boolean toQuit() {
        return s.size() == this.width * this.width;
    }
}
