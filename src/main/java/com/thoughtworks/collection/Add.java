package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Add {
//    public static void main(String[] args) {
//
//    }
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
        // TODO: remove swapIfFirstGreaterThanSecond(firstI, lastI);
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
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        return 3 * sum + 2 * arrayList.size();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> arrayListRtn = new ArrayList<>(arrayList);
        for (int i = 0; i < arrayListRtn.size(); i++) {
            int val;
            if ((val = arrayListRtn.get(i)) % 2 == 0) {
                continue;
            }
            arrayListRtn.set(i, 3 * val + 2);
        }
        return arrayListRtn;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            if (integer % 2 == 0) {
                continue;
            }
            sum += integer * 3 + 5;
        }
        return sum;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> arrayListRtn = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            int first  = arrayList.get(i - 1);
            int second = arrayList.get(i);
            arrayListRtn.add((first + second) * 3);
        }
        return arrayListRtn;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> arrayListEven = new ArrayList<>();
        for (Integer integer : arrayList) {
            if (integer % 2 == 1) {
                continue;
            }
            arrayListEven.add(integer);
        }

        int size = arrayListEven.size();
        int lastIndex = size - 1;

        if (size % 2 == 1) {
            return arrayListEven.get(lastIndex / 2);
        } else {
            return (arrayListEven.get(lastIndex / 2) + arrayListEven.get(lastIndex / 2 + 1)) / 2;
        }
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        int cnt = 0;
        int sum = 0;

        for (Integer integer : arrayList) {
            if (integer % 2 == 1) {
                continue;
            }
            cnt++;
            sum += integer;
        }
        return sum / cnt;
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
}
