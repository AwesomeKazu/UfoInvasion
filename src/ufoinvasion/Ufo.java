package ufoinvasion;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.*;

/**
 *
 * @author tietjeje
 */
public class Ufo extends SpielObjekt{
    private double speed=2;
    private double accelartion=0.01;
    private final Shape kollisionsFlaeche;

    public Ufo(int x, int y, Image image) {
        this.x =x;
        this.y =y;
        this.image=image;
        kollisionsFlaeche = new Ellipse(this.x+60, this.y+30, 60, 30);
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y);
    }
    @Override
    public void update(int delta){
        y += speed;
        speed += accelartion;
        kollisionsFlaeche.setCenterX(this.x+60);
        kollisionsFlaeche.setCenterY(this.y+30);
    }
    public boolean pruefeKollsion(SpielObjekt spielObjekt) {
        return kollisionsFlaeche.contains(spielObjekt.getX(),spielObjekt.getY());
    }
    public void neuesUfo(int weite, int höhe){
        this.x = (int)(Math.random()*weite);
        this.y = /*(int)(Math.random()*höhe)*/0;
    }
    public boolean bildschirmRand(){
        if (this.y <= 750){
            return true;
        }else{
            return false;
        }
    }
}