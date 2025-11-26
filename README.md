#🎮 Pong
A classic remake of the original Pong, just like the early days of Atari, built entirely in Java with Swing. Control your paddle on the left while going against the AI on the other side. Ball speed increases as the game progresses, making each rally more intense than the last.

##🛠️ Technology
- Java (JDK 8+)
- Java Swing

##🚀 Features
- Player-controlled paddle on the left (move up/down)
- AI-controlled paddle on the right, which reacts to the ball’s position
- Ball bounces off top/bottom edges - misses result in points
- Ball speed increases after a set number of bounces for rising difficulty
- Simple, lightweight, no external libraries required, only Java

##🧠 The Process
This was my first project using Java outside of school, and I wanted to familiarise myself with Java’s GUI capabilities and test my ability to develop games through basic game logic. I didn’t want the entire Pong code to run on one page, as that can be very messy and dense, so the project is structured into four main classes:
- `Ball.java` - handles ball position, movement, bounce logic and speed acceleration in relation to the bounce thresholds.
- `Paddle.java` - defines paddle properties (position, size, speed, collision detection) and handles paddle movement for both the player and AI.
- `PongGame.java` - game loop, rendering, collision detection, scoring, speed escalation.
- `Main.java` - sets up game window (JFrame), game engine initialisation, activates loop with Swing timer

With this separation, each class will only have one responsibility to focus on, so if there is any need to extend or fix any part of the code, it would be easier.

##📦 Running the Project
1. Clone the repository
2. Compile the files
3. Run game

Alternatively, if you prefer running on an IDE:
1. Open the folder in any Java-compatible IDE (e.g. IntelliJ IDEA, Eclipse)
2. Make sure JDK is installed
3. Run `Main.java` directly

##**🎮 How to Play**
- Player (Left Paddle): Use **W** (up) and **S** (down) keys
- AI (Right Paddle): Controlled by the program automatically
- First to miss the ball gives a point to the opponent. The ball then resets and continues
- After a number of bounces, the ball speed increases
