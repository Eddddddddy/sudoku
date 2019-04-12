import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Sudoku_gui {
    JFrame frame = new JFrame("数独");
    JPanel panel = new JPanel();
    JPanel panel_array = new JPanel();
    JPanel panel_difficultChoose = new JPanel();
    JPanel panel_decide = new JPanel();
    JTextField[][] textFields = new JTextField[9][9];
    Random random = new Random();
    JButton button_hard = new JButton("困难");
    JButton button_easy = new JButton("容易");
    JButton button_normal = new JButton("普通");
    JButton button_submit = new JButton("提交");
    JButton button_answer = new JButton("查看答案");

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
        panel_decide.add(button_submit);
        panel_decide.add(button_answer);
        panel_array.setLayout(new GridLayout(10, 10));
        panel.setLayout(new BorderLayout());
        panel_decide.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel_array.setSize(100, 100);
        Dimension dim = new Dimension();
        dim.setSize(500, 500);
        //panel_array.setBackground(Color.yellow);
        panel.add(panel_array, BorderLayout.CENTER);
        panel.add(panel_difficultChoose, BorderLayout.SOUTH);
        panel.add(panel_decide, BorderLayout.EAST);
        panel_array.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(dim);
        Point point = new Point(300, 200);
        panel.setLocation(point);
    }

    void loadNumber(int seedArray[][], int difficult) {
        int[] tipNumber = new int[difficult];
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                textFields[m][n].setText("");
                textFields[m][n].setEnabled(true);
                textFields[m][n].setBackground(Color.yellow);
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
                textFields[i][j].setBackground(Color.WHITE);
                //name[i][j].setText(String.valueOf(seedArray[i][j]));
            }
        }
//        panel.setVisible(true);
//        panel.setSize(dim);
//        Point point = new Point(300, 200);
//        panel.setLocation(point);
    }

    void submit(int seedArray[][]) {
        int b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((textFields[i][j].getText()).equals(String.valueOf(seedArray[i][j]))) {
                    b++;
                }
            }
        }
        //System.out.println(b);
        if (b == 81) {
            JOptionPane.showMessageDialog(null, "成功", "Sudoku", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "错误", "Sudoku", JOptionPane.PLAIN_MESSAGE);
        }
    }

    void print_answer(int seedArray[][]) {
        JDialog dialog = new JDialog(frame, "答案");
        JPanel panel = new JPanel();
        JPanel panel_answer = new JPanel();
        JButton button_OK = new JButton("确定");
        JTextField[][] textFields = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textFields[i][j] = new JTextField(String.valueOf(seedArray[i][j]));
                textFields[i][j].setEnabled(false);
                panel_answer.add(textFields[i][j]);
            }
        }
        panel_answer.setLayout(new GridLayout(10,10));
        panel.setLayout(new BorderLayout());
        panel.add(panel_answer,BorderLayout.CENTER);
        panel.add(button_OK,BorderLayout.SOUTH);
        panel.setSize(300,300);
        dialog.setSize(300,300);
        dialog.add(panel);
        dialog.setVisible(true);
        button_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }
}
