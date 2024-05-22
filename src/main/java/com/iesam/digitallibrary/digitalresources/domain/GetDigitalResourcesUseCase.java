package com.iesam.digitallibrary.digitalresources.domain;

import com.iesam.digitallibrary.digitalresources.presentation.DigitalResourcePresentation;

import java.util.ArrayList;

public class GetDigitalResourcesUseCase {
    private final DigitalResourceRepository digitalResourceRepository;

    public GetDigitalResourcesUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }

    public ArrayList<DigitalResource> execute() {
        return digitalResourceRepository.getAllResources();
    }
}
