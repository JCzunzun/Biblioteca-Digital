package com.iesam.digitallibrary.digitalresources.domain.book.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateBookUseCaseTest {
    @Mock
    BookRepository bookRepository;
    CreateBookUseCase createBookUseCase;

    @BeforeEach
    public void setUp(){
        createBookUseCase=new CreateBookUseCase(bookRepository);
    }
    @AfterEach
    public void clear(){
        createBookUseCase=null;
    }

    @Test
    public void mePasanUnLibroYLoGuardo(){
        //Given
        Book book= new Book("001","nona","good","pedro","340","light","comedia");

        //Then
        createBookUseCase.execute(book);

        //When
        Mockito.verify(bookRepository,Mockito.times(1)).createBook(book);
    }
}