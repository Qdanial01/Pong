import java.awt.*;

public class Ball {

    static final int MAX_SPEED = 7;

        //declare instance variable
    private int x, y, cx, cy, speed, size;
    private Color color;

        //ball constructor assigns values to instance variables
    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size){
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }

    public void paint(Graphics g){
        //set the brush color to the ball color
        g.setColor(color);

        //paint the ball at x, y with a width and height of the ball size
        g.fillOval(x, y, size, size);
    }

    public void moveBall(){
        x += cx;
        y += cy;
    }

    public void bounceoffEdges(int top, int bottom){
        if(y > bottom - size){
            reverseY();
        }

        else if(y < top){
            reverseY();
        }
    }

    /**
     * Reverse's the ball's change in x value
     */
    public void reverseX(){
        cx *= -1;
    }

    /**
     * Reverse's the ball's change in y value
     */

    public void reverseY(){
        cy *= -1;
    }

    public void increaseSpeed(){
        //make sure current speed is less than max speed before incrementing
        if(speed < MAX_SPEED){
            //increase the speed by one
            speed ++;

            //update cy and cx with the new speed
            cx = (cx / Math.abs(cx)*speed);
            cy = (cy / Math.abs(cy)*speed);
        }
    }

    //getter in ball class
    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public int getSize(){
        return size;
    }


    //Set reset
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setCx(int cx) {
        this.cx = cx;
    }
    
    public void setCy(int cy) {
        this.cy = cy;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    

}