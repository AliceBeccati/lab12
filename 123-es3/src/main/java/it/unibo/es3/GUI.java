package it.unibo.es3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class GUI extends JFrame {
    
    private final Map<Pair<Integer,Integer>,JButton> cells = new HashMap<>();
    private final JButton skip = new JButton(">>>");
    Logic logic;
    
    public GUI(int width) {
        this.logic = new LogicImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        JPanel panelSkip = new JPanel();
        this.getContentPane().add(BorderLayout.CENTER,panel);
        this.getContentPane().add(BorderLayout.SOUTH,panelSkip);
        ActionListener al = e -> {
            update(logic.advance(cells.keySet().stream().toList()));
            if(logic.toQuit()){
                System.exit(0);
            }
        };
        skip.addActionListener(al);
        panelSkip.add(skip);
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
            	Pair<Integer,Integer> pos = new Pair<>(j,i);
                final JButton jb = new JButton("");
                this.cells.put(pos, jb);
                panel.add(jb);
            }
        }

        update(logic.initializeRandom(width));

        this.setVisible(true);
    }

    private void update(List<Pair<Integer,Integer>> returnPos){
        cells.keySet().stream().filter(k -> returnPos.contains(k)).forEach(k->{
            cells.get(k).setText("*");
        });
    }
    
}