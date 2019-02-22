package programmers.가운데글자가져오기;

public class Main {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(sub(s));
    }

    public static String sub(String s) {
        int index;
        if(s.length() % 2 == 1) {
            index = s.length() / 2;
            return s.substring(index, index + 1);
        }
        index = s.length() / 2;
        return s.substring(index - 1, index + 1);
    }
}
