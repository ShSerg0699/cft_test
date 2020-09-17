package nsu.shserg.cft_test.controller;

import nsu.shserg.cft_test.dao.LaptopDAO;
import nsu.shserg.cft_test.entity.Laptop;
import nsu.shserg.cft_test.entity.Monitor;
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
public class LaptopController {
    private final LaptopDAO laptopDAO;

    @Autowired
    public LaptopController(LaptopDAO laptopDAO) {
        this.laptopDAO = laptopDAO;
    }

    @RequestMapping(method = GET, value = "laptopGet")
    public ResponseEntity<Laptop> get(@RequestParam Long id) {
        Optional<Laptop> optional = laptopDAO.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        Laptop laptop = optional.get();
        return new ResponseEntity<Laptop>(laptop, HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "laptopGetAll")
    public ResponseEntity<List<Laptop>> getAll() {
        return new ResponseEntity<List<Laptop>>(laptopDAO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = POST, value = "laptopAdd")
    public HttpStatus add(@RequestBody Laptop laptop) {
        laptopDAO.save(laptop);
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(method = PATCH, value = "laptopUpdate")
    public HttpStatus update(@RequestBody Laptop laptop) {
        Optional<Laptop> optional = laptopDAO.findById(laptop.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        laptopDAO.save(laptop);
        return HttpStatus.ACCEPTED;
    }

}
