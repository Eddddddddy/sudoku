
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.List;
import java.util.ArrayList;


class Guiii {

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
        //System.out.println("处理后的数组");
        //Guiii.printArray(seedArray);

    }

    public static void main(String[] args) {
        int seedArray[][] =
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
        System.out.println("原始的二维数组:");
        Guiii.printArray(seedArray);
        ArrayList<Integer> randomList = Guiii.creatNineRondomArray();
        Guiii.creatSudokuArray(seedArray, randomList);

        Random rm = new Random();//随机数

        String temp;
        int i, j, m, n, a, b;
        int[] sum = new int[30];
        JFrame f = new JFrame("数独");
        JPanel pan = new JPanel();
        //JLabel lab=new JLabel("1",JLabel.CENTER);
        JTextField[][] name = new JTextField[9][9];
        //JTextField name1=new JTextField();
        //name[0][0].setText("1");
        //name1.setText("2");
        //f.add(name1);

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                name[i][j] = new JTextField(null);
                f.add(name[i][j]);
            }
        }

        for (m = 0; m < 30; m++) {
            i = rm.nextInt(9);
            j = rm.nextInt(9);
            a = i * 10 + j;
            for (n = 0; n < 30; n++) {
                if (sum[n] == a) {
                    m--;
                    continue;
                }
            }
            //temp=String.valueOf(seedArray[i][j]);
            //System.out.println(String.valueOf(seedArray[i][j]));
            sum[m] = a;
            name[i][j].setText(String.valueOf(seedArray[i][j]));
            name[i][j].setEnabled(false);
            //name[i][j].setText(String.valueOf(seedArray[i][j]));

        }


        //name.setColumns(30);

        //name.setEnabled(false);
        f.setLayout(new GridLayout(10, 10));
        //f.add(name);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pan.add(lab);
        pan.setSize(100, 100);
        Dimension dim = new Dimension();
        dim.setSize(400, 400);
        //pan.setBackground(Color.yellow);
        f.getContentPane().add(pan);
        f.setVisible(true);
        f.setSize(dim);
        Point point = new Point(300, 200);
        f.setLocation(point);
        while (true) {
            b = 0;
            for (i = 0; i < 9; i++) {
                for (j = 0; j < 9; j++) {
                    if ((name[i][j].getText()).equals(String.valueOf(seedArray[i][j]))) {
                        b++;
                    }
                }
            }
            //System.out.println(b);
            if (b == 81) {
                break;
            }
            try {
                //Thread.currentThread();
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        System.out.println("good");
    }
}



