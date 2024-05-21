package com.iesam.digitallibrary.digitalresources.presentation;

import com.iesam.digitallibrary.digitalresources.data.DigitalResourceDataRepository;
import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.GetAvailableDigitalResourceUseCase;
import com.iesam.digitallibrary.digitalresources.domain.GetDigitalResourceUseCase;
import com.iesam.digitallibrary.digitalresources.domain.GetDigitalResourcesUseCase;
import com.iesam.digitallibrary.digitalresources.domain.book.presentation.BookPresentation;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitalResourcePresentation {
    private static Scanner sc= new Scanner(System.in);
    public static void menuResource(){

        System.out.println("0: Salir \n1: Entrar al apartado de libros " +
                "\n2: Obtener un listado de todos los recursos digitales" +
                "\n3: Obtener un recurso en especifico" +
                "\n4: Obtener un listado de los recursos disponibles");
        int opcion= sc.nextInt();
        switch (opcion){
            default:
                break;
            case 0:
                break;
            case 1:
                BookPresentation.menuBook();
                break;
            case 2:
                getAllResources();
                break;
            case 3:
                getDigitalResource();
                break;
            case 4:
                getAvailableResources();
                break;

        }
    }
    private static void getAllResources(){
        GetDigitalResourcesUseCase getDigitalResourcesUseCase= new GetDigitalResourcesUseCase(new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()));
        ArrayList<DigitalResource> resources= getDigitalResourcesUseCase.execute();
        for(DigitalResource resource: resources){
            System.out.println(resource.toString());
        }
    }
    private static void getDigitalResource(){
        System.out.println("Digite el id del recurso a visualizar");
        String idView=sc.next();
        GetDigitalResourceUseCase digitalResourceUseCase= new GetDigitalResourceUseCase(new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()));
        DigitalResource resource= digitalResourceUseCase.execute(idView);
        System.out.println(resource.toString());
    }
    private static void getAvailableResources(){
        GetAvailableDigitalResourceUseCase availableDigitalResourceUseCase= new GetAvailableDigitalResourceUseCase(new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()));
        ArrayList<DigitalResource> resources= availableDigitalResourceUseCase.execute();
        for(DigitalResource resource: resources){
            System.out.println(resource.toString());
        }
    }
}
