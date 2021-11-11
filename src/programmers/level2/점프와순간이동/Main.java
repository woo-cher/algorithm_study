package programmers.level2.점프와순간이동;

/**
 *  문제와 다른 접근 개념으로, 도착점부터 출발점으로 이동해본다.
 *  도착점에서, 2를 계속 나눠가며 순간이동을 한다. 만약, 2로 나누어지지 않는 구간이라면 홀수 구간이다.
 *  이 구간에서, 1을 빼어준다. ( 건전지 1 사용 )
 *  그렇다면, 다시 2로 나눌 수 있는데까지 순간이동 한다.
 *  위 과정을, 1인 지점에 도달할 때 까지 반복한다.
 *  만약 위치1 이라면 건진지 사용값에 + 1을 리턴한다. 시작을 위해서 건전지 1을 무조건 사용해야 하기 때문.
 */
public class Main {
    public static int solution(int n) {
        int ans = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }

            n = (n - 1) / 2;
            ans++;
        }

        return ans + 1;
    }

    public static void main(String[] args) {

    }
}
