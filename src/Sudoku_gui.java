import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sudoku_gui {
    JFrame frame = new JFrame("数独");
    JPanel panel=new JPanel();
    JPanel panel_array = new JPanel();
    JPanel panel_difficultChoose=new JPanel();
    JTextField[][] textFields = new JTextField[9][9];
    Random random = new Random();
    JButton button_hard=new JButton("困难");
    JButton button_easy=new JButton("容易");
    JButton button_normal=new JButton("普通");
    public Sudoku_gui() {
        initialization();
    }

    void initialization() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textFields[i][j] = new JTextField(null);
                panel_array.add(textFields[i][j]);
            }
        }
        panel_difficultChoose.add(button_hard);
        panel_difficultChoose.add(button_normal);
        panel_difficultChoose.add(button_easy);
        panel_array.setLayout(new GridLayout(10, 10));
        panel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel_array.setSize(100, 100);
        Dimension dim = new Dimension();
        dim.setSize(400, 400);
        //panel_array.setBackground(Color.yellow);
        panel.add(panel_array,BorderLayout.CENTER);
        panel.add(panel_difficultChoose,BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(dim);
        Point point = new Point(300, 200);
        panel.setLocation(point);
    }

    void loadNumber(int seedArray[][],int difficult) {
        int[] tipNumber = new int[difficult];
        for(int m=0;m<9;m++){
            for (int n=0;n<9;n++){
                textFields[m][n].setText("");
                textFields[m][n].setEnabled(true);
            }
        }
        for (int m = 0; m < difficult; m++) {
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
//        panel.setVisible(true);
//        panel.setSize(dim);
//        Point point = new Point(300, 200);
//        panel.setLocation(point);
    }

}
