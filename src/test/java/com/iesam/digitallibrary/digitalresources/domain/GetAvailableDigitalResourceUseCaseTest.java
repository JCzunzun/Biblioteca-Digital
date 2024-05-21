package com.iesam.digitallibrary.digitalresources.domain;

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
class GetAvailableDigitalResourceUseCaseTest {
    @Mock
    DigitalResourceRepository digitalResourceRepository;
    GetAvailableDigitalResourceUseCase availableDigitalResourceUseCase;

    @BeforeEach
    public void setUp(){
        availableDigitalResourceUseCase= new GetAvailableDigitalResourceUseCase(digitalResourceRepository);
    }
    @AfterEach
    public void clear(){
        availableDigitalResourceUseCase= null;
    }

    @Test
    public void reciboUnaListaYLaCompruebo(){
        //Given
        ArrayList<DigitalResource> resourcesExpected= new ArrayList<>();
        Collections.addAll(resourcesExpected,
                new DigitalResource("1","juanito","good","juan"),
                new DigitalResource("2","camiloncho","bad","azael"));
        Mockito.when(digitalResourceRepository.getAvailableResource()).thenReturn(resourcesExpected);

        //When
        ArrayList<DigitalResource> resourcesReceived= availableDigitalResourceUseCase.execute();

        //Then
        Assertions.assertEquals(resourcesExpected.size(),resourcesReceived.size());
        Mockito.verify(digitalResourceRepository,Mockito.times(1)).getAvailableResource();

        Assertions.assertEquals(resourcesReceived.get(0).id,"1");
        Assertions.assertEquals(resourcesExpected.get(0).name,"juanito");
        Assertions.assertEquals(resourcesReceived.get(0).stateOfDeterioration,"good");
        Assertions.assertEquals(resourcesReceived.get(0).autor,"juan");

        Assertions.assertEquals(resourcesReceived.get(1).id,"2");
        Assertions.assertEquals(resourcesExpected.get(1).name,"camiloncho");
        Assertions.assertEquals(resourcesReceived.get(1).stateOfDeterioration,"bad");
        Assertions.assertEquals(resourcesReceived.get(1).autor,"azael");

    }

    @Test
    public void reciboUnaListaNulaYDevuelvoNulo(){
        Mockito.when(digitalResourceRepository.getAvailableResource()).thenReturn(null);

        ArrayList<DigitalResource> resourcesReceived= availableDigitalResourceUseCase.execute();

        Mockito.verify(digitalResourceRepository,Mockito.times(1)).getAvailableResource();
        Assertions.assertNull(resourcesReceived);
    }
}