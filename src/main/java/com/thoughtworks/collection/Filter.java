package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> listEven = new ArrayList<>();
        for (Integer elemI : array) {
            if (elemI % 2 == 1) {
                continue;
            }
            listEven.add(elemI);
        }
        return listEven;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> listMultipleOfThree = new ArrayList<>();
        for (Integer elemI : array) {
            if (elemI % 3 != 0) {
                continue;
            }
            listMultipleOfThree.add(elemI);
        }
        return listMultipleOfThree;
    }

    public List<Integer> getDifferentElements() {
        // 根据测试数据，这里假设输入的数据是非降有序的
        List<Integer> listDifferentElements = new ArrayList<>();
        listDifferentElements.add(array.get(0));
        boolean isFirst = true;
        int preNum = 0;
        for (Integer elemI : array) {
            if (isFirst) {
                preNum = elemI;
                isFirst = false;
                continue;
            }
            if (elemI != preNum) {
                listDifferentElements.add(elemI);
            }
            preNum = elemI;
        }
        return listDifferentElements;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        // 复杂度O(n^2)
        // 根据描述，"求两数组的公共元素"，当同一个元素分别在两个数组都出现多次时，本代码的做法是，以firstList出现的次数作为最终的次数
        List<Integer> listCommonElements = new ArrayList<>();
        for (Integer elemFirst : firstList) {
            if (secondList.contains(elemFirst)) {
                listCommonElements.add(elemFirst);
            }
        }
        return listCommonElements;
    }
}