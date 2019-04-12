import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudoku_mode {
    public Sudoku_mode(Sudoku_gui gui) {
        gui.button_easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sudoku_main.switch_difficult(70);
            }
        });

        gui.button_normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sudoku_main.switch_difficult(50);
            }
        });

        gui.button_hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sudoku_main.switch_difficult(30);
            }
        });

        gui.button_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sudoku_main.submit();
            }
        });

        gui.button_answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sudoku_main.print_answer();
            }
        });
    }
}
