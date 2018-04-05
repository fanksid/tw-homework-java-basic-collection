package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

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
        if (leftBorder > rightBorder) {
            // swap
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }
        int mod = isGetEvenSum ? 1 : 0;
        if (leftBorder % 2 == mod) {
            leftBorder++;
        }
        if (rightBorder % 2 == mod) {
            rightBorder--;
        }
        int nEle = (rightBorder - leftBorder) / 2 + 1;
        // 等差数列求和
        return (leftBorder + rightBorder) * nEle / 2;
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
        // 对退化的情况进行优化
        if (specialElment % 2 == 1) {
            return false;
        }
        // TODO: refactor all foreach variable `integer` to `elementI`
        for (Integer integer : arrayList) {
            if (integer.equals(specialElment)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> arrayListUnrepeated = new ArrayList<>();
        for (Integer elemI : arrayList) {
            if (elemI % 2 == 1) {
                continue;
            }
            if (!arrayListUnrepeated.contains(elemI)) {
                arrayListUnrepeated.add(elemI);
            }
        }
        return arrayListUnrepeated;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        // TODO: get understand difference between List with ArrayList and their initialization
        List<Integer> arrayListEven = new ArrayList<>();
        List<Integer> arrayListOdd = new ArrayList<>();

        for (Integer elemI : arrayList) {
            if (elemI % 2 == 1) {
                arrayListOdd.add(elemI);
            } else {
                arrayListEven.add(elemI);
            }
        }

        arrayListEven.sort(null);
        arrayListOdd.sort((first, second) -> second - first);

        List<Integer> arrayListRtn = new ArrayList<>(arrayListEven);
        arrayListRtn.addAll(arrayListOdd);
        return arrayListRtn;
    }
}
