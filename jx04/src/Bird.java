public class Bird {
    private String name;
    private static int numBird = 0;

    public Bird() {
        numBird++;
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public static int genNum() {
        return numBird;
    }
}
