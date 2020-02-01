public class Customer {
    private String firstName;
    private String lastName;
    public Customer(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void printName() {
        System.out.println(firstName + " " + lastName);
    }
}
