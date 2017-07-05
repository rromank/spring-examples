package pkg.model;

public class User {

    private long id;
    private String username;
    private String password;
    private int age;
    private int salary;
    private Role role;


    public User() {
    }

    public User(long id, String username, String password, int age, int salary, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
