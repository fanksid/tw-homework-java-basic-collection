package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Field;
import java.util.List;

public class Add {
    public static void main(String[] args) {
        
    }
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return getSumOfOddsOrEvens(leftBorder, rightBorder, true);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return getSumOfOddsOrEvens(leftBorder, rightBorder, false);

    }

    private int getSumOfOddsOrEvens(int leftBorder, int rightBorder, boolean isGetEvenSum) {
        // make sure that leftBorder <= rightBorder, do this for convenient
        Integer firstI = leftBorder;
        Integer lastI = rightBorder;
        swapIfFirstGreaterThanSecond(firstI, lastI);
        int mod = isGetEvenSum ? 1 : 0;
        if (firstI % 2 == mod) {
            firstI++;
        }
        if (lastI % 2 == mod) {
            lastI--;
        }
        int nEle = (lastI - firstI) / 2 + 1;
        // 等差数列求和
        return (firstI + lastI) * nEle / 2;
    }

    private void swapIfFirstGreaterThanSecond(Integer fistI, Integer secondI) {
        if (fistI == null || secondI == null || fistI <= secondI) {
            return;
        }

        Class intCl = fistI.getClass();
        try {
            Field value = intCl.getDeclaredField("value");
            value.setAccessible(true);
            int tmp = fistI;
            value.setInt(fistI, secondI);
            value.setInt(secondI, tmp);
        } catch (NoSuchFieldException | IllegalAccessException  e) {
            e.printStackTrace();
        }
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
