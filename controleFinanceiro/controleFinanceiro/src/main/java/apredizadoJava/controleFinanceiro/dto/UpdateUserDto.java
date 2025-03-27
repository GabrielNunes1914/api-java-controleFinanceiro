package apredizadoJava.controleFinanceiro.dto;

import java.time.LocalDate;

public record UpdateUserDto(String name, String password, LocalDate birthDate) {

}
