import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5.x 버전
 * 애노테이션(Annotation)을 활용해 테스트 코드 구현
 * @Test
 * @BeforeEach, @AfterEach
 * Assertions 클래스의 static assert method를 활용해 테스트 결과 검증
 */
class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void 덧셈() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void 뺄셈() {
        assertEquals(1, calculator.subtract(5,  4));
    }

    @Test
    public void 곱셈() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    public void 나눗셈() {
        assertEquals(2, calculator.divide(10, 5 ));
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}