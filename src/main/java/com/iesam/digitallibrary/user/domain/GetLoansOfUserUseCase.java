package com.iesam.digitallibrary.user.domain;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.GetFinishedLoansUseCase;
import com.iesam.digitallibrary.loan.domain.GetLoansPendingUseCase;
import com.iesam.digitallibrary.loan.domain.Loan;

import java.util.ArrayList;

public class GetLoansOfUserUseCase {
    private final UserRepository userRepository;

    public GetLoansOfUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public ArrayList<Loan> execute(String id){

        return userRepository.getLoansOfUser(id);

    }
}
