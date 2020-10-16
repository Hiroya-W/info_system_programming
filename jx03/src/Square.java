public class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int l) {
        side = l;
    }

    @Override
    public float calcArea() {
        float l;

        l = getSide();
        return (float) (l * l);
    }
}
