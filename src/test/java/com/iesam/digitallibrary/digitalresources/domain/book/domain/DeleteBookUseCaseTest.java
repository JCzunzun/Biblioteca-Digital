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
class DeleteBookUseCaseTest {
    @Mock
    BookRepository bookRepository;
    DeleteBookUseCase deleteBookUseCase;

    @BeforeEach
    public void setUp(){
        deleteBookUseCase=new DeleteBookUseCase(bookRepository);
    }
    @AfterEach
    public void clear(){
        deleteBookUseCase=null;
    }

    @Test
    public void mePasanUnIdYBorroElLibro(){
        //Given
        String id="001";

        //Then
        deleteBookUseCase.execute(id);

        //When
        Mockito.verify(bookRepository,Mockito.times(1)).deleteBook(id);
    }
}