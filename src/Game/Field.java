package Game;

/**
 * Created by ilnurgazizov on 21.09.15.
 */
public class Field {
    public static final int FIELD_SIZE = 10; // размер поля

    private FieldState[][] field = new FieldState[FIELD_SIZE][FIELD_SIZE];

    public FieldState[][] CreateField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            field[i] = new FieldState[FIELD_SIZE];
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = FieldState.NONE;
            }
        }
        return field;
    }

    // Внутренний класс Состояние
    public enum FieldState {
        NONE, DECK, KILLED, WOUNDED, MISSED
    }


}
