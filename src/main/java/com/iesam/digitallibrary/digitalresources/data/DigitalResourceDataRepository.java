package com.iesam.digitallibrary.digitalresources.data;

import com.iesam.digitallibrary.digitalresources.data.local.DigitalResourceLocalDataSource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResource;
import com.iesam.digitallibrary.digitalresources.domain.DigitalResourceRepository;

import java.util.ArrayList;

public class DigitalResourceDataRepository implements DigitalResourceRepository {
    DigitalResourceLocalDataSource digitalResourceLocalDataSource;
    public DigitalResourceDataRepository (DigitalResourceLocalDataSource digitalResourceLocalDataSource){
        this.digitalResourceLocalDataSource=digitalResourceLocalDataSource;
    }

    @Override
    public ArrayList<DigitalResource> getAllResources() {
        return digitalResourceLocalDataSource.getAllResources();
    }
}
