package com.thoughtworks.collection;

import javafx.util.Pair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return Collections.max(arrayList);
    }

    public double getMinimum() {
        return Collections.min(arrayList);
    }

    public double getAverage() {
        int sum = 0;
        for (Integer elemI : arrayList) {
            sum += elemI;
        }
        return 1.0 * sum / arrayList.size();
    }

    public double getOrderedMedian() {
        int size = arrayList.size();
        int lastIndex = size - 1;
        if (size % 2 == 1) {
            return arrayList.get(lastIndex / 2);
        } else {
            return (arrayList.get(lastIndex / 2) + arrayList.get(lastIndex / 2 + 1)) / 2.0;
        }
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getFirstEven() {
        Integer rtnI = findFirstEven().getKey();
        return rtnI == null ? -1 : rtnI;
    }

    public int getIndexOfFirstEven() {
        Integer rtnI = findFirstEven().getValue();
        return rtnI == null ? -1 : rtnI;
    }

    private Pair<Integer, Integer> findFirstEven() {
        int index = 0;
        for (Integer elemI : arrayList) {
            if (elemI % 2 == 0) {
                return new Pair<>(elemI, index);
            }
            index++;
        }
        return new Pair<>(null, null);
    }

    public int getLastOdd() {
        Integer rtnI = findLastOdd().getKey();
        // 返回偶数表示不存在奇数
        return rtnI == null ? 0 : rtnI;
    }

    public int getIndexOfLastOdd() {
        Integer rtnI =findLastOdd().getValue();
        return rtnI == null ? -1 : rtnI;
    }

    /**
     * find last odd in the list
     * @return a Pair, Key means the odd, and the Value means the index
     */
    private Pair<Integer, Integer> findLastOdd() {
        int index = arrayList.size() - 1;
        ListIterator<Integer> it = arrayList.listIterator(arrayList.size());
        while (it.hasPrevious()) {
            int elemI = it.previous();
            if (elemI % 2 == 1) {
                return new Pair<>(elemI, index);
            }
            index--;
        }
        return new Pair<>(null, null);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }
}
