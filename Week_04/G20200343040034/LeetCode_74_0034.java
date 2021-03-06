package com.alang.learn.week4;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/***
 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。
 示例 1:

 输入:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 输出: true
 示例 2:

 输入:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 13
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_74_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 13));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            int start = 0, end = (row * col) - 1;
            while (start <= end) {
                int middle = (start + end) / 2;
                if (matrix[middle / col][middle % col] == target) {
                    return true;
                } else if (matrix[middle / col][middle % col] < target) {
                    start = middle + 1;
                } else if (matrix[middle / col][middle % col] > target) {
                    end = middle - 1;
                }
            }
            return false;
        }
    }
}
