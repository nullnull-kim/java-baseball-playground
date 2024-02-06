import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

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

    /**
     * 요구사항
     * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     *
     * 힌트
     * 문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.
     */
    @ParameterizedTest
    @CsvSource(value={"2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String value, Integer excepted) {
//        Scanner scanner = new Scanner(System.in);

//        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int current = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i++, i++) {
            if (values[i].equals("+")) {
                current = current + Integer.parseInt(values[i + 1]);
            } else if (values[i].equals("-")) {
                current = current - Integer.parseInt(values[i + 1]);
            } else if (values[i].equals("*")) {
                current = current * Integer.parseInt(values[i + 1]);
            } else if (values[i].equals("/")) {
                current = current / Integer.parseInt(values[i + 1]);
            } else {
                System.err.println("err");
            }
        }

        Assertions.assertEquals(current, excepted);
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}