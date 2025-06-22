import processing.core.PApplet;
import java.util.ArrayList;
import processing.core.PImage;
import ddf.minim.*;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }
    Minim arrow;
    AudioPlayer arrow_sound;
    Minim pop;
    AudioPlayer popped;
    Minim background;
    AudioPlayer backgrounds;
    PImage fire1 ,fire2,reload1,reload2,photor,photoy;
    ArrayList<Arrow> arrows = new ArrayList<Arrow>(20);
    Balloon[] b=new Balloon[15];
    Introduction Intro;
    boolean flag=true,Drag,nextLevel,introScreen = true,mouseClicked = false;
    String over="GAMEOVER";
    float mouse;
    int aascore=0,ascore=0,bbscore=0 ,score=0,levels=0,totalScore1,totalScore2,finaltotalScore;

    public void settings(){
        size(900,500);}
    public void setup(){
        fire2 = loadImage("images\\fire2.png");
        reload2= loadImage("images\\reload2.png");
        fire1= loadImage("images\\fire1.png");
        reload1= loadImage("images\\reload1.png");
        photor= loadImage("images\\red balloon.png");
        photoy = loadImage("images\\yellow balloon.png");
        arrow=new Minim(this);
        arrow_sound=arrow.loadFile("sounds\\arrow sound.mp3");
        pop=new Minim(this);
        popped=pop.loadFile("sounds\\pop.mp3");
        background=new Minim(this);
        backgrounds=background.loadFile("sounds\\background.mp3");
        resetSketch();
        mouse=height/2;
        Intro = new Introduction(this);
    }
    public void resetSketch(){
        for (int j = 0; j < b.length; j++) {
            if(!nextLevel) {
                b[j] = new Balloon(this, 350 + (j * 33), height, photor);
            } else{
                if(j<12) {
                    b[j] = new Balloon(this, random(350, width - 110), random(500, 1000), photor);
                }else
                    b[j] = new Balloon(this, random(350, width - 110), random(500, 1000), photoy);
            }
        }
    }
    public void resetArrows() {
        arrows.clear(); // Clear the list of arrows
        aascore = 0; // Reset the number of arrows fired
        ascore = 20; // Reset the available arrows (20 - aascore)
    }
    public void draw(){
        background(0, 153, 76);
        //backgrounds.play();
        if(levels==0){
            Intro.show();


        } else if (levels==1) {
            Intro.show_level1();
            level1();

        }
        else if (levels==2) {
            Intro.show_level2();
            level1();
            totalScore2=score ;
            finaltotalScore=totalScore1+totalScore2;
        }
       ex();
    }
    public void level1(){

        for (int j = 0; j < b.length; j++) {

            if (!b[j].isPopped()) {
                b[j].show();
                if (!nextLevel) {
                    b[j].moveup();
                }else{
                    if(j<12){
                        b[j].moveup();
                    }else{
                        b[j].up();
                    }
                }
            }
            else{
                if (!nextLevel ){
                    b[j].showp();
                }else {
                    if(j<12) {
                        b[j].showp();
                    }else{
                        b[j].showpy();
                    }}
                b[j].movedown();
                if(bbscore==15&&levels==1){

                    fill(255);
                    text("Congratulations, You passed Level 1  , Up to Level 2" ,500,200);
                    text(" Press 'Space' To NEXT",500,400);
                }else if (bbscore==15&&levels==2 ){
                    text("Congratulations, You passed Level 2 , you Win" ,500,200);
                    text(" finalScore="  +finaltotalScore,350,200);}
                else if (ascore==0 && bbscore!=15 ) {
                    background(0);
                    Intro.gameover();
                    fill(255,0,0);
                    textAlign(CENTER, CENTER);
                    text(over,450,250);
                    text(" Press 'Space' To Try Again",450,350);
                    break;
                }}
            fill(255);
            textSize(25);
            text("score="  +score,55,25);
        }
        for (int i = arrows.size()-1 ; i >= 0 ; i--) {
            Arrow a=arrows.get(i);
            a.display();
            a.update();
            for ( Balloon Balloon : b ) {
                if ((a.getX() >=Balloon.getX()+15&& a.getX() <= Balloon.getX()+45)&&(a.getY()>=Balloon.getY()+15&&a.getY() <= Balloon.getY()+45)) {
                    Balloon.pop();
                    popped.play();
                    popped.rewind();
                }}}
        bbscore=updatePoppedBalloons();

        score = (ascore + 1) * bbscore;
        if(flag){
            if(!nextLevel) {
                image(fire1, 10, mouse -60, 150, 150);
            }else
                image(fire2, 10, mouse-60, 150, 150);
        } else{
            if(!nextLevel) {
                image(reload1, 10, mouse - 60, 150, 150);
            }else
                image(reload2, 10, mouse-60, 150, 150);
        }
    }
    public int updatePoppedBalloons() {
        int bscore = 0;
        for (Balloon balloon : b) {
            if (balloon.isPopped()) {
                bscore++;
            }}
        return bscore;
    }
    public void mousePressed() {
        if (introScreen && Intro.isPlayButtonClicked()) {
            levels = 1; // Transition to level 1
            introScreen = false; // Update game state to indicate not in introduction screen anymore
            return; // Return without processing arrow firing
        }
        if (mouseButton == LEFT || mouseButton == RIGHT) {
            Drag = false;
            mouseClicked = true; // Set mouseClicked to true when mouse button is pressed
        }
    }
    public void mouseDragged() {

        if (mouseButton == LEFT) {
            Drag=true;
            mouse =  constrain(mouseY, 80, height - 100);
        }}
    public void mouseReleased() {
        if (introScreen) {
            return; // If in intro screen, return without processing arrow firing
        }

        if (mouseClicked) { // Fire arrow only if mouseClicked is true
            if (mouseButton == LEFT && !Drag && arrows.size() < 20 && flag) {
                Arrow newArrow = new Arrow(this, 10, mouse);
                arrow_sound.play();
                arrow_sound.rewind();
                arrows.add(newArrow);
                flag = false;
                aascore++;
                ascore = 20 - aascore;
            }
        }

        if (mouseButton == RIGHT && arrows.size() < 20) {
            flag = true;
        }

        mouseClicked = false; // Reset mouseClicked after processing mouse click
    }
    public void keyPressed() {
        if (levels ==1&& bbscore==15) {
            totalScore1 = score;
            levels = 2;
            nextLevel=true;
            resetSketch();
            resetArrows();
        }else if(levels==2&&bbscore==15){
            totalScore2=score ;
            finaltotalScore=totalScore1+totalScore2;
            levels=3;
        }else if(levels==3){exit();}
        else if(over=="GAMEOVER"&&levels==1&&bbscore!=15&&ascore==0) {
            nextLevel=false;
            resetSketch();
            resetArrows();
        }else if(over=="GAMEOVER"&&levels==2&&bbscore!=15&&ascore==0) {
            nextLevel=true;
            resetSketch();
            resetArrows();
        }}

    public void ex(){
        fill(255);
        textSize(25);
        textAlign(CENTER);
        text("Exit", 800 + 100/2, 15 + 50/2);}

    public void mouseClicked() {
        if (mouseX > 800 && mouseX < 800 + 100 && mouseY > 15 && mouseY < 15 + 50) {
            exit();
        }

    }
}
