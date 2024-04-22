package com.maha.restdemo.service.impl;

import com.maha.restdemo.exception.CloudVendorNotFoundException;
import com.maha.restdemo.model.CloudVendor;
import com.maha.restdemo.repository.CloudVendorRepository;
import com.maha.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
         cloudVendorRepository.save(cloudVendor);
        return "successs";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "deleted success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Cloud Vendor Does not Exist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return  cloudVendorRepository.findAll();
    }
}
