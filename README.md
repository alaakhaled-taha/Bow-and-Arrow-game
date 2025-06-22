```java
/**
 * Main class:
 * Setup: Initializes the game environment, including loading images and audio files,
 * setting up the canvas size, and creating instances of the game objects.
 * Reset Methods: resetSketch() and resetArrows() methods are responsible for resetting
 * the game state, such as creating new balloons and clearing the arrow list.
 * Drawing: The draw() method continuously redraws the game environment. It handles
 * different levels of the game and calls corresponding methods to display the
 * appropriate content.
 * Game Logic: The level1() method contains the main game logic for level 1. It handles
 * balloon movement, collision detection between arrows and balloons, scoring, and
 * determining game over conditions.
 * Input Handling: Mouse and keyboard input handling methods (mousePressed(),
 * mouseDragged(), mouseReleased(), keyPressed(), mouseClicked()) manage player
 * interactions with the game.
 * Exit Functionality: The ex() method draws an "Exit" button, and the mouseClicked()
 * method detects when the button is clicked to exit the game.
 */
class Main {
    // Implementation of Main class
}

/**
 * Arrow class:
 * Instance variables:
 * - float x: This variable represents the x-coordinate of the arrow's starting point on the canvas.
 * - float y: This variable represents the y-coordinate of the arrow's starting point on the canvas.
 * - PApplet part: This variable holds a reference to the Processing application (PApplet object) where
 * the arrow will be drawn.
 * Methods:
 * - public Arrow(PApplet part, float x, float y) { ... }
 * - public boolean stop() { ... }
 * - public void update() { ... }
 * - public void display() { ... }
 * - public float getX() { ... }
 * - public float getY() { ... }
 */
class Arrow {
    // Implementation of Arrow class
}

/**
 * Balloon class:
 * Instance variables:
 * - level: Represents the level of the balloon.
 * - photo: Represents the image of the balloon.
 * - pop and popy: Represents images for popped balloons.
 * - x and y: Store the coordinates of the balloon.
 * - popped: Indicates if the balloon is popped or not.
 * - parent: Reference to the main PApplet object.
 * - yspeed: Speed at which the balloon moves vertically.
 * - acc: Acceleration for the balloon's vertical movement.
 * Methods:
 * - show()
 * - moveup()
 * - movedown()
 * - isPopped()
 * - pop()
 * - getX()
 * - getY()
 * - showpy()
 * - showp()
 * - up()
 * Overall Purpose: This class represents a balloon object that can be displayed on a Processing canvas.
 * It handles movement, popping, and displaying of balloons and their popped states.
 */
class Balloon {
    // Implementation of Balloon class
}

/**
 * Introduction class:
 * Instance variables:
 * - PImage BG: This variable holds the image for the initial screen.
 * - PImage BG_level1: This variable holds the image for level 1 background.
 * - PImage BG_level2: This variable holds the image for level 2 background.
 * - PImage game_over: This variable holds the image for the game over screen.
 * - PApplet parent: This variable holds a reference to the main Processing application (PApplet object),
 * which is necessary for drawing images on the canvas and handling other processing-related tasks.
 * Methods:
 * - Constructor Method (Introduction)
 * - show() Method
 * - show_level1() Method
 * - show_level2() Method
 * - game_over() Method
 * Overall Purpose: This class encapsulates the logic for displaying different screens or backgrounds within
 * a Processing application. It provides methods to show the initial screen, different levels' backgrounds,
 * and the game over screen.
 */
class Introduction {
    // Implementation of Introduction class
}

/**
 * Game explanation:
 * - Game Start:
 *   When the game starts, the introductory screen is displayed, prompting the player to press a key
 *   ‘space’ to begin (levels == 0).
 *   After the player presses a key, the game transitions to level 1 (levels == 1).
 * - Game Win:
 *   If the player successfully pops all the balloons in level 1 (bbscore == 15 && levels == 1), a message
 *   congratulating the player and prompting them to proceed to the next level is displayed.
 *   After the player presses a key, the game transitions to level 2 (levels == 2).
 *   If the player successfully completes level 2 (bbscore == 15 && levels == 2), a message congratulating
 *   the player and displaying their final score is shown (finaltotalScore).
 *   After this, the game ends (levels == 3).
 * - Game Lose:
 *   If the player runs out of arrows (ascore == 0) and there are still unpopped balloons remaining (bbscore != 15),
 *   a "Game Over" message is displayed, prompting the player to try again.
 *   If the player chooses to try again by pressing the space bar (over == "GAMEOVER" && levels == 1/2 &&
 *   bbscore != 15 && ascore == 0), the game resets to the beginning of the current level.
 * - Game Exit:
 *   If the player clicks on the "Exit" button (mouseClicked() when mouse is within the exit button area),
 *   the game terminates (exit()).
 */
```
