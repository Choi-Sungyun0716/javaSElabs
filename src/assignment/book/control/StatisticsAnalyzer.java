package assignment.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import assignment.book.entity.Magazine;
import assignment.book.entity.Novel;
import assignment.book.entity.Publication;
import assignment.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // 1) ���ǹ� Ÿ�Ժ� ��� ���� ���
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

    // 2) ���ǹ� ���� ����(�����) ���
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

    // 3) Ư�� ���� ���ǹ� ���� ���
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            String pubYear = pub.getPublishDate().substring(0, 4); // yyyy-mm-dd���� ���� ����
            if (pubYear.equals(year)) {
                count++;
            }
        }
        return (count / (double) publications.length) * 100;
    }

    // 4) ���ǹ� Ÿ�� Ȯ�� ���� �޼���
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "�Ҽ�";
        } else if (pub instanceof Magazine) {
            return "����";
        } else if (pub instanceof ReferenceBook) {
            return "����";
        } else {
            return "��Ÿ";
        }
    }

    // 5) ��� ���� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("=== ���ǹ� ��� ===");

        // Ÿ�Ժ� ��� ����
        System.out.println("\n[Ÿ�Ժ� ��� ����]");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (String type : avgPrices.keySet()) {
            System.out.println(type + ": " + df.format(avgPrices.get(type)) + "��");
        }

        // ���ǹ� ���� ����
        System.out.println("\n[���ǹ� ���� ����]");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.println(type + ": " + df.format(distribution.get(type)) + "%");
        }

        // 2007�⵵ ���� ����
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n[2007�⵵ ���ǹ� ����]");
        System.out.println(df.format(ratio2007) + "%");
    }
}
