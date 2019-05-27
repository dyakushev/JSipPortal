package com.dyakushev.service;

import com.dyakushev.model.Trunk;
import com.dyakushev.repos.TrunkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrunkService {
    @Autowired
    private TrunkRepo trunkRepo;

    public Trunk findById(Long id) {
        return trunkRepo.findById(id).get();
    }

    public Iterable<Trunk> findAll() {
        return trunkRepo.findAll();
    }

    public Iterable<Trunk> findByIpaddress(String filter) {
        return trunkRepo.findByIpaddress(filter);
    }

    public void save(Trunk trunk) {
        trunkRepo.save(trunk);
    }

    public void removeTrunk(Trunk trunk) {
        trunkRepo.delete(trunk);
    }

    public void saveEditTrunk(Long id, Trunk trunk) {
        Trunk trunkToSave = findById(id);
        trunkToSave.setIpaddress(trunk.getIpaddress());
        trunkToSave.setPort(trunk.getPort());
        trunkToSave.setDescription(trunk.getDescription());
        trunkToSave.setActive(trunk.getActive());
        trunkRepo.save(trunkToSave);
    }
}
