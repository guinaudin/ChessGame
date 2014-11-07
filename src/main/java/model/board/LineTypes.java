package model.board;

public class LineTypes {
    public enum Line { 
        ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7);

        private int line;

        private Line(int line) {
            this.line = line;
        }

        public int getInt() {
            return line;
        } 
    }
}
