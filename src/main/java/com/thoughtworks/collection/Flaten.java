package com.thoughtworks.collection;

import java.util.*;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> listOneDimesional = new ArrayList<>();
        for (Integer[] arr : array) {
            listOneDimesional.addAll(Arrays.asList(arr));
        }
        return listOneDimesional;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        // 空间换时间，引入set来降低时间复杂度。
        List<Integer> listOneDimesional = new ArrayList<>();
        Set<Integer> setAppeared = new HashSet<>();
        for (Integer[] arr : array) {
            for (Integer elemI : arr) {
                if (!setAppeared.contains(elemI)) {
                    listOneDimesional.add(elemI);
                    setAppeared.add(elemI);
                }
            }
        }
        return listOneDimesional;
    }
}
