package ufoinvasion;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.particles.ConfigurableEmitter;

public class Raumschiff extends SpielObjekt{
    
    private ConfigurableEmitter emitter;
    public Raumschiff(int x, int y, Image image, ConfigurableEmitter emitter) {
        super(x, y, image);
        this.emitter = emitter;
    }
    
    @Override
    public void draw(Graphics g) {
        image.drawCentered(x, y);
        //g.drawImage(image, x, y);
    }
    public void update(int x, int y){
        this.x = x;
        this.y = y;
        emitter.setPosition(x, y, false);
    }
}
