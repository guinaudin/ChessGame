package model;

public final class Position implements Comparable<Position> {
    private final int posX, posY;

    public Position(final int posX, final int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Position(final Position position, final int deltaX, final int deltaY) {
        this(position.posX + deltaX, position.posY + deltaY);
    }

    public int getX() {
        return posY;
    }

    public int getY() {
        return posY;
    }

    @Override
    public String toString() {
        return "" + ((char) ('a' + (char) posX)) + (posY + 1);
    }

    public boolean equals(final Position position) {
        return (position != null) && (position.posX == posX) && (position.posY == posY);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        return equals((Position) o);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.posX;
        hash = 47 * hash + this.posY;
        return hash;
    }

    @Override
    public int compareTo(final Position position) {
        if (posY == position.posY) {
            return posX - position.posX;
        } else {
            return posY - position.posY;
        }
    }
}
