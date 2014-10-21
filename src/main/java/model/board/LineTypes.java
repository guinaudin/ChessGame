package model.board;

public class LineTypes {
    public enum Line { 
        ONE(7), TWO(6), THREE(5), FOUR(4), FIVE(3), SIX(2), SEVEN(1), EIGHT(0);

        private int line;

        private Line(int line) {
            this.line = line;
        }

        public int getInt() {
            return line;
        } 
    }
}
