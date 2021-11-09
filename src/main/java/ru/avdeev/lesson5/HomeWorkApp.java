package ru.avdeev.lesson5;

public class HomeWorkApp {

    private static final int OLD_AGE = 40;

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван", "Инженер", "11@11.ru",
                "88001234578", 150000, 41);
        employees[1] = new Employee("Петров Петр", "Разработчик", "12@11.ru",
                "88001234571", 130000, 30);
        employees[2] = new Employee("Павлов Павел", "Директор", "13@11.ru",
                "88001234572", 350000, 45);
        employees[3] = new Employee("Сидоров Сидор", "Руководитель", "14@11.ru",
                "88001234573", 250000, 40);
        employees[4] = new Employee("Глызин Алексей", "Инженер", "15@11.ru",
                "88001234574", 150000, 32);

        employees[3].birthday();
        employees[3].upgrade();

        for (Employee employee : employees) {
            if (employee.getAge() > OLD_AGE) employee.printInfo();
        }
    }
}
