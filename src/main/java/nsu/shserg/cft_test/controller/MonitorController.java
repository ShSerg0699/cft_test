package nsu.shserg.cft_test.controller;

import nsu.shserg.cft_test.dao.MonitorDAO;
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
public class MonitorController {
    private final MonitorDAO monitorDAO;

    @Autowired
    public MonitorController(MonitorDAO monitorDAO) {
        this.monitorDAO = monitorDAO;
    }

    @RequestMapping(method = GET, value = "monitorGet")
    public ResponseEntity<Monitor> get(@RequestParam Long id) {
        Optional<Monitor> optional = monitorDAO.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        Monitor monitor = optional.get();
        return new ResponseEntity<Monitor>(monitor, HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "monitorGetAll")
    public ResponseEntity<List<Monitor>> getAll() {
        return new ResponseEntity<List<Monitor>>(monitorDAO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = POST, value = "monitorAdd")
    public HttpStatus add(@RequestBody Monitor monitor) {
        monitorDAO.save(monitor);
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(method = PATCH, value = "monitorUpdate")
    public HttpStatus update(@RequestBody Monitor monitor) {
        Optional<Monitor> optional = monitorDAO.findById(monitor.getId());
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        monitorDAO.save(monitor);
        return HttpStatus.ACCEPTED;
    }

}
