public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();

        person.setFirstName("Hiroya");
        person.setLastName("Watanabe");
        person.setAddress("Kyoto");
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        person.print();
    }
}
