package com.iesam.digitallibrary.digitalresources.domain;

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
class GetDigitalResourceUseCaseTest {
    @Mock
    DigitalResourceRepository digitalResourceRepository;

    GetDigitalResourceUseCase digitalResourceUseCase;

    @BeforeEach
    public void setUp(){
        digitalResourceUseCase= new GetDigitalResourceUseCase(digitalResourceRepository);
    }
    @AfterEach
    public void clear(){
        digitalResourceUseCase=null;
    }
    @Test
    public void siElIdEsCorrectoDevuelvoUnRecurso(){
        //Given
        DigitalResource resourceExpected= new DigitalResource("1","Angus","good","juan");
        Mockito.when(digitalResourceRepository.getDigitalResource("1")).thenReturn(resourceExpected);

        //When
        DigitalResource resourceReceived= digitalResourceUseCase.execute("1");

        //Then
        Mockito.verify(digitalResourceRepository,Mockito.times(1)).getDigitalResource("1");

        Assertions.assertEquals(resourceReceived.getId(),"1");
        Assertions.assertEquals(resourceReceived.getName(),"Angus");
        Assertions.assertEquals(resourceReceived.getStateOfDeterioration(),"good");
        Assertions.assertEquals(resourceReceived.getAutor(),"juan");
    }
    @Test
    public void siElIdEsIncorrectoDevuelveNulo(){
        //Given
        String idExp="2";
        Mockito.when(digitalResourceRepository.getDigitalResource(idExp)).thenReturn(null);

        //When
        DigitalResource resource=digitalResourceRepository.getDigitalResource(idExp);

        //Then
        Mockito.verify(digitalResourceRepository, Mockito.times(1)).getDigitalResource(idExp);
    }
}