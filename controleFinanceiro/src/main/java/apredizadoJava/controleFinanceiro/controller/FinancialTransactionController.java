package apredizadoJava.controleFinanceiro.controller;

import apredizadoJava.controleFinanceiro.dto.CreateFinancialTransactionDto;
import apredizadoJava.controleFinanceiro.dto.CreateUserDto;
import apredizadoJava.controleFinanceiro.entity.FinancialTransaction;
import apredizadoJava.controleFinanceiro.service.FinancialTransactionService;
import apredizadoJava.controleFinanceiro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/financial-transactions")
public class FinancialTransactionController {
    private FinancialTransactionService financialTransactionService;

    public FinancialTransactionController(FinancialTransactionService financialTransactionService) {
        this.financialTransactionService = financialTransactionService;
    }

    @PostMapping
    public ResponseEntity<FinancialTransaction> createFinancialTransaction(@RequestBody CreateFinancialTransactionDto createFinancialTransactionDto ) {
        var financialTransactionId = financialTransactionService.createFinancialTransaction(createFinancialTransactionDto);
        return ResponseEntity.created(URI.create("/financial-transaction/" + financialTransactionId)).build();
    }
}
