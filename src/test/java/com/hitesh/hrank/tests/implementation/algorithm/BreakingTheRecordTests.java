package com.hitesh.hrank.tests.implementation.algorithm;

import com.hitesh.hrank.implementation.algorithm.BreakingTheRecords;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Hitesh Prajapati
 */
public class BreakingTheRecordTests {

    @Test
    public void breakingTheRecordUnitTests() {
        System.out.print("First Result\t:");
        BreakingTheRecords.breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1)).forEach(e -> {
            System.out.print("\t" + e);
        });
        System.out.print("\nSecond Result\t:");
        BreakingTheRecords.breakingRecords(List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)).forEach(e -> {
            System.out.print("\t" + e);
        });
    }
}
