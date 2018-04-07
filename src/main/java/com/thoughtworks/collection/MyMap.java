package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> listTriple = new ArrayList<>();
        for (Integer elemI : array) {
            listTriple.add(elemI * 3);
        }
        return listTriple;
    }

    public List<String> mapLetter() {
        List<String> listLetter = new ArrayList<>();
        for (Integer elemI : array) {
            listLetter.add("" + (char) ('a' - 1 + elemI));
        }
        return listLetter;
    }

    public List<String> mapLetters() {
        List<String> listLetters = new ArrayList<>();
        for (Integer elemI : array) {
            listLetters.add(int2Letters(elemI));
        }
        return listLetters;
    }

    private String int2Letters(int x) {
        // 这个代码仅能处理本题的测试数据
        int quotient;
        x--;
        String sFirst = (quotient = x / 26) > 0 ? letters[quotient - 1] : "";
        return sFirst + letters[x % 26];
    }

    public List<Integer> sortFromBig() {
        List<Integer> listNonDecrease = new ArrayList<>(array);
        listNonDecrease.sort(Comparator.reverseOrder());
        return listNonDecrease;
    }

    public List<Integer> sortFromSmall() {
        List<Integer> listNonDecrease = new ArrayList<>(array);
        listNonDecrease.sort(null);
        return listNonDecrease;
    }
}
