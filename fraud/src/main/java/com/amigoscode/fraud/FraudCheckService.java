package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

    public Optional<FraudCheckHistory> findById(Integer customerId) {
        return fraudCheckHistoryRepository.findByCustomerId(customerId);
    }
}
