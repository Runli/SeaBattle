package Display;
import Game.Game;
import javax.swing.*;
import java.awt.*;

/**
 * Created by ilnurgazizov on 18.09.15.
 */
public class Display extends JFrame {
    public static final int     WIDTH           = 1080;
    public static final int     HEIGHT          = 810;

    private static boolean created = false; // Проверка создания окна

    private static JFrame window = new JFrame("Sea Battle");;
    private static JPanel panel = new JPanel();
    public static final int FIELD_SIZE = 10;

    // Поля для меню
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuGame = new JMenu("Game");
    private JMenu menuAbout = new JMenu("About");
    private JMenuItem menuStartItem = new JMenuItem("Start");
    private JMenuItem menuExitItem = new JMenuItem("Exit");

    // Поля для полей игрока и оппонента
    private Container bothFields = new Container();
    private JPanel userField = new JPanel(new GridLayout(FIELD_SIZE + 1, FIELD_SIZE + 1));
    private JPanel opponentField = new JPanel(new GridLayout(FIELD_SIZE + 1, FIELD_SIZE + 1));

    private JPanel controller = new JPanel();

    // массивы кнопок для отображения поля
    private JButton[][] userCells;
    public JButton[][] opponentCells;


    private char[] numberToLetter = new char[]      // массив для вывода координаты "x" в буквенном кириллическом виде
     {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Ы', 'Э', 'Ю', 'Я'};

    public Display(Game game){
        create(WIDTH, HEIGHT);
        window.setVisible(true);
    }

    private void create(int width, int height){

        if (created) return;

        window.setLayout(new BorderLayout());   // композиция окна
        window.setSize(width, height);          // размеры окна
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Добавил простое меню
        menuGame.add(menuStartItem);
        menuGame.add(menuExitItem);
        menuBar.add(menuGame);
        menuBar.add(menuAbout);
        window.setJMenuBar(menuBar);

        userCells = new JButton[FIELD_SIZE + 1][FIELD_SIZE + 1];
        opponentCells = new JButton[FIELD_SIZE + 1][FIELD_SIZE + 1];

        userField.setSize(500, 500);
        opponentField.setSize(500, 500);
        bothFields.add(userField);
        bothFields.add(opponentField);
        window.add(BorderLayout.CENTER, bothFields);
        window.add(BorderLayout.SOUTH, controller);

//        window.pack(); // контент будет находится внутри окна без потерь
        window.setLocationRelativeTo(null); // меняем позицию окна в зависимости от переданного компонента
        window.setResizable(false); //нельзя менять размер окна
        created = true;

    }

    private void initializeOfFields() {
        // Угловые неиспользуемые ячейки(кнопки)
        userCells[0][0] = new JButton();
        userCells[0][0].setEnabled(false);
        opponentCells[0][0] = new JButton();
        opponentCells[0][0].setEnabled(false);

        // Объявляем подписи вертикальной оси
        for (int i = 1; i < FIELD_SIZE; i++) {
            userCells[0][i] = new JButton(String.valueOf(i));
            userCells[0][i].setEnabled(false);
            opponentCells[0][i] = new JButton(String.valueOf(i));
            opponentCells[0][i].setEnabled(false);
        }

        // Объявляем подписи горизонтальной оси
        for (int i = 1; i <= FIELD_SIZE; i++) {     // подписи горизонтальной оси
            userCells[i][0] = new JButton(String.valueOf(numberToLetter[i - 1]));
            userCells[i][0].setEnabled(false);
            opponentCells[i][0] = new JButton(String.valueOf(numberToLetter[i - 1]));
            opponentCells[i][0].setEnabled(false);
        }

        for (int y = 0; y <= FIELD_SIZE; y++) {    // добавляем полученный массив кнопок на
            for (int x = 0; x <= FIELD_SIZE; x++) { // соответствующие ячейки
                userField.add(userCells[x][y]);
                opponentField.add(opponentCells[x][y]);
            }
        }
    }
}
