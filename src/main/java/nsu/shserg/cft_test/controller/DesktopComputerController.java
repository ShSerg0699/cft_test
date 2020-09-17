package nsu.shserg.cft_test.controller;

import nsu.shserg.cft_test.dao.DesktopComputerDAO;
import nsu.shserg.cft_test.entity.DesktopComputer;
import nsu.shserg.cft_test.entity.HardDisk;
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
public class DesktopComputerController {
    private final DesktopComputerDAO desktopComputerDAO;

    @Autowired
    public DesktopComputerController(DesktopComputerDAO desktopComputerDAO) {
        this.desktopComputerDAO = desktopComputerDAO;
    }

    @RequestMapping(method = GET, value = "desktopComputerGet")
    public ResponseEntity<DesktopComputer> get(@RequestParam Long id) {
        Optional<DesktopComputer> optional = desktopComputerDAO.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        DesktopComputer desktopComputer = optional.get();
        return new ResponseEntity<DesktopComputer>(desktopComputer, HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "desktopComputerGetAll")
    public ResponseEntity<List<DesktopComputer>> getAll() {
        return new ResponseEntity<List<DesktopComputer>>(desktopComputerDAO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = POST, value = "desktopComputerAdd")
    public HttpStatus add(@RequestBody DesktopComputer desktopComputer) {
        desktopComputerDAO.save(desktopComputer);
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(method = PATCH, value = "desktopComputerUpdate")
    public HttpStatus update(@RequestBody DesktopComputer desktopComputer) {
        Optional<DesktopComputer> optional = desktopComputerDAO.findById(desktopComputer.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        desktopComputerDAO.save(desktopComputer);
        return HttpStatus.ACCEPTED;
    }
}
