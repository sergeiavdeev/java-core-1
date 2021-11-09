package ru.avdeev.lesson5;

public class Employee {

    private static final String personType = "Сотрудник";
    private static final int SALARY_UPGRADE = 10000;

    private final String name;
    private final String position;
    private final String email;
    private final String phone;

    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {

        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {

        return personType + " " + name + "\nДолжность: " + position + "\ne-mail: " + email
                + "\nТелефон: " + phone + "\nОклад: " + salary + "\nВозвраст: " + age + "\n";
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void birthday() {
        age++;
    }

    public void upgrade() {
        salary += SALARY_UPGRADE;
    }
}
