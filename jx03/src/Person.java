public class Person {
    private String lastName;
    private String firstName;
    private String address;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String add) {
        this.address = add;
    }

    public void print() {
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
    }
}
