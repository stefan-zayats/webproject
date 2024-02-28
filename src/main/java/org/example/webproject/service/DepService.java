package org.example.webproject.service;

import org.example.webproject.entity.DepResult;
import org.springframework.stereotype.Service;

@Service
public class DepService {

    public DepResult calculateProfit(double amount, int term, String currency, double interestRate) {

        double totalAmount = amount * Math.pow(1 + interestRate / 100, term);

        double cleanProfitAmount = totalAmount - amount;

        double cleanProfitPercentage = (cleanProfitAmount / amount) * 100;

        return new DepResult(cleanProfitAmount, cleanProfitPercentage, currency);
    }

}
