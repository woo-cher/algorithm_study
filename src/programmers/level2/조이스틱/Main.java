package programmers.level2.조이스틱;

/**
 *   현재 위치한 커서를 기준으로, 가장 가까운 목표를 탐색하도록 함
 *  만약, 좌측 커서를 이용해서 맨 마지막 문자로 커서를 옮긴 경우
 *  한 번의 커서 이동으로 다시 끝문자 -> 첫문자로 갈 수 없기 때문에 findOnlyReverse() 함수를 구현함
 */
public class Main {
    static boolean[] check;

    public static int solution(String name) {
        int answer = 0;

        Joystick joy = new Joystick();
        check = new boolean[name.length()];

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                check[i] = true;
            }
        }

        while (true) {
            if (joy.target == -1) {
                break;
            }

            answer += joy.move(name);
            joy.cursor = joy.target;

            if (!check[joy.cursor]) {
                check[joy.cursor] = true;
                char c = name.charAt(joy.cursor);
                answer += joy.changeAlpha(c);
            }

            joy.target = joy.isReverse ?
                    joy.findOnlyReverse(check) : joy.find(check);
        }

        return answer;
    }

    public static void main(String[] args) {
        String name = "JEROEN";
        String name2 = "ABAAAAAAAAABB";
        String name3 = "JAN";
        String name4 = "JAZ";
        String name5 = "ZAAAZZZZZZZ";

        System.out.println(name + " : " + solution(name));
//        System.out.println(name2 + " : " + solution(name2));
//        System.out.println(name3 + " : " + solution(name3));
//        System.out.println(name4 + " : " + solution(name4));
//        System.out.println(name5 + " : " + solution(name5));
    }
}

class Joystick {
    public int cursor;
    public int target;
    public boolean isReverse;

    public Joystick() {
        this.cursor = 0;
        this.target = 0;
        this.isReverse = false;
    }

    public int findOnlyReverse(boolean[] check) {
        for (int i = cursor; i >= 0; i--) {
            if (!check[i]) {
                return i;
            }
        }

        return -1;
    }

    public int find(boolean[] check) {
        int direct = 0;
        int reverse = this.cursor == 0 ? 1 : 2;
        int tmp1 = -1;
        int tmp2 = -1;

        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                direct = Math.abs(this.cursor - i);
                tmp1 = i;
                break;
            }
        }

        for (int i = check.length - 1; i >= 0; i--) {
            if (!check[i]) {
                reverse += (check.length - 1 - i);
                tmp2 = i;
                break;
            }
        }

        if (direct <= reverse) {
            return tmp1;
        }

        return tmp2;
    }

    public int move(String name) {
        int direct = Math.abs(this.target - this.cursor);
        int back = this.cursor == 0 ? 1 : 2; // If now is not '0', press left

        back += (name.length() - 1 - this.target);

        if (direct > back) {
            this.isReverse = true;
        }

        return Math.min(direct, back);
    }

    public int changeAlpha(char target) {
        int direct = Math.abs('A' - target);
        int back = ('Z' - target) + 1; // Using Left

        return Math.min(direct, back);
    }
}
