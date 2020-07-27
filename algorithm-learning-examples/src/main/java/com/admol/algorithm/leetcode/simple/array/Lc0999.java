package com.admol.algorithm.leetcode.simple.array;

/**
 * 可以被一步捕获的棋子数
 * 在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
 *
 * 车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
 *
 * 棋手选择主动停下来。
 * 棋子因到达棋盘的边缘而停下。
 * 棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
 * 车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
 * 你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
 *
 *
 * 示例 1：
 * 输入：
 * [[".",".",".",".",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".","R",".",".",".","p"],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 *
 * 示例 2：
 * 输入：
 * [[".",".",".",".",".",".",".","."],
 *  [".","p","p","p","p","p",".","."],
 *  [".","p","p","B","p","p",".","."],
 *  [".","p","B","R","B","p",".","."],
 *  [".","p","p","B","p","p",".","."],
 *  [".","p","p","p","p","p",".","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".",".",".",".",".","."]]
 * 输出：0
 * 解释：
 * 象阻止了车捕获任何卒。
 *
 * 示例 3：
 * 输入：
 * [[".",".",".",".",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  ["p","p",".","R",".","p","B","."],
 *  [".",".",".",".",".",".",".","."],
 *  [".",".",".","B",".",".",".","."],
 *  [".",".",".","p",".",".",".","."],
 *  [".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 车可以捕获位置 b5，d6 和 f5 的卒。
 *
 * 提示：
 * board.length == board[i].length == 8
 * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 * 只有一个格子上存在 board[i][j] == 'R'
 *
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * @author : jingling
 * @Date : 2020/7/27
 */
public class Lc0999{

    public static void main(String[] args){
        System.out.println(numRookCaptures(new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
        }));
    }

    /**
     * 简化代码
     * @param board
     * @return
     */
    public static int numRookCaptures(char[][] board) {
        // 定义方向数组，分别是:上,下,右,左
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // 1.找到白色的车（Rook）
                if('R' == board[i][j]){
                    // 2.从4个方向捕获卒
                    for(int[] direction : directions){
                        count += catchByDire(i,j,direction,board);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 捕获卒
     * @param i  白色的车所在的位置行
     * @param j  白色的车所在的位置列
     * @param direction 方向
     * @param board 棋盘
     * @return
     */
    private static int catchByDire(int i,int j,int[] direction,char[][] board){
        while(i>=0 && j>=0 && i<board.length && j<board[0].length){
            if('B' == board[i][j]){
                break;
            }
            if('p' == board[i][j]){
                return 1;
            }
            i += direction[0];
            j += direction[1];
        }
        return 0;
    }

    /**
     * 判断四个方向
     * @param board
     * @return
     */
    public static int numRookCaptures1(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //1.找到白色的车（Rook）
                if('R' == board[i][j]){
                    // 2.四个方向找有没有卒
                    int l = j-1;
                    // 2.1左方向
                    while(l>=0){
                        if('B' == board[i][l]){
                            break;
                        }
                        if('p' == board[i][l]){
                            count++;
                            break;
                        }
                        l--;
                    }
                    l = j+1;
                    // 2.2右方向
                    while(l<board[0].length){
                        if('B' == board[i][l]){
                            break;
                        }
                        if('p' == board[i][l]){
                            count++;
                            break;
                        }
                        l++;
                    }
                    int h = i-1;
                    // 2.3上方向
                    while(h>=0){
                        if('B' == board[h][j]){
                            break;
                        }
                        if('p' == board[h][j]){
                            count++;
                            break;
                        }
                        h--;
                    }
                    h = i+1;
                    // 2.3下方向
                    while(h<board.length){
                        if('B' == board[h][j]){
                            break;
                        }
                        if('p' == board[h][j]){
                            count++;
                            break;
                        }
                        h++;
                    }
                }
            }
        }
        return count;
    }
}
