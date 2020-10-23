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

    public static void main(String[] args) {
        Bird instBird = new Bird();
        Chicken instChicken1 = new Chicken();
        Chicken instChicken2 = new Chicken();
        Penguin instPenguin1 = new Penguin();
        Penguin instPenguin2 = new Penguin();
        Penguin instPenguin3 = new Penguin();

        System.out.println("Bird: " + Bird.genNum());
        System.out.println("Chicken: " + Chicken.getNum());
        System.out.println("Penguin: " + Penguin.getNum());
    }
}
