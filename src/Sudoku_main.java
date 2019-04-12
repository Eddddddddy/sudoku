public class Sudoku_main {
    static Sudoku_gui gui = new Sudoku_gui();
    static Sudoku_array array = new Sudoku_array();
    static Sudoku_mode mode = new Sudoku_mode(gui);

    public static void main(String[] args) {
        gui.loadNumber(array.seedArray, 70);
    }

    public static void switch_difficult(int difficult) {
        array.creatNewArray();
        gui.loadNumber(array.seedArray, difficult);
    }

    public static void submit() {
        gui.submit(array.seedArray);
    }

    public static void print_answer(){
        gui.print_answer(array.seedArray);
    }
}
