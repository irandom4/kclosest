package in.technoark;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    // use pythagorean theorem to calculate distance from origin
    private double distanceFromOrigin(int[] point) {
        int x = point[0];
        int y = point[1];
        return Math.sqrt(square(x) + square(y));
    }

    // calculate sqaure of a number
    private int square(int number) {
        return number * number;
    }

    public int[][] kClosest(int[][] points, int K) {
        List<int[]> sortedPoints = Arrays.stream(points) // convert array to stream
                .sorted((o1, o2) -> { // sort the points according to their distances from the origin
                    double d1 = distanceFromOrigin(o1);
                    double d2 = distanceFromOrigin(o2);
                    return Double.compare(d1, d2);
                })
                .limit(K) // take only K closest out of the sorted points
                .collect(Collectors.toList()); // collect all points in a List

        return sortedPoints.toArray(new int[0][0]); // convert List to array
    }
}