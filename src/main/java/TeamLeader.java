import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TeamLeader extends Employee {
    public TeamLeader(String FIO, String position, String phone, BigDecimal salary, LocalDate birthDate) {
        super(FIO, position, phone, salary, birthDate);
    }

    //Перенесите статический метод повышения зарплаты в класс руководителя
    //модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
    public static void salaryIncreaseForEmployees(List<Employee> employeeList, int ageOlderCondition, int bonusValue) {
        for (Employee employee : employeeList) {
            if (employee instanceof TeamLeader) {
                continue;
            } if (employee.getAge() > ageOlderCondition) {
                employee.increaseSalary(bonusValue);
            }
        }
    }
}
