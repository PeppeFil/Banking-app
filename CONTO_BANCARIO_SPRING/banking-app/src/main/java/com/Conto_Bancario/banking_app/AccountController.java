package com.Conto_Bancario.banking_app;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> creaAccount(@RequestParam String nome, @RequestParam Double saldo) {
        return ResponseEntity.ok(accountService.creaAccount(nome, saldo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> recuperaSaldo(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.recuperaSaldo(id));
    }

    @PutMapping("/{id}/deposito")
    public ResponseEntity<Account> deposito(@PathVariable Integer id, @RequestParam Double importo) {
        return ResponseEntity.ok(accountService.deposito(id, importo));
    }

    @PutMapping("/{id}/prelievo")
    public ResponseEntity<Account> prelievo(@PathVariable Integer id, @RequestParam Double importo) {
        return ResponseEntity.ok(accountService.prelievo(id, importo));
    }
}
