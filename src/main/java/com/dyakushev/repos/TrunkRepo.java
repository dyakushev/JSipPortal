package com.dyakushev.repos;

import com.dyakushev.model.Trunk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrunkRepo extends CrudRepository<Trunk, Long> {
    List<Trunk> findByIpaddress(String ipaddress);

}
