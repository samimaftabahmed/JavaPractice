package org.samim.misc;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created this as a demo code in order to solve the problem of distributing almost equal number of elements across
 * partitions, while partitioning with a fixed number of partitions.
 */
public class EqualPartitionCreator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total elements: ");
        int totalElements = scanner.nextInt();
        System.out.print("Enter desired number of partitions: ");
        int maxPartitions = scanner.nextInt();
        List<Integer> inputList = new ArrayList<>(totalElements);
        IntStream.range(0, totalElements).forEach(inputList::add);

        List<Integer> subListFirst = inputList;
        int threshold = 1;
        List<Integer> subListLast = null;
        if (totalElements > maxPartitions) {
            int remainder = totalElements % maxPartitions;
            int difference = totalElements - remainder;
            threshold = difference / maxPartitions;
            System.out.println("Remainder: " + remainder);
            System.out.println("Threshold: " + threshold);

            subListFirst = inputList.subList(0, difference);
            System.out.println("sublist 1st: " + subListFirst.size());

            if (remainder > 0) {
                subListLast = inputList.subList(difference, totalElements);
                System.out.println("sublist 2nd: " + subListLast.size());
            }
        }

        List<List<Integer>> nonModifiablePartitions = Lists.partition(subListFirst, threshold);
        List<List<Integer>> finalPartitions = new ArrayList<>(nonModifiablePartitions);
        System.out.println("Partitions: " + finalPartitions.size());

        if (subListLast != null) {
            for (int j = 0; j < subListLast.size(); j++) {
                Integer item = subListLast.get(j);
                List<Integer> newPartition = new ArrayList<>(finalPartitions.get(j));
                newPartition.add(item);
                finalPartitions.set(j, newPartition);
            }
        }

        for (int i = 0; i < finalPartitions.size(); i++) {
            System.out.println("Partition " + (i + 1) + " size: " + finalPartitions.get(i).size());
        }
    }

}
