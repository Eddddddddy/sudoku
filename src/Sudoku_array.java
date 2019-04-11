import java.util.ArrayList;
import java.util.Random;

public class Sudoku_array {
    public int seedArray[][] =
            {
                    {9, 7, 8, 3, 1, 2, 6, 4, 5},
                    {3, 1, 2, 6, 4, 5, 9, 7, 8},
                    {6, 4, 5, 9, 7, 8, 3, 1, 2},
                    {7, 8, 9, 1, 2, 3, 4, 5, 6},
                    {1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {4, 5, 6, 7, 8, 9, 1, 2, 3},
                    {8, 9, 7, 2, 3, 1, 5, 6, 4},
                    {2, 3, 1, 5, 6, 4, 8, 9, 7},
                    {5, 6, 4, 8, 9, 7, 2, 3, 1}
            };
    public Sudoku_array() {
        System.out.println("原始的二维数组:");
        Sudoku_array.printArray(seedArray);
        creatNewArray();
    }

    public void creatNewArray() {
        ArrayList<Integer> randomList = Sudoku_array.creatNineRondomArray();
        Sudoku_array.creatSudokuArray(seedArray, randomList);
    }

    public static void printArray(int a[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + a[i][j]);
                if (0 == ((j + 1) % 3)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (0 == ((i + 1) % 3)) {
                System.out.println();
            }
        }
    }

    public static ArrayList<Integer> creatNineRondomArray() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int randomNum = random.nextInt(9) + 1;
            while (true) {
                if (!list.contains(randomNum)) {
                    list.add(randomNum);
                    break;
                }
                randomNum = random.nextInt(9) + 1;
            }
        }
        System.out.println("生成的一位数组为：");
        for (Integer integer : list) {
            System.out.print(" " + integer.toString());
        }
        System.out.println();
        return list;
    }

    public static void creatSudokuArray(int[][] seedArray, ArrayList<Integer> randomList) {
        int flag = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (seedArray[i][j] == randomList.get(k)) {
                        seedArray[i][j] = randomList.get((k + 1) % 9);
                        break;
                    }
                }
            }
        }
        System.out.println("处理后的数组");
        Sudoku_array.printArray(seedArray);
    }
}
