package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResourceRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookRepository;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserRepository;
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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CreateLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    DigitalResourceRepository resourceRepository;
    @Mock
    BookRepository bookRepository;

    CreateLoanUseCase createLoanUseCase;

    @BeforeEach
    public void setUp() {
        createLoanUseCase = new CreateLoanUseCase(loanRepository, userRepository, resourceRepository, bookRepository);
    }

    @AfterEach
    public void clear() {
        createLoanUseCase = null;
    }

    @Test
    public void reciboUnPrestamoYLoGuardo() {
        //Given
        Loan loan = new Loan("1", "1", "1");
        ArrayList<Loan> loansExpected = new ArrayList<>();
        Collections.addAll(loansExpected, new Loan("2", "001", "2"), loan);
        User user = new User("1", "1", "juan", "camilo@camilo", "617929803", "calle", loansExpected);
        Mockito.when(userRepository.getUser(loan.idUser)).thenReturn(user);

        Book book = new Book("1", "juna", "good", "god", "1500", "a", "comedy");
        Mockito.when(bookRepository.obtainBook("1")).thenReturn(book);


        //When
        createLoanUseCase.execute(loan);
        Book bookReceived = bookRepository.obtainBook("1");
        bookRepository.modifiedBook(bookReceived);

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).createLoan(loan);
        Mockito.verify(userRepository, Mockito.times(1)).getUser(loan.idUser);
        Mockito.verify(bookRepository, Mockito.times(1)).obtainBook("1");
        Mockito.verify(userRepository, Mockito.times(1)).modifyUser(any(User.class));
        Mockito.verify(resourceRepository, Mockito.times(1)).getAvailableResource();
        Mockito.verify(bookRepository, Mockito.times(1)).modifiedBook(any(Book.class));

        Assertions.assertEquals(bookReceived.id, "1");
        Assertions.assertEquals(bookReceived.name, "juna");
        Assertions.assertEquals(bookReceived.autor, "god");
        Assertions.assertEquals(bookReceived.stateOfDeterioration, "good");
        Assertions.assertEquals(bookReceived.numberOfPages, "1500");
        Assertions.assertEquals(bookReceived.description, "a");
        Assertions.assertEquals(bookReceived.gender, "comedy");


    }

}