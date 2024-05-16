package com.iesam.digitallibrary.digitalresources.domain.book.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetBookUseCaseTest {
    @Mock
    BookRepository bookRepository;

    GetBookUseCase getBookUseCase;

    @BeforeEach
    public void setUp(){
        getBookUseCase= new GetBookUseCase(bookRepository);
    }
    @AfterEach
    public void clear(){
        getBookUseCase=null;
    }

    @Test
    public void siElIdEsValidoDevuelveUnLibro(){
        //Given
        Book book= new Book("001","pront","good","camilo","1500","little","thriller");
        Mockito.when(bookRepository.obtainBook("001")).thenReturn(book);

        //When
        Book bookReceived=getBookUseCase.execute("001");

        //Then
        Mockito.verify(bookRepository,Mockito.times(1)).obtainBook("001");

        Assertions.assertEquals(bookReceived.getId(),"001");
        Assertions.assertEquals(bookReceived.getName(),"pront");
        Assertions.assertEquals(bookReceived.getStateOfDeterioration(),"good");
        Assertions.assertEquals(bookReceived.getAutor(),"camilo");
        Assertions.assertEquals(bookReceived.getNumberOfPages(),"1500");
        Assertions.assertEquals(bookReceived.getDescription(),"little");
        Assertions.assertEquals(bookReceived.getGender(),"thriller");
    }
    @Test
    public void siElIdNoEsValidoDevuelveNulo(){
        //Given
        String id="002";
        Mockito.when(bookRepository.obtainBook(id)).thenReturn(null);

        //When
        Book bookReceived=bookRepository.obtainBook(id);

        //Then
        Mockito.verify(bookRepository,Mockito.times(1)).obtainBook(id);
        Assertions.assertNull(bookReceived);
    }
}