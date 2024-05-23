package com.iesam.digitallibrary.loan.domain;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResourceRepository;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.Book;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookFactory;
import com.iesam.digitallibrary.digitalresources.domain.book.domain.BookRepository;
import com.iesam.digitallibrary.user.data.UserDataRepository;
import com.iesam.digitallibrary.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.user.domain.ModifyUserUseCase;
import com.iesam.digitallibrary.user.domain.User;
import com.iesam.digitallibrary.user.domain.UserFactory;
import com.iesam.digitallibrary.user.domain.UserRepository;

import java.util.ArrayList;

public class DeleteLoanOfUserUseCase {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final DigitalResourceRepository resourceRepository;
    private final BookRepository bookRepository;

    public DeleteLoanOfUserUseCase(LoanRepository loanRepository, UserRepository userRepository, DigitalResourceRepository resourceRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.resourceRepository = resourceRepository;
        this.bookRepository = bookRepository;
    }

    public void execute(String id) {

        Loan loan = loanRepository.obtainSpecifiedLoan(id);
        User user = userRepository.getUser(loan.idUser);
        DigitalResource resource = resourceRepository.getDigitalResource(loan.idDigitalResource);
        if (resource.getType().equals("Libro")) {
            Book book = bookRepository.obtainBook(resource.id);
            Book book1 = BookFactory.Build(book.id, book.name, book.stateOfDeterioration, book.autor, "Available", book.gender, book.description, book.numberOfPages);
            bookRepository.modifiedBook(book1);
        }
        ArrayList<Loan> loansUser = user.getLoanActives();

        loansUser.removeIf(loanDelete -> loan.idLoan.equals(loanDelete.idLoan));

        User userModified = UserFactory.build(user.getId(), user.getDni(), user.getName(), user.getEmail(), user.getPhone(), user.getAddres(), loansUser);
        userRepository.modifyUser(userModified);
    }
}
