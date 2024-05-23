package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResourceRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookRepository;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class CreateLoanUseCase {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final DigitalResourceRepository resourceRepository;
    private final BookRepository bookRepository;

    public CreateLoanUseCase(LoanRepository loanRepository, UserRepository userRepository, DigitalResourceRepository resourceRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.resourceRepository = resourceRepository;
        this.bookRepository = bookRepository;
    }

    public void execute(Loan loan) {
        User user = userRepository.getUser(loan.idUser);
        ArrayList<Loan> loans = user.loanActives;
        if (loans == null) {
            loans = new ArrayList<>();
        }
        ArrayList<DigitalResource> digitalResources = resourceRepository.getAvailableResource();
        if (digitalResources == null) {
            digitalResources = new ArrayList<>();
        }
        for (DigitalResource resource : digitalResources) {
            if (loan.idDigitalResource.equals(resource.id)) {
                if (Objects.equals(resource.getType(), "Libro")) {
                    Book book = bookRepository.obtainBook(resource.id);
                    Book book1 = new Book(book.id, book.name, book.stateOfDeterioration, book.autor, "Loaned", book.gender, book.description, book.numberOfPages);
                    bookRepository.modifiedBook(book1);
                }
            }
        }
        loans.add(loan);
        User user1 = UserFactory.build(user.getId(), user.getDni(), user.getName(), user.getEmail(), user.getPhone(), user.getAddres(), loans);
        userRepository.modifyUser(user1);
        loanRepository.createLoan(loan);
    }
}
