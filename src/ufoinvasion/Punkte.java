
package ufoinvasion;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;


public class Punkte {
    private int punkte;
    
    public Punkte(int punkte) {
        this.punkte = 0;
    }

    public void abschuss(String a) {
        if(a=="ufo"){
            this.punkte = this.punkte + 100;
        }
        if(a=="mutterschiff"){
            this.punkte = this.punkte + 1000;
        }
    }

    public int getPunkte() {
        return punkte;
    }
     public void draw(Graphics g,Font meineschrift) {
        meineschrift.drawString(800, 24, punkte+"");
        //g.drawString(punkte+"", 950, 24);
    }
    
    
    
}
