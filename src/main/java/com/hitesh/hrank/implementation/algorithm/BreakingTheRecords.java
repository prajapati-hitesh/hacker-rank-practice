package com.hitesh.hrank.implementation.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BreakingTheRecords {
    /**
     * Complete the 'breakingRecords' function below.
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     *
     *
     * <a href="https://www.hackerrank.com/challenges/breaking-best-and-worst-records/"> Algorithm > Implementation > Breaking Records</a>
     *
     * @param scores
     * @return An array with the numbers of times she broke her records.
     * Index  is for breaking most points records, and index  is for breaking least points records.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        AtomicInteger lowestScoreCounter = new AtomicInteger();
        AtomicInteger highestScoreCounter = new AtomicInteger();

        List<Integer> lowestScoreList = new ArrayList<>();
        List<Integer> highestScoreList = new ArrayList<>();

        scores.forEach(e -> {
            if (lowestScoreList.isEmpty() && highestScoreList.isEmpty()) {
                lowestScoreList.add(e);
                highestScoreList.add(e);
            } else if (e < lowestScoreList.stream().min(Comparator.naturalOrder()).get()) {
                lowestScoreCounter.getAndIncrement();
                lowestScoreList.add(e);
            } else if (e > highestScoreList.stream().max(Comparator.naturalOrder()).get()) {
                highestScoreCounter.getAndIncrement();
                highestScoreList.add(e);
            }
        });
        System.out.println("Lowest Score : " + lowestScoreList);
        System.out.println("Highest Score : " + highestScoreList);
        return List.of(highestScoreCounter.get(), lowestScoreCounter.get());
    }
}
