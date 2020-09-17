package nsu.shserg.cft_test.controller;

import nsu.shserg.cft_test.dao.HardDiskDAO;
import nsu.shserg.cft_test.entity.HardDisk;
import nsu.shserg.cft_test.entity.Laptop;
import nsu.shserg.cft_test.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin
public class HardDiskController {
    private final HardDiskDAO hardDiskDAO;

    @Autowired
    public HardDiskController(HardDiskDAO hardDiskDAO) {
        this.hardDiskDAO = hardDiskDAO;
    }

    @RequestMapping(method = GET, value = "hardDiskGet")
    public ResponseEntity<HardDisk> get(@RequestParam Long id) {
        Optional<HardDisk> optional = hardDiskDAO.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        HardDisk hardDisk = optional.get();
        return new ResponseEntity<HardDisk>(hardDisk, HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "hardDiskGetAll")
    public ResponseEntity<List<HardDisk>> getAll() {
        return new ResponseEntity<List<HardDisk>>(hardDiskDAO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = POST, value = "hardDiskAdd")
    public HttpStatus add(@RequestBody HardDisk hardDisk) {
        hardDiskDAO.save(hardDisk);
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(method = PATCH, value = "hardDiskUpdate")
    public HttpStatus update(@RequestBody HardDisk hardDisk) {
        Optional<HardDisk> optional = hardDiskDAO.findById(hardDisk.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        hardDiskDAO.save(hardDisk);
        return HttpStatus.ACCEPTED;
    }

}
