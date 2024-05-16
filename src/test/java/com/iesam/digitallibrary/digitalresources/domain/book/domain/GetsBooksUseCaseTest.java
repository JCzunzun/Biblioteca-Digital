package com.iesam.digitallibrary.digitalresources.domain.book.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetsBooksUseCaseTest {
    @Mock
    BookRepository bookRepository;
    GetsBooksUseCase getsBooksUseCase;

    @BeforeEach
    public void setUp(){
        getsBooksUseCase=new GetsBooksUseCase(bookRepository);
    }
    @AfterEach
    public void clear(){
        getsBooksUseCase=null;
    }

    @Test
    public void meDevuelvenUnaListaYLaCompruebo(){
        //Given
        Book book= new Book("001","nona","good","pedro","340","light","comedia");
        Book book1= new Book("002","kara","bad","juan","250","dark","sad");
        ArrayList<Book> booksExpected=new ArrayList<>();
        booksExpected.add(book);
        booksExpected.add(book1);
        Mockito.when(bookRepository.getsBooks()).thenReturn(booksExpected);
        //Then
        ArrayList<Book> booksReceived=getsBooksUseCase.execute();

        //When
        Mockito.verify(bookRepository,Mockito.times(1)).getsBooks();
        Assertions.assertEquals(booksReceived.get(0).getId(),"001");
        Assertions.assertEquals(booksReceived.get(0).getName(),"nona");
        Assertions.assertEquals(booksReceived.get(0).getStateOfDeterioration(),"good");
        Assertions.assertEquals(booksReceived.get(0).getAutor(),"pedro");
        Assertions.assertEquals(booksReceived.get(0).getNumberOfPages(),"340");
        Assertions.assertEquals(booksReceived.get(0).getDescription(),"light");
        Assertions.assertEquals(booksReceived.get(0).getGender(),"comedia");
        Assertions.assertEquals(booksReceived.get(1).getId(),"002");
        Assertions.assertEquals(booksReceived.get(1).getName(),"kara");
        Assertions.assertEquals(booksReceived.get(1).getStateOfDeterioration(),"bad");
        Assertions.assertEquals(booksReceived.get(1).getAutor(),"juan");
        Assertions.assertEquals(booksReceived.get(1).getNumberOfPages(),"250");
        Assertions.assertEquals(booksReceived.get(1).getDescription(),"dark");
        Assertions.assertEquals(booksReceived.get(1).getGender(),"sad");
    }
    @Test
    public void siLaListaEstaVaciaDevuelveNulo(){
        //Given
        Mockito.when(bookRepository.getsBooks()).thenReturn(null);

        //Then
        ArrayList<Book> booksReceived=bookRepository.getsBooks();

        //When
        Mockito.verify(bookRepository,Mockito.times(1)).getsBooks();
        Assertions.assertNull(booksReceived);
    }
}