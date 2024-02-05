/**
 * 맛보기 프로그램 구현
 * 사칙연산이 가능한 계산기
 * 덧셈(add)
 * 뺄셈(subtract)
 * 곱셈(multiply)
 * 나눗셈(divide)
 * 위 4개의 기능을 구현하고 main method를 활용해 테스트한다.
 */
public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }
}
