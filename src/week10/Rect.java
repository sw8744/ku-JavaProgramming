package week10;

public class Rect {
    int width;
    int height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getArea() {
        return this.width * this.height;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Rect) {
            Rect r = (Rect) obj;
            return this.getArea() == r.getArea();
        }
        return false;
    }
}
