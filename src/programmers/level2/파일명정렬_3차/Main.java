package programmers.level2.파일명정렬_3차;

import java.util.Arrays;

public class Main {
    public static String[] solution(String[] files) {
        String[] answer = {};

        answer = Arrays.stream(files).sorted((s1, s2) -> {
            File f1 = getFileAfterDivide(s1);
            File f2 = getFileAfterDivide(s2);

            if (!f1.head.equalsIgnoreCase(f2.head)) { // not equals `HEAD`
                return f1.head.compareToIgnoreCase(f2.head);
            }

            if (f1.number != f2.number) { // equals `HEAD`, not equals `NUMBER`
                return Integer.compare(f1.number, f2.number);
            }

            return 0; // equals `HEAD`, equals `NUMBER`
        }).toArray(String[]::new);

        return answer;
    }

    /**
     * convert str to File(HEAD, NUMBER, TAIL)
     */
    public static File getFileAfterDivide(String str) {
        int i = 0, size = 0, start = 0;

        while (i != str.length()) {
            if (size == 5) {
                break;
            }

            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                if (size == 0) {
                    start = i;
                }

                size++;
            } else if (size != 0) {
                break;
            }

            i++;
        }

        int end = start + size;

        return new File(str.substring(0, start), Integer.parseInt(str.substring(start, end)));
    }

    public static void main(String[] args) {
        System.out.println(getFileAfterDivide("foo123450123"));
        System.out.println(getFileAfterDivide("f-A.b00003444444"));
        System.out.println(getFileAfterDivide("abc123defg123.jpg"));
        System.out.println(getFileAfterDivide("f1"));
        System.out.println(getFileAfterDivide("F0010"));
        System.out.println(getFileAfterDivide("foo.a-s.d122.zip"));
        System.out.println(getFileAfterDivide("foo.a-s.d122.zip"));
        System.out.println("a".compareToIgnoreCase("b"));

        System.out.println(Arrays.toString(
                solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}))
        );

        System.out.println(Arrays.toString(
                solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}))
        );

        System.out.println(Arrays.toString(
                solution(new String[]{"muzi1.txt", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"}))
        );

        System.out.println(Arrays.toString(
                solution(new String[]{"ABC12", "AbC12", "aBc12"}))
        );
    }
}

class File {
    String head;
    int number;

    public File(String head, int number) {
        this.head = head;
        this.number = number;
    }

    @Override
    public String toString() {
        return "File{" +
                "head='" + head + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
