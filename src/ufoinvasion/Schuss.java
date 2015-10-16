package ufoinvasion;

import org.newdawn.slick.Graphics;


public class Schuss extends SpielObjekt{
    //g.fillOval(int x, int y, int weight, int width)
    public Schuss(int x, int y) {
        super(x, y);
    }

    
    @Override
    public void update(int delta){
        y -= 5;
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
