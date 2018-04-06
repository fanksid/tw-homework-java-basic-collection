package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int step = left > right ? -1 : 1;
        List<Integer> listIntByInterval = new ArrayList<>();
        for (int i = left; i != right; i += step) {
            listIntByInterval.add(i);
        }
        // 单独处理right。当然了，如果上面循环的条件写成 i != right + step，就不用单独处理了
        listIntByInterval.add(right);
        return listIntByInterval;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int first = left;
        int last = right;
        int toward = left > right ? -1 : 1;
        if (first % 2 == 1) {
            first += toward;
        }
        if (last % 2 == 1) {
            last -= toward;
        }
        int step = toward << 1;
        List<Integer> listEven = new ArrayList<>();
        for (int i = first; i != last; i += step) {
            listEven.add(i);
        }
        listEven.add(last);
        return listEven;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> listEven = new ArrayList<>();
        for (int elem : array) {
            if (elem % 2 == 0) {
                listEven.add(elem);
            }
        }
        return listEven;
    }

    public int popLastElment(int[] array) {
        // 对退化的情况进行处理，虽然本题不需要这个也可以通过测试
        if (array == null || array.length == 0) {
            return Integer.MAX_VALUE;
        }
        return array[array.length -1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        // 这里使用List求的求集。还可以自己手动实现，先排序，再提出相同的元素，复杂度为O(nlogn)
        // TODO: 是否有更好的方法可以方便地把基本类型的数组转为List
        List<Integer> listCommonElement = new ArrayList<>();
        List<Integer> listTmp = new ArrayList<>();
        for (int elemI : firstArray) {
            listCommonElement.add(elemI);
        }
        for (int elemI : secondArray) {
            listTmp.add(elemI);
        }
        listCommonElement.retainAll(listTmp);
        return listCommonElement;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        // 这里不能写成List<Integer> listAddedUncommonElement = Arrays.asList(firstArray);
        // 因为Arrays.asList()返回的是一个固定大小的list，将无法向里面添加元素
        List<Integer> listAddedUncommonElement = new ArrayList<>(Arrays.asList(firstArray));

        // 复杂度O(n^2)，数据量大时，建议用Set降复杂度
        for (Integer elemI : secondArray) {
            if (!listAddedUncommonElement.contains(elemI)) {
                listAddedUncommonElement.add(elemI);
            }
        }
        return listAddedUncommonElement;
    }
}
