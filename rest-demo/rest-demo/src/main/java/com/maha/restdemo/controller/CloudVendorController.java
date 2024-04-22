package com.maha.restdemo.controller;

import com.maha.restdemo.model.CloudVendor;
import com.maha.restdemo.response.ResponseHandler;
import com.maha.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return  ResponseHandler.responseBuilder("Requested Vendor details given  here", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }



   @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor ctreated successfully";

    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloudvendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloudvendor deleted successfully";
    }


}
