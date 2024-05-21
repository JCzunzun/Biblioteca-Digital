package com.iesam.digitallibrary.user.domain;

import com.iesam.digitallibrary.loan.domain.Loan;

import java.util.ArrayList;

public class UserFactory {
    public static User build(String id, String dni, String name, String email, String phone, String addres, ArrayList<Loan> loanActives){
        User user= new User(id,dni,name,email,phone,addres,loanActives);
        return user;
    }
}
