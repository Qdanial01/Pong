import java.awt.*;

public class Paddle {

    //declare instance variables
    private int height, x, y, speed;
    private Color color;

    //constant
    static final int PADDLE_WIDTH = 15;

    /**
     * A paddle is a rectangle/block that can move up and down
     * @param x the x position to start drawing the paddle
     * @param y the y position to start drawing the paddle
     * @param height the paddle height
     * @param speed the amount the paddle may move per frame
     * @param color the paddle color
     */
    public Paddle(int x, int y, int height, int speed, Color color){
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    /**
     * Paints a rectangle on the screen 
     * @param g graphics object passed from calling method
     */

    public void paint(Graphics g){

        //paint the rectangle for the paddle
        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, height);
    }

    /**
     * Move the paddle towards this y position every frame (centered)
     * @param moveToy - positions the paddle is centered on
     */

    public void moveTowards(int moveToy){
        //find the location of the center of the paddle
        int centerY = y + height / 2;

        //determine if we need to move more than the speed away from where we are now
        if(Math.abs(centerY - moveToy) > speed) {
            //if the center of the paddle is too far down
            if(centerY > moveToy){
                //move the paddle up by the speed
                y -= speed;
            }
            //if the center of the paddle is too far up
            if(centerY < moveToy){
                //move the paddle down by speed
                y += speed;
            }

        }

    }   

    /**
     * 
     * @param b the ball we're checking the collision with
     * @return true if collision is detected
     */
    public boolean checkCollision(Ball b){
        
        int rightX = x + PADDLE_WIDTH;
        int bottomY = y + height;

        //check if the Ball is between the x values
        if(b.getX() > (x - b.getSize()) && b.getX() < rightX){
            //check if ball is between the y values
            if(b.getY() > y && b.getY() < bottomY){
                //if we get here, we will know the ball and the paddle have collided
                return true;
            }
        }

        //if we get here, it means one of the checks failed, and the ball has not collided.
        return false;

    }


}