package apredizadoJava.controleFinanceiro.repository;

import apredizadoJava.controleFinanceiro.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Integer> {
}
