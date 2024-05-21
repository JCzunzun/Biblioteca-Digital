package com.iesam.digitallibrary.digitalresources.domain;

import java.util.ArrayList;

public class GetAvailableDigitalResourceUseCase {
    private final DigitalResourceRepository digitalResourceRepository;

    public GetAvailableDigitalResourceUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }
    public ArrayList<DigitalResource> execute(){
        return digitalResourceRepository.getAvailableResource();
    }
}
