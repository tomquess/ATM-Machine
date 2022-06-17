package src.main.java;

public class Client {

    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    private boolean isEmployed;
    private Account bankAccount;

    public Client(){};

    public Client(int ID, String firstName, String lastName, int age, boolean isEmployed) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isEmployed = isEmployed;
    }

    public boolean isOver18YearsOld() {
        return this.getAge() > 18;
    }

    public boolean isClientBankAccountNull(){
        return this.bankAccount == null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }
}
