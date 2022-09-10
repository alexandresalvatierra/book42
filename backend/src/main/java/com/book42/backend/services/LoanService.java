package com.book42.backend.services;

import org.springframework.stereotype.Service;

import com.book42.backend.repositories.LoanRepository;

@Service
public class LoanService {
  final LoanRepository loanRepository;

  public LoanService(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }
}
