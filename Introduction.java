import processing.core.PApplet;
import processing.core.PImage;
public class Introduction {
    PImage BGS;
    PImage BG_level1;
    PImage BG_level2;
    PImage gameover;
    PApplet parent;
    public  Introduction (PApplet parent) {
        this.parent = parent;

        BGS = parent.loadImage("images\\BGS.jpeg");
        BG_level1 = parent.loadImage("images\\BG level3.jpg");
        BG_level2 = parent.loadImage("images\\BG level2.jpg");
        gameover = parent.loadImage("images\\gameover1.png");
    }

    public void show() {
        parent.image(BGS, 0,0, 900, 500);
        parent.fill(0);
        parent.textSize(55);
        //parent.textAlign( parent.CENTER);
        parent.text("Play", 775 , 210);
    }

    boolean isPlayButtonClicked() {
        return (parent.mouseX > 700 && parent.mouseX < 850 && parent.mouseY > 150 && parent.mouseY < 300);
    }

    public void show_level1() {
        parent.image(BG_level1, 0,0, parent.width, parent.height);
    }
    public void show_level2() {
        parent.image(BG_level2,0,0, parent.width, parent.height);
    }
    public void gameover(){
        parent.image(gameover, 600, 300,200,200);
    }

}