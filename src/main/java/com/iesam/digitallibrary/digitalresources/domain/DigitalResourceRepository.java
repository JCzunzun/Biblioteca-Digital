package com.iesam.digitallibrary.digitalresources.domain;

import java.util.ArrayList;

public interface DigitalResourceRepository {
    ArrayList<DigitalResource> getAllResources();
    DigitalResource getDigitalResource(String id);
    ArrayList<DigitalResource> getAvailableResource();

}
