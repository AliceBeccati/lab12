package it.unibo.es3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class LogicImpl implements Logic{
    private int width;

    LogicImpl(int width) {
        this.width = width;
    }

    @Override
    public List<Pair<Integer,Integer>> advance(Map<Pair<Integer,Integer>,JButton> cells) {
        return cells.entrySet().stream().filter(e -> e.getValue().getText().equals("*")).map(e -> e.getKey()).toList();
    }

    private List<Pair<Integer,Integer>> nextButton(Pair<Integer,Integer> b){
        return  null;
    }

    @Override
    public List<Pair<Integer,Integer>> initializeRandom(int limit) {
        List<Pair<Integer,Integer>> l = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Random rand = new Random();
            l.add(new Pair<>(rand.nextInt(limit),rand.nextInt(limit)));
        }
        return l;
    }

    @Override
    public boolean toQuit(Map<Pair<Integer,Integer>,JButton> cells) {
        return cells.values().stream().allMatch(b -> b.getText().equals("*"));
    }

}
