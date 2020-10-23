public class Wa {
    // attrubute
    private int ansInt;
    private double ansDouble;

    // method
    public void wa(int val1, int val2) {
        this.wa(val1, val2, 0);
    }

    public void wa(int val1, int val2, int val3) {
        ansInt = val1 + val2 + val3;
        System.out.println("answer(int): " + ansInt);
    }

    public void wa(double val1, double val2) {
        ansDouble = val1 + val2;
        System.out.println("answer(double): " + ansDouble);
    }

    public static void main(String argv[]) {
        Wa inst1 = new Wa();

        inst1.wa(1, 2);
        inst1.wa(10, 20, 30);
        inst1.wa(10.12, 0.345);
    }
}