package com.chinawyny.algorithm.tree;

import com.chinawyny.algorithm.TreeNode;

import java.util.*;

public class OfferTree {
    
    private static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        
        if (root1 == root2) {
            return true;
        }
        
        if (root2 == null) {
            return true;
        }
        
        if (root1 == null) {
            return false;
        }
        
        boolean isPass = false;
        
        if (root1.val == root2.val) {
            isPass = match(root1, root2);
        }
        
        if (isPass) {
            return true;
        }
        
        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
        
    }
    
    private static boolean match(TreeNode root1, TreeNode root2) {
        
        if (root1 == root2) {
            return true;
        }
        
        if (root2 == null) {
            return true;
        }
        
        if (root1 == null) {
            return false;
        }
        
        if (root1.val == root2.val) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }
        
        return false;
        
    }
    
    
    private static void mirrorTree(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        mirrorTree(root.left);
        mirrorTree(root.right);
        
    }
    
    public static void printMatrixClockWisely(int[][] numbers) {
        if (numbers == null) {
            return;
        }
        
        int x = 0;
        
        int y = 0;
        
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            x++;
            y++;
        }
    }
    
    private static void printMatrixInCircle(int[][] numbers, int x, int y) {
        
        int rows = numbers.length;
        
        int cols = numbers[0].length;
        
        for (int i = y; i <= cols - 1 - y; i++) {
            System.out.print(numbers[x][i] + " ");
        }
        
        if (rows - 1 - x > x) {
            for (int i = x + 1; i < rows - x; i++) {
                System.out.print(numbers[i][cols - 1 - y] + " ");
            }
        }
        
        if (cols - 1 - y > y && rows - 1 - x > x) {
            for (int j = cols - y - 2; j >= y; j--) {
                System.out.print(numbers[rows - x - 1][j] + " ");
            }
        }
        
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            for (int j = rows - x - 2; j > x; j--) {
                System.out.print(numbers[j][y] + " ");
            }
        }
    }
    
    private static boolean isPopOrder(int[] push, int[] pop) {
        
        if (push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }
        int length = push.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (j < pop.length) {
            while (i < length && (stack.isEmpty() || stack.peek() != pop[j])) {
                stack.push(push[i]);
                i++;
            }
            
            if (stack.peek() == pop[j]) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
        
    }
    
    private static void levelTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        
        LinkedList<TreeNode> list = new LinkedList<>();
        
        list.addLast(root);
        
        while (!list.isEmpty()) {
            TreeNode work = list.removeFirst();
            System.out.print(work.val + " ");
            if (work.left != null) {
                list.addLast(work.left);
            }
            if (work.right != null) {
                list.addLast(work.right);
            }
        }
        
    }
    
    private static boolean verifySequenceOfBST(int[] seq) {
        if (seq == null || seq.length <= 0) {
            return false;
        }
        
        return verifySequenceOfBST(seq, 0, seq.length - 1);
    }
    
    private static boolean verifySequenceOfBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        
        int index = start;
        
        while (index <= end - 1 && seq[index] < seq[end]) {
            index++;
        }
        
        int right = index;
        
        while (index <= end - 1 && seq[index] >= seq[end]) {
            index++;
        }
        
        if (index != end - 1) {
            return false;
        }
        
        return verifySequenceOfBST(seq, start, right - 1) && verifySequenceOfBST(seq, right, end - 1);
        
        
    }
    
    private static void findPath(TreeNode root, int expSum) {
        List<Integer> list = new ArrayList<>();
        
        if (root != null) {
            findPath(root, 0, expSum, list);
        }
    }
    
    private static void findPath(TreeNode root, int curSum, int expSum, List<Integer> list) {
        
        if (root == null) {
            return;
        }
        
        curSum += root.val;
        list.add(root.val);
        
        if (curSum == expSum && root.left == null && root.right == null) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
            
            
        } else {
            findPath(root.left, curSum, expSum, list);
            findPath(root.right, curSum, expSum, list);
        }
        
        if (list.size() >= 1) {
            list.remove(list.size() - 1);
        }
        
    }
    
    static class ComplexListNode {
        
        int val;
        
        ComplexListNode next;
        
        ComplexListNode sibling;
        
    }
    
    private static ComplexListNode clone(ComplexListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        Map<ComplexListNode, ComplexListNode> originNode2Sib = new HashMap<>();
        
        Map<ComplexListNode, ComplexListNode> originNode2Copy = new HashMap<>();
        
        ComplexListNode copyPreHead = new ComplexListNode();
        ComplexListNode copyPre = copyPreHead;
        
        ComplexListNode workNode = head;
        
        while (workNode != null) {
            ComplexListNode copyNode = new ComplexListNode();
            copyNode.val = workNode.val;
            copyPre.next = copyNode;
            originNode2Copy.put(workNode, copyNode);
            originNode2Sib.put(workNode, workNode.sibling);
            workNode = workNode.next;
            copyPre = copyPre.next;
        }
        
        for (Map.Entry<ComplexListNode, ComplexListNode> entry : originNode2Copy.entrySet()) {
            entry.getValue().sibling = originNode2Copy.get(originNode2Sib.get(entry.getKey()));
        }
        
        
        return copyPreHead.next;
    }
    
    private static ComplexListNode clone2(ComplexListNode head) {
        
        if (head == null || head.next == null) {
            return null;
        }
        
        cloneNodes(head);
        
        connectSibNodes(head);
        return reconnectNodes(head);
    }
    
    private static ComplexListNode reconnectNodes(ComplexListNode head) {
        
        if (head == null) {
            return null;
        }
        
        ComplexListNode newHead = head.next;
        ComplexListNode work = newHead.next.next;
        
        ComplexListNode pre = new ComplexListNode();
        pre.next = newHead;
        
        while (work != null) {
            pre.next = work;
            work = work.next.next;
            pre = pre.next;
            
        }
        
        return newHead;
    }
    
    private static void connectSibNodes(ComplexListNode work) {
        
        while (work != null) {
            if (work.sibling != null) {
                work.next.sibling = work.sibling.next;
            }
            work = work.next.next;
        }
        
    }
    
    private static void cloneNodes(ComplexListNode work) {
        
        while (work != null) {
            ComplexListNode copy = new ComplexListNode();
            copy.val = work.val;
            copy.next = work.next;
            work.next = copy;
            work = work.next.next;
        }
        
    }
    
    private static TreeNode binaryTree2ListConvert(TreeNode root) {
        
        TreeNode tailNode = new TreeNode();
        convertHelp(root, tailNode);
        
        TreeNode head = tailNode;
        while (head != null && head.left != null) {
            head = head.left;
        }
        
        return head;
    }
    
    private static void convertHelp(TreeNode root, TreeNode tailNode) {
        if (root != null) {
            
            if (root.left != null) {
                convertHelp(root.left, tailNode);
            }
            
            root.left = tailNode;
            
            if (tailNode != null) {
                tailNode.right = root;
            }
            tailNode = root;
            
            if (root.right != null) {
                convertHelp(root.right, tailNode);
            }
            
        }
    }
    
    private static void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.right;
        }
        
        System.out.println("null");
    }
    
    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
    }
    
    
    private static List<String> permutation(char[] chars) {
        
        if (chars == null || chars.length < 1) {
            return null;
        }
        
        List<String> res = new ArrayList<>();
        
        permutation(chars, 0, res);
        
        return res;
        
    }
    
    private static void permutation(char[] chars, int start, List<String> res) {
        
        if (start == chars.length - 1) {
            res.add(new String(chars));
            return;
        }
        
        char tmp;
        for (int i = start; i < chars.length; i++) {
            tmp = chars[i];
            chars[i] = chars[start];
            chars[start] = tmp;
            permutation(chars, start + 1, res);
            tmp = chars[i];
            chars[i] = chars[start];
            chars[start] = tmp;
        }
        
    }
    
    private static List<String> combine(char[] chars) {
        if (chars == null || chars.length < 1) {
            return null;
        }
        List<Character> one = new ArrayList<>();
        
        List<String> res = new ArrayList<>();
        
        for (int i = 1; i <= chars.length; i++) {
            combine(chars, 0, i, one, res);
        }
        
        return res;
    }
    
    private static void combine(char[] chars, int start, int length, List<Character> one, List<String> res) {
        
        if (length == 0) {
            char[] oneChars = new char[one.size()];
            for (int i = 0; i < one.size(); i++) {
                oneChars[i] = one.get(i);
            }
            res.add(new String(oneChars));
            return;
        }
        
        if (start < chars.length) {
            one.add(chars[start]);
            combine(chars, start + 1, length - 1, one, res);
            
            one.remove(one.size() - 1);
            combine(chars, start + 1, length, one, res);
        }
    }
    
    private static int eightPrincess() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        
        int[] res = new int[]{0};
        
        eightPrincess(arr, res, 0);
        
        return res[0];
    }
    
    private static void eightPrincess(int[] arr, int[] res, int start) {
        
        if (start == arr.length - 1) {
            
            if (chargeSafe(arr)) {
                res[0]++;
            }
            return;
        }
        
        int temp;
        for (int i = start; i < arr.length; i++) {
            
            temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
            
            eightPrincess(arr, res, start + 1);
            
            temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
            
        }
    }
    
    private static boolean chargeSafe(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1;j < arr.length;j++) {
                if (arr[i] - arr[j] == i - j || arr[i] - arr[j] == j - i) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static int moreThanHalf(int[] arr) {
        
        if (arr == null || arr.length < 1) {
            throw new RuntimeException("数据异常");
        }
        
        int count = 0;
        int res = arr[0];
        for (int i = 0;i < arr.length; i++) {
            
            if (count == 0) {
                res = arr[i];
                count = 1;
            } else if(res != arr[i]) {
                count--;
            } else {
                count++;
            }
        }
        
        if (count > 0) {
            return res;
        }
        throw new RuntimeException("异常");
    }
    
    private int[] findMinK(int[] arr, int k) {
        
        if (arr == null || arr.length <= k) {
            return arr;
        }
        
        int[] res = new int[k];
    
        System.arraycopy(arr, 0, res, 0, k);
        
        for (int i = k / 2;i >= 0;i++) {
            heapAdjust(arr, i, k - 1);
        }
        
        int j = k;
        
        for (;j < arr.length; j++) {
            
        }
        
        
        return res;
        
    }
    
    private void heapAdjust(int[] arr, int parent, int end) {
        
        if (arr == null || arr.length < 2) {
            return;
        }
        
        int leftChild = 2 * parent + 1;
        
        if (leftChild > end) {
            return;
        }
    
        int rightChild = 2 * parent + 2 > end ? leftChild : 2 * parent + 2;
        
        int bigger = leftChild;
        if (arr[leftChild] < arr[rightChild]) {
            bigger = rightChild;
        }
        
        if (arr[bigger] > arr[parent]) {
            int temp = arr[bigger];
            arr[bigger] = arr[parent];
            arr[parent] = temp;
        }
    
    }
    
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalf(numbers));
        
    }
    
}
