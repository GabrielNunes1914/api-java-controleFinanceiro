package apredizadoJava.controleFinanceiro.service;

import apredizadoJava.controleFinanceiro.dto.CreateFinancialTransactionDto;
import apredizadoJava.controleFinanceiro.entity.FinancialTransaction;
import apredizadoJava.controleFinanceiro.entity.User;
import apredizadoJava.controleFinanceiro.repository.FinancialTransactionRepository;
import apredizadoJava.controleFinanceiro.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialTransactionService {
    private final UserRepository userRepository;
    private FinancialTransactionRepository financialTransactionRepository;

    public FinancialTransactionService(FinancialTransactionRepository financialTransactionRepository, UserRepository userRepository) {
        this.financialTransactionRepository = financialTransactionRepository;
        this.userRepository = userRepository;
    }

    public int createFinancialTransaction(CreateFinancialTransactionDto createFinancialTransactionDto) {
        User user = userRepository.findById(createFinancialTransactionDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        var entity = new FinancialTransaction(
            user,
            createFinancialTransactionDto.type(),
            createFinancialTransactionDto.amount(),
                createFinancialTransactionDto.category(),
                createFinancialTransactionDto.description(),
            createFinancialTransactionDto.date(),
            createFinancialTransactionDto.paymentMethod(),
            createFinancialTransactionDto.status()
        );
        var userSaved = financialTransactionRepository.save(entity);

        return userSaved.getUser().getUserId();
    }
}
