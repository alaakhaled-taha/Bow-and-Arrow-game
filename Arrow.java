import processing.core.PApplet;
public class Arrow {
    float x, y;
    PApplet part;
    public Arrow (PApplet part, float x, float y) {
        this.part = part;
        this.x = x;
        this.y = y;

    }
    public boolean stop(){
        if(x > 812) {
            x=10;
        }
        return true;
    }
    public void update() {
        x += 7;
    }

    public void display() {
        part.strokeWeight(3);
        part.line(x+20, y-5, x+80, y-5);
        part.triangle(x+88,y-5,x+80,y-8,x+80,y-2);
    }
    public float getX(){
        return x+88;
    }
    public float getY(){
        return y-5;
    }
}