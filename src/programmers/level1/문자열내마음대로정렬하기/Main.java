package programmers.level1.문자열내마음대로정렬하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] str = {"abce", "abcd", "cdx"};
        str = sub(str, 2);
        for (String s : str) {
            System.out.print(s + " ,");
        }
    }

    public static String[] sub(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].charAt(n) > strings[j].charAt(n)) {
                    swap(strings, i, j);

                } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
                    if (strings[i].compareTo(strings[j]) > 0) {
                        swap(strings, i, j);
                    }
                }
            }
        }
        return strings;
    }

    public static void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    /**
     * Test
     */
    public static String[] sub2(String[] strings, int n) {
        return Arrays.stream(strings)
                .map(string -> new IndexString(string, n)).sorted()
                .map(indexString -> indexString.string)
                .toArray(String[]::new);
    }

    static class IndexString implements Comparable<IndexString> {
        String string;
        char index;

        IndexString(String string, int index) {
            this.string = string;
            this.index = string.charAt(index);
        }

        @Override
        public int compareTo(IndexString indexString) {
            System.out.println(index + "," + indexString.index);
            if (index == indexString.index) {
                return string.compareTo(indexString.string);
            } else {
                return index = indexString.index;
            }
        }
    }
}
