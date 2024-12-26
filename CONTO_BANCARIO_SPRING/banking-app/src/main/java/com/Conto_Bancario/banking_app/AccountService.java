package com.Conto_Bancario.banking_app;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account creaAccount(String nome, Double saldo) {
        Account account = new Account();
        account.setNome(nome);
        account.setSaldo(saldo);
        return accountRepository.save(account);
    }

    public Optional<Account> recuperaSaldo(Integer id) {
        return accountRepository.findById(id);
    }

    public Account deposito(Integer id, Double importo) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account non trovato"));
        account.setSaldo(account.getSaldo() + importo);
        return accountRepository.save(account);
    }

    public Account prelievo(Integer id, Double importo) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account non trovato"));
        if (account.getSaldo() < importo) {
            throw new RuntimeException("Saldo insufficiente");
        }
        account.setSaldo(account.getSaldo() - importo);
        return accountRepository.save(account);
    }
}
