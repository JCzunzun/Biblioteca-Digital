package com.iesam.digitallibrary.digitalresources.presentation;

import com.iesam.digitallibrary.digitalresources.data.DigitalResourceDataRepository;
import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceFileLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.GetDigitalResourceUseCase;
import com.iesam.digitallibrary.digitalresources.domain.GetDigitalResourcesUseCase;
import com.iesam.digitallibrary.digitalresources.domain.book.presentation.BookPresentation;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitalResourcePresentation {
    public static void menuResource(){
        Scanner sc= new Scanner(System.in);
        System.out.println("0: Salir \n1: Entrar al apartado de libros " +
                "\n2: Obtener un listado de todos los recursos digitales" +
                "\n3: Obtener un recurso en especifico");
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
            case 3:
                System.out.println("Digite el id del recurso a visualizar");
                String idView=sc.next();
                getDigitalResource(idView);
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
    private static void getDigitalResource(String id){
        GetDigitalResourceUseCase digitalResourceUseCase= new GetDigitalResourceUseCase(new DigitalResourceDataRepository(new DigitalResourceFileLocalDataSource()));
        DigitalResource resource= digitalResourceUseCase.execute(id);
        System.out.println(resource.toString());
    }
}
