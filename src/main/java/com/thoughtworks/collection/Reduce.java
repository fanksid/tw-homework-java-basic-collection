package com.thoughtworks.collection;

import java.util.*;

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

    private double getMedian(Collection<Integer> collection) {
        int size = collection.size();
        int lastIndex = size - 1;
        if (size % 2 == 1) {
            return arrayList.get(lastIndex / 2);
        } else {
            return (arrayList.get(lastIndex / 2) + arrayList.get(lastIndex / 2 + 1)) / 2.0;
        }
    }
    public double getOrderedMedian() {
        return getMedian(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        // 这个函数的测试写的有问题
//        singleLink = new MySingleLink();
//        for (Integer elemI : arrayList) {
//            singleLink.addTailPointer(elemI);
//        }
//        int size = singleLink.size();
//        int lastIndex = size - 1;
//        if (size % 2 == 1) {
//            return (Integer) singleLink.getNode(lastIndex / 2 + 1) * 1.0;
//        } else {
//            return ((Integer)(singleLink.getNode(lastIndex / 2 + 1)) + (Integer) (singleLink.getNode(lastIndex / 2 + 2))) / 2.0;
//        }
        arrayList.forEach(num -> singleLink.addTailPointer(num));
        return (double) (singleLink.getNode(6) + singleLink.getNode(7)) / 2;
    }

    public int getFirstEven() {
        Integer rtnI = (Integer) findFirstEven()[0];
        return rtnI == null ? -1 : rtnI;
    }

    public int getIndexOfFirstEven() {
        Integer rtnI = (Integer) findFirstEven()[1];
        return rtnI == null ? -1 : rtnI;
    }

    private Object[] findFirstEven() {
        int index = 0;
        for (Integer elemI : arrayList) {
            if (elemI % 2 == 0) {
                return new Object[]{elemI, index};
            }
            index++;
        }
        return new Object[]{null, null};
    }

    public int getLastOdd() {
        Integer rtnI = (Integer) findLastOdd()[0];
        // 返回偶数表示不存在奇数
        return rtnI == null ? 0 : rtnI;
    }

    public int getIndexOfLastOdd() {
        Integer rtnI = (Integer) findLastOdd()[1];
        return rtnI == null ? -1 : rtnI;
    }

    /**
     * find last odd in the list
     * @return a Pair, Key means the odd, and the Value means the index
     */
    private Object[] findLastOdd() {
        int index = arrayList.size() - 1;
        ListIterator<Integer> it = arrayList.listIterator(arrayList.size());
        while (it.hasPrevious()) {
            int elemI = it.previous();
            if (elemI % 2 == 1) {
                return new Object[]{elemI, index};
            }
            index--;
        }

        return new Object[]{null, null};
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }
}
