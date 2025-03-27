package apredizadoJava.controleFinanceiro.dto;



import apredizadoJava.controleFinanceiro.entity.enums.Category;
import apredizadoJava.controleFinanceiro.entity.enums.PaymentMethod;
import apredizadoJava.controleFinanceiro.entity.enums.Status;
import apredizadoJava.controleFinanceiro.entity.enums.TransactionType;

import java.time.LocalDate;

public record CreateFinancialTransactionDto(
        int userId,
        TransactionType type,
        Double amount,
        Category category,
        String description,
        LocalDate date,
        PaymentMethod paymentMethod,
        Status status
) {
}
