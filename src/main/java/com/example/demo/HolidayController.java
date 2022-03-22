package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class HolidayController {
    @GetMapping("/holiday")
    public List getAll(){
        HolidayDAO holidayDAO=new HolidayDAO();
        return holidayDAO.getAll();
    }

    @GetMapping("/holiday/{id}")
    public Holiday get(@PathVariable int id){
        HolidayDAO holidayDAO=new HolidayDAO();
        return holidayDAO.get(id);
    }

    @PostMapping("/holiday")
    public boolean add(@RequestBody Holiday holiday){
        HolidayDAO holidayDAO=new HolidayDAO();
        return holidayDAO.add(holiday);
    }

    @PutMapping("/holiday/{id}")
    public boolean update(@RequestBody  Holiday holiday){
        HolidayDAO holidayDAO=new HolidayDAO();
        return holidayDAO.update(holiday);
    }

    @DeleteMapping("/holiday/{id}")
    public boolean remove(@PathVariable int id){
        HolidayDAO holidayDAO=new HolidayDAO();
        var holiday=holidayDAO.get(id);
        return holidayDAO.remove(holiday);
    }
}
