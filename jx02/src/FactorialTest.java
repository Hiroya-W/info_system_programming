public class FactorialTest {
    public static void main(String[] args) {
        Factorial[] instFacts = new Factorial[10];
        for (int i = 0; i < 10; i++) {
            instFacts[i] = new Factorial();
            instFacts[i].setNum(i);
        }
        instFacts[0].setFact(1);
        for (int i = 1; i < 10; i++) {
            int prev_fact = instFacts[i - 1].getFact();
            int num = instFacts[i].getNum();
            instFacts[i].setFact(prev_fact * num);
        }

        for (Factorial fact : instFacts) {
            System.out.println("num: " + fact.getNum() + ", fact: " + fact.getFact());
        }
    }
}
