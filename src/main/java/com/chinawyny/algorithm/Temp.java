package com.chinawyny.algorithm;

import java.util.LinkedList;

public class Temp {

    public int run(Point[] points) {
        if (points == null) {
            return 0;
        }
        int len = points.length;
        if (len <= 2) {
            return len;
        }
        int max = 2;
        for (int i = 0; i < len; i++) {
            int num1 = 0;

            for (int j = i + 1; j < len; j++) {
                int num2 = 1;
                int x1 = points[i].x - points[j].x;
                int y1 = points[i].y - points[j].y;
                if (x1 == 0 && y1 == 0) {
                    num1++;
                } else {
                    num2++;
                    for (int k = j + 1; k < len; k++) {
                        int x2 = points[j].x - points[k].x;
                        int y2 = points[j].y - points[k].y;
                        if (x1 * y2 == x2 * y1) {
                            num2++;
                        }
                    }
                    if (max < num1 + num2) {
                        max = num1 + num2;
                    }
                }
            }
        }
        return max;
    }

    public int maxPoints(Point[] points) {
        int len = points.length;
        if (points == null) {
            return 0;
        }
        if (len <= 2) {
            return len;
        }
        int max = 2;
        for (int i = 0; i < len; i++) {
            int num1 = 0;
            int num2 = 1;
            for (int j = i + 1; j < len; j++) {
                int x1 = points[i].x - points[j].x;
                int y1 = points[i].y - points[j].y;
                if (x1 == 0 && y1 == 0) {
                    num1++;
                } else {
                    num2++;
                    for (int k = j + 1; k < len; k++) {
                        int x2 = points[j].x - points[k].x;
                        int y2 = points[j].y - points[k].y;
                        if (x2 * y1 == x1 * y2) {
                            num2++;
                        }
                    }
                }
                if (max < (num1 + num2)) {
                    max = num1 + num2;
                }
                num2 = 1;
            }
        }

        return max;
    }

}
