package com.lcy.util;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuweijin
 * @date 2022-03-29 16:04
 * @desc
 */
public class TestUitl {

    public static void main(String[] args) {

            String s="52012001A2";
        String substring = s.substring(0,8);
        System.out.println(substring);


        String format = String.format("%03d", s);
        System.out.println(format);

    }

    static List<Integer> printNode(ListNode node) {
        List<Integer> list = new ArrayList<>();
        list.add(node.val);
        while (node.next != null) {
            list.add(node.next.val);
            node = node.next;
        }
        return list;
    }

    //asdadsaqwcbklpy
//    public static int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        int result = 0;
//        Math.max(1,2);
//        Set<Object> set = new HashSet<>();
//        int tamp = 0;
//        for (int i = 0; i < chars.length; i++) {
//            String aa="";
//            char aChar = chars[i];
//            if (set.contains(aChar)) {
//                result = 1;
//                set = new HashSet<>();
//                aa="-";
//            } else {
//                set.add(aChar);
//                result++;
//                aa="+";
//            }
//            if (result > tamp) {
//                tamp = result;
//            }
//            System.out.println(aChar + " " + aa + " " + result + " " + tamp + " " + set.size());
//        }
//        return tamp;
//    }

    //cbacba
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);//102 101 100 102 101 100
            start = Math.max(start, last[index] + 1);//0 0 0 1 2
            res   = Math.max(res, i - start + 1);//1 2 3 3  3
            last[index] = i;// 0 1 2 3 4 5
        }

        return res;
    }
}
