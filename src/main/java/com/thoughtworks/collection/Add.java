package com.thoughtworks.collection;

import java.util.*;

public class Add {
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

    //todo excellent work! try java 8 lambda!
    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (Integer elemI : arrayList) {
            sum += elemI;
        }
        return 3 * sum + 2 * arrayList.size();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> arrayListRtn = new ArrayList<>();
        for (Integer elemI : arrayList) {
            arrayListRtn.add(elemI % 2 == 0 ? elemI : (elemI * 3 + 2));
        }
        return arrayListRtn;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (Integer elemI : arrayList) {
            if (elemI % 2 == 0) {
                continue;
            }
            sum += elemI * 3 + 5;
        }
        return sum;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> arrayListRtn = new ArrayList<>();
        boolean isFirst = true;
        int preNum = 0;
        for (Integer elemI : arrayList) {
            if (isFirst) {
                preNum = elemI;
                isFirst = false;
                continue;
            }
            arrayListRtn.add((elemI + preNum) * 3);
            preNum = elemI;
        }
        return arrayListRtn;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> arrayListEven = new ArrayList<>();
        for (Integer elemI : arrayList) {
            if (elemI % 2 == 1) {
                continue;
            }
            arrayListEven.add(elemI);
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

        for (Integer elemI : arrayList) {
            if (elemI % 2 == 1) {
                continue;
            }
            cnt++;
            sum += elemI;
        }
        return 1.0 * sum / cnt;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        // 对退化的情况进行优化
        if (specialElment % 2 == 1) {
            return false;
        }

        for (Integer elemI : arrayList) {
            if (elemI.equals(specialElment)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        // 空间换时间，引入set降低查找时间，复杂度O(nlogn)
        List<Integer> arrayListUnrepeated = new ArrayList<>();
        Set<Integer> setContains = new HashSet<>();
        for (Integer elemI : arrayList) {
            if (elemI % 2 == 1) {
                continue;
            }
            if (!setContains.contains(elemI)) {
                setContains.add(elemI);
                arrayListUnrepeated.add(elemI);
            }
        }
        return arrayListUnrepeated;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
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
        arrayListOdd.sort(Comparator.reverseOrder());

        List<Integer> arrayListRtn = new ArrayList<>(arrayListEven);
        arrayListRtn.addAll(arrayListOdd);
        return arrayListRtn;
    }
}
