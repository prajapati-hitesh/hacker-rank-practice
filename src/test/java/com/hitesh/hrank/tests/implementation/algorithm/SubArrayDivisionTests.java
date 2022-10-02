package com.hitesh.hrank.tests.implementation.algorithm;

import org.javatuples.Triplet;
import org.testng.annotations.Test;

import java.util.List;

public class SubArrayDivisionTests {

    /**
     * Complete the 'birthday' function below.<br>
     *
     * <b>Constraints :</b>
     * <ul>
     *     <li>1 <= n <= 100</li>
     *     <li>1 <= s[i] <= 5, where 0 <=i < n</li>
     *     <li>1 <= d <= 31</li>
     *     <li>1 <= m <= 12</li>
     * </ul>
     * <p>
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *
     * @param s INTEGER_ARRAY s[n] where n is total number of bars and s[0], s[1]...s[n-1] is value on each square
     * @param d INTEGER d Date of birthday
     * @param m INTEGER m Month of Birthday
     * @return int: the number of ways the bar can be divided
     */
    public int birthday(List<Integer> s, int d, int m) {
        // Total number of square in a bar
        int totalSquaresInABar = s.size();
        int probabilityCounter = 0;

        boolean isValueInSquareInLimit = s.stream().allMatch(e -> e <= 5);
        if (isValueInSquareInLimit
                && totalSquaresInABar <= 100
                && m <= totalSquaresInABar
                && d <= 31
                && m <= 12) {

            // Iterate over list and check whether the sum of sequential is equal to birthday
            for (int i = 0; i < totalSquaresInABar; i++) {
                int remainingLengthOfBar = i + m;
                if (remainingLengthOfBar <= totalSquaresInABar) {
                    int totalOfSubSequentSquares = s.subList(i, remainingLengthOfBar)
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();

                    if (totalOfSubSequentSquares == d) {
                        probabilityCounter++;
                    }
                }
            }

        }
        return probabilityCounter;
    }

    @Test(priority = 0)
    public void barDivisionTest() {
        List<Triplet<List<Integer>, Integer, Integer>> testDataForBar = List
                .of(
                        Triplet.with(List.of(1, 1, 1, 1, 1, 1), 3, 2)
                        , Triplet.with(List.of(4), 4, 1)
                        , Triplet.with(List.of(1, 2, 1, 3, 2), 3, 2)
                        , Triplet.with(List.of(2, 2, 1, 3, 2), 4, 2)
                        , Triplet.with(List.of(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1), 18, 7)
                );

        testDataForBar.forEach(dataValue -> {
            System.out.println(dataValue.getValue0()
                    + " | Birthdate : " + dataValue.getValue1()
                    + " | Month : " + dataValue.getValue2()
                    + " -> Number Of Ways Chocolate can be divided : "
                    + birthday(dataValue.getValue0(), dataValue.getValue1(), dataValue.getValue2())
            );
        });
    }
}
