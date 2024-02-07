import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    Baseball baseball;

    @BeforeEach
    void setup() {
        baseball = new Baseball();
    }

    @Test
    void checkStrike() {
        int answer = 726;
        assertEquals(baseball.checkStrike(123, answer), 1);
        assertEquals(baseball.checkStrike(234, answer), 0);
        assertEquals(baseball.checkStrike(456, answer), 1);
        assertEquals(baseball.checkStrike(726, answer), 3);
    }

    @Test
    void checkBall() {
        int answer = 123;
        assertEquals(baseball.checkBall(231, answer), 3);
        assertEquals(baseball.checkBall(123, answer), 0);
    }

    @AfterEach
    void tearDown() {
        baseball = null;
    }
}