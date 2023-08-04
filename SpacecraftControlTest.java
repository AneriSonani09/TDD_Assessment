import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpacecraftControlTest {
    private SpacecraftControl spacecraft;

    @BeforeEach
    public void setup() {
        Point startingPoint = new Point(0, 0, 0);
        Direction initialDirection = Direction.N;
        spacecraft = new SpacecraftControl(startingPoint, initialDirection);
    }

    @Test
    public void testExampleCommands() {
        char[] commands = {'f', 'r', 'u', 'b', 'l'};
        spacecraft.executeCommands(commands);

        Point finalPosition = spacecraft.getFinalPosition();
        Direction finalDirection = spacecraft.getFinalDirection();

        Assertions.assertEquals(0, finalPosition.getX());
        Assertions.assertEquals(1, finalPosition.getY());
        Assertions.assertEquals(-1, finalPosition.getZ());
        Assertions.assertEquals(Direction.W, finalDirection);
    }
}
