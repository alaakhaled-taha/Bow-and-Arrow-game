import processing.core.PApplet;
import processing.core.PImage;
public class Balloon {
    int level=1;
    PImage photo;
    PImage pop,popy;
    float x;
    float y;
    boolean popped;
    PApplet parent;
    float yspeed=3;
    double acc=.02;
    public Balloon (PApplet parent,float x,float y,PImage photo) {
        this.parent = parent;
        this.x=x;
        this.y=y;
        this.photo=photo;
        pop = parent.loadImage("images\\popped red.png");
        popy = parent.loadImage("images\\popped yellow.png");
    }
    public void show (){

        if (!popped && photo != null) {
            parent.image(photo, x, y, 70, 70);
        }
    }
    public void moveup()
    {
        y-=3;
        if(y<=-50){
            y=parent.height;
        }
    }
    public void movedown() {
        y += 10;

    }
    public boolean isPopped() {

        return popped;
    }
    public void pop() {
        popped = true;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void showpy() {
        parent.image(popy, x, y, 50, 50);
    }
    public void showp() {
        parent.image(pop, x, y, 50, 50);
    }
    public void up(){
        y-=yspeed;
        yspeed+=acc;
        if(yspeed>=6||yspeed<3)
        {
            acc*=-1;
        }
        if(y<=-50){
            y=parent.random(500,700);
            x=parent.random(350,parent.width-110);
        }
    }

}