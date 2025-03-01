# Pong
A traditional Pong game just like the early days of the Atari developed completely with Java.

### Features
- Players control a paddle on the left side moving it up and down
- AI paddle on the right side will do the same

## Pages
Entire project uses 4 pages to run: Ball.java, Main.java, Paddle.java, PongGame.java.
### Ball.java
Class for the ball in the game.
- Instance of ball values are all set here such as the speed, x and y positions.
- Colour of ball is also set here.
- increaseSpeed function is inside so as after each bouce, the speed that the ball is travelling increases.
- function bounceOffEdges is set so that the ball only bounces at the top and bottom edges, anything else should considered a point on either player or cpu side.

### Main.java
Entry point for Pong game.
- JFrame is initialized with the title 'Pong'
- 650x495 pixel size set however you can adjust it to however big you want.
- Instance of PongGame is called here
- Swing timer used to update Pong game ever 33 milliseconds

### Paddle.java
Defines paddle mechanics for the Pong game. Deals with paddle movement, collision detection, and rendering.
- Paddle properties help determine position, size, speed and color
- paint(Graphios g) method renders paddle on screen with g.fillRect()
- moveTowards(int targetY) method moves the paddle smoothly towards a target position (applied for both player and pc)
- checkCollision(ball B) checks if ball collides with the paddle. collision occurs = return true leading to change in direction.

### PongGame.java
Core game engine of the Pong game. Manages the game loop, rendering, collision detection, scoring, and difficulty progression.
- gameLogic() handles ball movement, edge bouncing, player and cpu movement, collision detection and score handling.
- After every score, reset() is called everytime
- Every bounce count is tracked to increase speed (every 5 bounce = increaseSpeed())
- Player controls paddle using mouse's Y position
- AI paddle followes the ball's Y position