package com.iesam.digitallibrary.digitalresources.domain;

public class GetDigitalResourceUseCase {
    private final DigitalResourceRepository digitalResourceRepository;

    public GetDigitalResourceUseCase(DigitalResourceRepository digitalResourceRepository) {
        this.digitalResourceRepository = digitalResourceRepository;
    }
    public DigitalResource execute(String id){
        return digitalResourceRepository.getDigitalResource(id);
    }
}
