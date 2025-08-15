package assignment.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import assignment.book.entity.Magazine;
import assignment.book.entity.Novel;
import assignment.book.entity.Publication;
import assignment.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // 1) 출판물 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPrices.put(type, totalPrices.getOrDefault(type, 0) + pub.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averages = new HashMap<>();
        for (String type : totalPrices.keySet()) {
            averages.put(type, totalPrices.get(type) / (double) counts.get(type));
        }
        return averages;
    }

    // 2) 출판물 유형 분포(백분율) 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : counts.keySet()) {
            double percentage = (counts.get(type) / (double) total) * 100;
            distribution.put(type, percentage);
        }
        return distribution;
    }

    // 3) 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            String pubYear = pub.getPublishDate().substring(0, 4); // yyyy-mm-dd에서 연도 추출
            if (pubYear.equals(year)) {
                count++;
            }
        }
        return (count / (double) publications.length) * 100;
    }

    // 4) 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    // 5) 통계 정보 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("=== 출판물 통계 ===");

        // 타입별 평균 가격
        System.out.println("\n[타입별 평균 가격]");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (String type : avgPrices.keySet()) {
            System.out.println(type + ": " + df.format(avgPrices.get(type)) + "원");
        }

        // 출판물 유형 분포
        System.out.println("\n[출판물 유형 분포]");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.println(type + ": " + df.format(distribution.get(type)) + "%");
        }

        // 2007년도 출판 비율
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n[2007년도 출판물 비율]");
        System.out.println(df.format(ratio2007) + "%");
    }
}
