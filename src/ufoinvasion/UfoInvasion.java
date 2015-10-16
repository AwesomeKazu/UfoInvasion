package ufoinvasion;

import java.util.*;
import org.newdawn.slick.*;

public class UfoInvasion extends BasicGame {

    private Image hintergrund, ufobild, raumschiffbild;
    private Schuss schuss;
    private Ufo ufo;
    private Raumschiff raumschiff;
    private ArrayList<Schuss> schussliste;
    private Sound feuer, explosion;
    private Punkte punkte;
    private Music music;
    private Font meineschrift;
    private Effekte effekte;
    private int mausX,mausY;
    
    public UfoInvasion() {
        super("Ufo Invasion");
    }
    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new UfoInvasion());
        container.setDisplayMode(1024, 768, false);
        container.setClearEachFrame(false);
        container.setMinimumLogicUpdateInterval(25);
        container.start();
    }
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        hintergrund.draw();
        ufo.draw(g);
        raumschiff.draw(g);
        effekte.draw(g);
        punkte.draw(g,meineschrift);
        for (Schuss tempschuss: schussliste) {
            g.fillOval(tempschuss.x, tempschuss.y, 10, 10);
        }
    }
    @Override
    public void init(GameContainer container) throws SlickException {
        hintergrund = new Image("resourcen/Background1.jpg");
        ufobild = new Image("resourcen/Ship2.png");
        raumschiffbild = new Image("resourcen/Ship1.png");
        ufo = new Ufo(100,100,ufobild);
        effekte = new Effekte();
        raumschiff = new Raumschiff(200, 400, raumschiffbild,effekte.getRaketenRauchEmitter());
        schussliste = new ArrayList<Schuss>();
        feuer = new Sound("resourcen/sounds/schuss.wav");
        explosion = new Sound("resourcen/sounds/explosion.wav");
        punkte = new Punkte(0);
        music = new Music("resourcen/sounds/music.mod");
        music.loop();
        meineschrift = new AngelCodeFont("resourcen/fonts/score_numer_font.fnt", "resourcen/fonts/score_numer_font.png");
        
    }
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        mausX = container.getInput().getMouseX();
        mausY = container.getInput().getMouseY();
        ufo.update(delta);
        effekte.update(delta);
        raumschiff.update(mausX,mausY);
        
        
        for (Schuss tempschuss: schussliste) {
            tempschuss.update(delta);
            if (ufo.pruefeKollsion(schuss)){
                explosion.play();
                effekte.ufoExpolsion(tempschuss.x, tempschuss.y);
                ufo.neuesUfo(container.getWidth(),container.getHeight());
                punkte.abschuss("ufo");
                schussliste.clear();
                break;
            }
        }
        if (container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            schuss = new Schuss(raumschiff.x,raumschiff.y);
            schussliste.add(schuss);
            feuer.play();
        }
        if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
            System.out.println(punkte.getPunkte());
            System.out.println("Ufo Position :" + ufo.getY());
        }
        if (ufo.bildschirmRand()){
            container.pause();
            meineschrift.drawString(200, 200, "GAME OVER");
        }
    }
}


