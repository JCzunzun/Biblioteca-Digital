package com.iesam.digitallibrary.digitalresources.data.local;

import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;

import java.util.ArrayList;

public interface DigitalResourceLocalDataSource {
    void createDigitalResource(DigitalResource digitalResource);
    ArrayList<DigitalResource> getAllResources();
    DigitalResource getDigitalResource(String id);
}
