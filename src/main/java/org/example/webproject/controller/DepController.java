package org.example.webproject.controller;

import lombok.AllArgsConstructor;
import org.example.webproject.entity.DepResult;
import org.example.webproject.service.DepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/dep")
public class DepController {
    private final DepService depService;

    @GetMapping
    public DepResult calculateDep(
            @RequestParam double amount,
            @RequestParam int term,
            @RequestParam(defaultValue = "USD") String currency,
            @RequestParam(name = "rate") double interestRate,
            @RequestParam(required = false, name = "cap", defaultValue = "year") String capitalization) {

        return depService.calculateProfit(amount, term, currency, interestRate, capitalization);
    }
}
