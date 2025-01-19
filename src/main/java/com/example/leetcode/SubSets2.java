package com.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SubSets2 {

    public static List<List<Integer>> subsetsWithDup(int[] numbers) {
        List<Integer> numbersList = sorted(toList(numbers));
        Set<List<Integer>> powerSet = getSubSets(numbersList);
        powerSet.add(Collections.emptyList());
        return new ArrayList<>(powerSet);
    }

    private static Set<List<Integer>> getSubSets(List<Integer> numbersList) {
        if (numbersList.size() > 1) {
            Set<List<Integer>> powerSet = new HashSet<>();
            powerSet.add(numbersList);
            for (int i = 0; i < numbersList.size(); i++) {
                List<Integer> tempList = new ArrayList<>(numbersList);
                List<Integer> singletonArrayList = new ArrayList<>();
                singletonArrayList.add(tempList.get(i));
                powerSet.add(singletonArrayList);
                tempList.remove(i);
                powerSet.addAll(getSubSets(tempList));
            }
            return powerSet;
        }
        Set<List<Integer>> returnedSet = new HashSet<>();
        returnedSet.add(numbersList);
        return returnedSet;
    }

    private static List<Integer> sorted(List<Integer> numbersList) {
        return numbersList.stream().sorted().collect(Collectors.toList());
    }

    private static List<Integer> toList(int[] numbers) {
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }

    public static void main (String[] args) {
        int[] arr = {5,4,5,4,3,3,1,1,1,2};
        System.out.println(subsetsWithDup(arr));
    }
}