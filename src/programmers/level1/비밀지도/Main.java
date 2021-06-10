package programmers.level1.비밀지도;

public class Main {
    public static void main(String[] args) {
//        System.out.println(convertNumToBinaryString(9, 5));
//        System.out.println(getPath("10100", "00001"));

        String[] arr = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});

        for(String s : arr) {
            System.out.println(s);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        int size = arr1.length;
        String[] paths = new String[size];

        // convert to binary
        for (int i = 0; i < size; i++) {
            String binary1 = convertNumToBinaryString(arr1[i], n);
            String binary2 = convertNumToBinaryString(arr2[i], n);

            paths[i] = getPath(binary1, binary2);
        }

        return paths;
    }

    public static String convertNumToBinaryString(int num, int length) {
        String binary = "";

        while (true) {
            if (num == 0) {
                break;
            }

            binary = (num % 2) + binary;
            num = num / 2;
        }

        while (true) {
            if (binary.length() == length) {
                break;
            }

            binary = "0" + binary;
        }

        return binary;
    }

    public static String getPath(String binary1, String binary2) {
        String path = "";
        int size = binary1.length();

        for(int i = 0; i < size; i++) {
            if (binary1.charAt(i) == binary2.charAt(i)) {
                path += binary1.charAt(i) == '1' ? "#" : " ";
            } else {
                path += "#";
            }
        }

        return path;
    }
}
