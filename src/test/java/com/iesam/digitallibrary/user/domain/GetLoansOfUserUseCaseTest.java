package com.iesam.digitallibrary.user.domain;

import com.iesam.digitallibrary.loan.domain.Loan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetLoansOfUserUseCaseTest {
    @Mock
    UserRepository userRepository;

    GetLoansOfUserUseCase loansOfUserUseCase;
    @BeforeEach
    public void setUp(){
        loansOfUserUseCase=new GetLoansOfUserUseCase(userRepository);
    }
    @AfterEach
    public void clear(){
        loansOfUserUseCase=null;
    }
    @Test
    public void meDanUnIdYDevuelvoLosPrestamosConEseId(){
        //Given
        ArrayList<Loan> loansExpected= new ArrayList<>();
        Collections.addAll(loansExpected,new Loan("1","001","1"),new Loan("2","001","2"));
        Mockito.when(userRepository.getLoansOfUser("001")).thenReturn(loansExpected);

        //When
        ArrayList<Loan> loansReceived= loansOfUserUseCase.execute("001");

        //Then
        Assertions.assertEquals(loansReceived.size(),loansExpected.size());
        Mockito.verify(userRepository,Mockito.times(1)).getLoansOfUser("001");

        Assertions.assertEquals(loansReceived.get(0).getIdLoan(),"1");
        Assertions.assertEquals(loansReceived.get(0).getIdUser(),"001");
        Assertions.assertEquals(loansReceived.get(0).getIdDigitalResource(),"1");
        Assertions.assertEquals(loansReceived.get(1).getIdLoan(),"2");
        Assertions.assertEquals(loansReceived.get(1).getIdUser(),"001");
        Assertions.assertEquals(loansReceived.get(1).getIdDigitalResource(),"2");
    }
    @Test
    public void siElIdNoCoincideDevuelvoListaNull(){
        //Given
        String idUser="0";
        Mockito.when(userRepository.getLoansOfUser(idUser)).thenReturn(null);

        //When
        ArrayList<Loan> loansReceived=userRepository.getLoansOfUser(idUser);

        //Then
        Mockito.verify(userRepository,Mockito.times(1)).getLoansOfUser(idUser);
        Assertions.assertNull(loansReceived);
    }

}