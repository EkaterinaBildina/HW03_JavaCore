import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

//@Getter
//@Setter
@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
@Data
public class Employee implements Comparable<Employee> {
    private String FIO;
    private String position;
    private String phone;
    private BigDecimal salary;
    private LocalDate birthDate;


    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }


//    @Override
//    public String toString() {
//
//        return String.format("%s - %s , phone - %s ,salary - %s, age - %s", FIO, position, phone, salary, this.getAge());
//    }

    public void printInfo() {
        System.out.println(this);
    }

    public void increaseSalary(int value) {
        this.salary = salary.add(BigDecimal.valueOf(value));
    }

    // Написать прототип компаратора - метод внутри класса сотрудника,
    // сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд,
    // без использования условного оператора.
    public static Comparator<Employee> ageComparator() {
        return Comparator.comparingInt(Employee::getAge);
    }

    public static void PrintResultOfAgeCompare(Employee emp1, Employee emp2){
        Comparator<Employee> ageComparator = Employee.ageComparator();
        int result = ageComparator.compare(emp1, emp2);

        System.out.println(result);
        if (result < 0) {
            System.out.println(emp1.getFIO() + "is born earlier than " + emp2.getFIO());
        } else if (result > 0) {
            System.out.println(emp2.getFIO() + "is born earlier than " + emp1.getFIO());
        } else {
            System.out.println("Both employees are born on the same date.");
        }
    }


    //Comparable.compareTo(Object o) method implementation can provide default sorting
    @Override
    public int compareTo(Employee emp) {
        //шаблон,в котором будет отображаться дата
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.birthDate.format(dtformat).compareTo(emp.birthDate.format(dtformat));
    }
}
