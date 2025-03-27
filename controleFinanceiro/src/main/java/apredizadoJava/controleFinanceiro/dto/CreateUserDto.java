package apredizadoJava.controleFinanceiro.dto;

import java.time.LocalDate;

public record CreateUserDto(String name, String email, String password, LocalDate birthDate) {

}
