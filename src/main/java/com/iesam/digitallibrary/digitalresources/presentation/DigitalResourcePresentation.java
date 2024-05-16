package com.iesam.digitallibrary.digitalresources.presentation;

import com.iesam.digitallibrary.digitalresources.data.DigitalResourceDataRepository;
import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.GetDigitalResourcesUseCase;
import com.iesam.digitallibrary.digitalresources.domain.book.presentation.BookPresentation;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitalResourcePresentation {
    public static void menuResource(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir \n1: Entrar al apartado de libros " +
                "\n2: Obtener un listado de todos los recursos digitales");
        int opcion= sc.nextInt();
        switch (opcion){
            case 0:
                break;
            case 1:
                BookPresentation.menuBook();
                break;
            case 2:
                getAllResources();
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
}
