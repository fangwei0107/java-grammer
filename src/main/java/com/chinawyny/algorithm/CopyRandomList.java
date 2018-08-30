package com.chinawyny.algorithm;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = null, pNode = head, newPre = null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (pNode != null) {
            RandomListNode newNode = new RandomListNode(pNode.label);
            if (pNode == head) {
                newHead = newNode;
                newPre = newNode;
            } else {
                newPre.next = newNode;
                newPre = newPre.next;
            }
            map.put(newNode, pNode);
            pNode = pNode.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> m : map.entrySet()) {
            m.getValue().random = map.get(m.getKey().random);
        }

        return newHead;
    }
    public int singleNumber(int[] A) {
        boolean[] flags = new boolean[A.length];
        int i, j, k;
        for (i = 0;i < A.length;i++) {
            if (flags[i]) {
                continue;
            }
            for (j = i + 1;j < A.length;j++) {
                if (flags[j]) {
                    continue;
                }
                if (A[i] == A[j]) {
                    for (k = j + 1;k< A.length;k++){
                        if (flags[k]) {
                            continue;
                        }
                        if (A[j] == A[k]) {
                            flags[i] = flags[k] = flags[j] = true;
                        }
                    }
                    if (k == A.length && !flags[i]) {
                        return A[i];
                    }
                }

            }
            if (j == A.length && !flags[i]) {
               return A[i];
            }
        }
        return A[i];
    }

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        System.out.println(copyRandomList.singleNumber(new int[] {3,1,3,3}));
    }
}
