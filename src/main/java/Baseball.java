import java.util.*;

/**
 * 기능 요구 사항
 * 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
 *
 * 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
 * e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
 * 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
 * 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
 * **********************************************************************************************
 * 프로그래밍 요구사항
 * 자바 코드 컨벤션을 지키면서 프로그래밍한다.
 * 기본적으로 Google Java Style Guide을 원칙으로 한다.
 * 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
 * indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
 * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
 * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
 * else 예약어를 쓰지 않는다.
 * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
 * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
 * 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
 * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
 * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
 * 3항 연산자를 쓰지 않는다.
 * 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
 * 기능 목록 및 commit 로그 요구사항
 * 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
 */
public class Baseball {

    public int inputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        return scanner.nextInt();
    }

    public int createAnswer() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();
        int result = 0;


        while (uniqueNumbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1; // 100 이상 999 이하의 난수 발생
            uniqueNumbers.add(randomNumber);
        }

        List<Integer> integers = new ArrayList<>(uniqueNumbers);

        result += integers.get(0) * 100;
        result += integers.get(1) * 10;
        result += integers.get(2);

        return result;
    }

    public int checkStrike(int expect, int answer) {
        int count = 0;
        if(expect / 100 == answer / 100) count++;
        if((expect/10)%10 == (answer/10)%10) count++;
        if(expect%10 == answer%10) count++;

        return count;
    }

    public int checkBall(int expect, int answer) {
        int count = 0;
        if(expect / 100 == (answer/10)%10) count++;
        if(expect / 100 == answer%10) count++;
        if((expect/10)%10 == answer / 100) count++;
        if((expect/10)%10 == answer%10) count++;
        if(expect%10 == answer / 100) count++;
        if(expect%10 == (answer/10)%10) count++;

        return count;
    }

    public void ResultView(int ball, int strike) {
        if(ball != 0) System.out.print(ball + "볼 ");
        System.out.println(strike + "스트라이크");
    }
    // 숫자 입력받기
    // 숫자 판별
    // 종료되었는가 Y
}