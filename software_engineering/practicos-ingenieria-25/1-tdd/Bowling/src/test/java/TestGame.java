import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame{

    private static Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }


// Helper method para tirar varias veces el mismo número de pinos
    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            Game.Roll(pins);
        }
    }

    @Test
    public void testForScore(){

        Game.Roll(5);
        Game.Roll(2);

        assertEquals(Game.Score(),7);

    }

    @Test
    public void testForNormalTurno(){

        Game.jugarTurno(0,9,1);

        rollMany(17, 0);

        assertEquals(10, Game.Score());
    }

    @Test   
    public void testForSpare(){

        Game.jugarTurno(0, 6, 4); //6+4 = 10, spare. 
        Game.jugarTurno(1, 3, 4);

        assertEquals(Game.turnos[0].scoreTurno, 13);

    }

    @Test
    public void testForStrike(){

        Game.jugarTurno(0, 10, 0); //strike. 
        Game.jugarTurno(1, 3, 4);

        assertEquals(Game.turnos[0].scoreTurno, 17);

    }
}
