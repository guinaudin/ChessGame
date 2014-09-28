package model.board;

public class ColumnTypes {
    public enum Column { 
        A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8);

        private int column;

        private Column(int column) {
            this.column = column;
        }

        public int getInt() {
            return column;
        } 
    }
}
