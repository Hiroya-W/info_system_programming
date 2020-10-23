public class TryOverload {
    private int valInt;
    private String valStr;
    private double valDouble;

    /* Getter Setter */
    public int getValInt() {
        return valInt;
    }

    public void setValInt(int valInt) {
        this.valInt = valInt;
    }

    public String getValStr() {
        return valStr;
    }

    public void setValStr(String valStr) {
        this.valStr = valStr;
    }

    public double getValDouble() {
        return valDouble;
    }

    public void setValDouble(double valDouble) {
        this.valDouble = valDouble;
    }

    /* Overload */
    public void setValue(int val){
        valInt = val;
    }

    public void setValue(String val){
        valStr = val;
    }

    public void setValue(double val){
        valDouble = val;
    }

    public void times(int val1, int val2){
        System.out.println(val1 * val2);
    }

    public void times(String str, int num){
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public void times(int num, String str){
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }

    public void times(String str1, String str2){
        System.out.println(str1+ str2);
    }

    public static void main(String[] args) {
        TryOverload inst = new TryOverload();

        inst.setValue(10);
        System.out.println("inst.getValInt(): " + inst.getValInt());
        inst.setValue("Hello World.");
        System.out.println("inst.getValStr(): " + inst.getValStr());
        inst.setValue(5.43);
        System.out.println("inst.getValDouble(): " + inst.getValDouble());

        inst.times(3,4);
        inst.times("Happy", 3);
        inst.times(4,"Birthday");
        inst.times("Happy ", "Birthday!");
    }
}
