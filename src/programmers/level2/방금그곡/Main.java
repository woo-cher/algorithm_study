package programmers.level2.방금그곡;

class Main {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = convertMelody(m);

        for (String info : musicinfos) {
            String[] data = info.split(",");

            int minute = getSubTime(data[0], data[1]);
            String title = data[2];
            String basic = convertMelody(data[3]);

            if (time >= minute) {
                continue;
            }

            if (getAllMelody(basic, minute).contains(m)) {
                answer = title;
                time = minute;
            }
        }

        return answer;
    }

    public static String convertMelody(String original) {
        return original.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }

    public static String getAllMelody(String melody, int minute) {
        StringBuilder result = new StringBuilder();

        int time = 0;
        int i = 0;
        while (time != minute) {
            result.append(melody.charAt(i++));

            if (i == melody.length()) {
                i = 0;
            }

            time++;
        }

        return result.toString();
    }

    public static int getSubTime(String startTime, String endTime) {
        String[] t1 = startTime.split(":");
        String[] t2 = endTime.split(":");

        int hourToMinute = (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0])) * 60;
        return (Integer.parseInt(t2[1]) + hourToMinute) - Integer.parseInt(t1[1]);
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:09,HELLO,ABC#ABC#ABC"}));

        // 노래 끝에 #이 붙은 경우
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,ABC#"}));

        // # 멜로디 일 때
        System.out.println(solution("A#", new String[]{"12:00,12:01,WORLD,A#"}));

        // 재생시간이 짧을 때
        System.out.println(solution("ABCDE", new String[]{"12:00,12:07,HEE,CDEAB"}));

        // 동일한 멜로디, 재생 시간 같을 때
        System.out.println(solution("ABCDE", new String[]{"12:00,12:08,FOO,CDEAB", "13:00,13:08,BAR,CDEAB", "14:00,14:08,BAZ,CDEAB"}));

        // 동일한 멜로디, 재생 시간이 서로 다를 때
        System.out.println(solution("ABCDE", new String[]{"12:00,12:08,FOO,CDEAB", "13:00,13:50,BAR,CDEAB", "14:00,14:25,BAZ,CDEAB"}));
    }
}
