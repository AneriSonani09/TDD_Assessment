public class SpacecraftControl {
    private Point currentPosition;
    private Direction currentDirection;

    public SpacecraftControl(Point initialPoint, Direction initialDirection) {
        currentPosition = initialPoint;
        currentDirection = initialDirection;
    }

    public void move(char command) {
        switch (command) {
            case 'f':
                moveForward();
                break;
            case 'b':
                moveBackward();
                break;
            case 'l':
                turnLeft();
                break;
            case 'r':
                turnRight();
                break;
            case 'u':
                turnUp();
                break;
            case 'd':
                turnDown();
                break;
            default:
                System.out.println("Invalid command: " + command);
                break;
        }
    }

    public void executeCommands(char[] commands) {
        for (char command : commands) {
            move(command);
        }
    }

    public Point getFinalPosition() {
        return currentPosition;
    }

    public Direction getFinalDirection() {
        return currentDirection;
    }

    private void moveForward() {
        switch (currentDirection) {
            case N:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getZ());
                break;
            case S:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getZ());
                break;
            case E:
                currentPosition = new Point(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getZ());
                break;
            case W:
                currentPosition = new Point(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getZ());
                break;
            case Up:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY(), currentPosition.getZ() + 1);
                break;
            case Down:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY(), currentPosition.getZ() - 1);
                break;
        }
    }

    private void moveBackward() {
        switch (currentDirection) {
            case N:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY() - 1, currentPosition.getZ());
                break;
            case S:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY() + 1, currentPosition.getZ());
                break;
            case E:
                currentPosition = new Point(currentPosition.getX() - 1, currentPosition.getY(), currentPosition.getZ());
                break;
            case W:
                currentPosition = new Point(currentPosition.getX() + 1, currentPosition.getY(), currentPosition.getZ());
                break;
            case Up:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY(), currentPosition.getZ() - 1);
                break;
            case Down:
                currentPosition = new Point(currentPosition.getX(), currentPosition.getY(), currentPosition.getZ() + 1);
                break;
        }
    }

    private void turnLeft() {
        switch (currentDirection) {
            case N:
                currentDirection = Direction.W;
                break;
            case S:
                currentDirection = Direction.E;
                break;
            case E:
                currentDirection = Direction.N;
                break;
            case W:
                currentDirection = Direction.S;
                break;
        }
    }

    private void turnRight() {
        switch (currentDirection) {
            case N:
                currentDirection = Direction.E;
                break;
            case S:
                currentDirection = Direction.W;
                break;
            case E:
                currentDirection = Direction.S;
                break;
            case W:
                currentDirection = Direction.N;
                break;
        }
    }

    private void turnUp() {
        if (currentDirection != Direction.Up)
            currentDirection = Direction.Up;
    }

    private void turnDown() {
        if (currentDirection != Direction.Down)
            currentDirection = Direction.Down;
    }
}
