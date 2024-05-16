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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetDigitalResourcesUseCaseTest {
    @Mock
    DigitalResourceRepository digitalResourceRepository;
    GetDigitalResourcesUseCase getDigitalResourcesUseCase;

    @BeforeEach
    public void setUp(){
        getDigitalResourcesUseCase= new GetDigitalResourcesUseCase(digitalResourceRepository);
    }
    @AfterEach
    public void clear(){
        getDigitalResourcesUseCase=null;
    }

    @Test
    public void ejecutaElCasoDeUsoYDevuelveUnArraylistEsperado(){
        //Given
        DigitalResource resource= new DigitalResource("1","juan","good","pedro");
        DigitalResource resource1= new DigitalResource("2","camilo","bad","juan");
        ArrayList<DigitalResource> resources= new ArrayList<>();
        resources.add(resource);
        resources.add(resource1);
        Mockito.when(digitalResourceRepository.getAllResources()).thenReturn(resources);

        //When
        ArrayList<DigitalResource> resourcesExpected= getDigitalResourcesUseCase.execute();

        //Then
        Mockito.verify(digitalResourceRepository, Mockito.times(1)).getAllResources();
        Assertions.assertEquals(resourcesExpected.get(0).getId(),"1");
        Assertions.assertEquals(resourcesExpected.get(0).getName(),"juan");
        Assertions.assertEquals(resourcesExpected.get(0).getStateOfDeterioration(),"good");
        Assertions.assertEquals(resourcesExpected.get(0).getAutor(),"pedro");
        Assertions.assertEquals(resourcesExpected.get(1).getId(),"2");
        Assertions.assertEquals(resourcesExpected.get(1).getName(),"camilo");
        Assertions.assertEquals(resourcesExpected.get(1).getStateOfDeterioration(),"bad");
        Assertions.assertEquals(resourcesExpected.get(1).getAutor(),"juan");
    }
    @Test
    public void siLaListaEstaVaciaONoExisteDevuelveNulo(){
        //Given
        Mockito.when(digitalResourceRepository.getAllResources()).thenReturn(null);

        //When
        ArrayList<DigitalResource> resourcesExpected=digitalResourceRepository.getAllResources();

        //Then
        Mockito.verify(digitalResourceRepository,Mockito.times(1)).getAllResources();
        Assertions.assertNull(resourcesExpected);
    }

}