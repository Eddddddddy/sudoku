import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sudoku_gui {
    JFrame frame = new JFrame("数独");
    JPanel panel = new JPanel();
    JTextField[][] textFields = new JTextField[9][9];
    Random random = new Random();

    void Sudoku_gui() {
        initialization();
    }

    void initialization() {
        frame.setLayout(new GridLayout(10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(100, 100);
        Dimension dim = new Dimension();
        dim.setSize(400, 400);
        //pan.setBackground(Color.yellow);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setSize(dim);
        Point point = new Point(300, 200);
        frame.setLocation(point);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textFields[i][j] = new JTextField(null);
                frame.add(textFields[i][j]);
            }
        }
    }

    void loadNumber(int seedArray[][]) {
        int[] tipNumber = new int[30];
        for (int m = 0; m < 30; m++) {
            int i = random.nextInt(9);
            int j = random.nextInt(9);
            int a = i * 10 + j;
            int k = 0;
            for (int n = 0; n < m; n++) {
                if (tipNumber[n] == a) {
                    k = 1;
                    m--;
                    break;
                }
            }
            if (k == 0) {
                //temp=String.valueOf(seedArray[i][j]);
                //System.out.println(String.valueOf(seedArray[i][j]));
                tipNumber[m] = a;
                textFields[i][j].setText(String.valueOf(seedArray[i][j]));
                textFields[i][j].setEnabled(false);
                //name[i][j].setText(String.valueOf(seedArray[i][j]));
            }
        }
    }
}
