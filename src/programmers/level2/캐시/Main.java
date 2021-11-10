package programmers.level2.캐시;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toUpperCase();

            // 캐시 여분 공간이 있을 때
            if (cache.size() < cacheSize) {
                if (cache.contains(city)) { // cache hit
                    cache.remove(city);
                    answer += 1;
                } else { // cache miss
                    answer += 5;
                }

                cache.add(city);
                continue;
            }

            // 캐시가 가득 찼을 때
            if (cache.contains(city)) { // cache hit
                answer += 1;
                cache.remove(city);
            } else { // cache miss
                answer += 5;
                cache.remove(0);
            }

            cache.add(city);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
