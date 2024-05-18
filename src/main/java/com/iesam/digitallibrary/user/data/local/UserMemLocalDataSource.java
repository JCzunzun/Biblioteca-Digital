package com.iesam.digitallibrary.user.data.local;

import com.iesam.digitallibrary.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.loan.domain.GetFinishedLoansUseCase;
import com.iesam.digitallibrary.loan.domain.GetLoansPendingUseCase;
import com.iesam.digitallibrary.loan.domain.Loan;
import com.iesam.digitallibrary.user.domain.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UserMemLocalDataSource implements UserLocalDataSource {
    ArrayList<User> users = new ArrayList<>();
    private static UserMemLocalDataSource instance = null;

    public UserMemLocalDataSource newInstance() {
        if (instance == null) {
            instance = new UserMemLocalDataSource();
        }
        return instance;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUSer(String id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void modifyUser(User user) {
        deleteUSer(user.getId());
        createUser(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Loan> obtainLoansOfUser(String id) {
        ArrayList<Loan> loans= new ArrayList<>();
        GetLoansPendingUseCase loansPendingUseCase= new GetLoansPendingUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loansPending= loansPendingUseCase.execute();
        for(Loan loan: loansPending){
            if(loan.getIdUser().equals(id)){
                loans.add(loan);
            }
        }
        GetFinishedLoansUseCase finishedLoansUseCase=new GetFinishedLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        ArrayList<Loan> loansFinish=finishedLoansUseCase.execute();
        for(Loan loan:loansFinish){
            if(loan.getIdUser().equals(id)){
                loans.add(loan);
            }
        }
        return loans;
    }
}
