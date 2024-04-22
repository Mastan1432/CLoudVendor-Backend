package com.maha.restdemo.repository;

import com.maha.restdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
}
