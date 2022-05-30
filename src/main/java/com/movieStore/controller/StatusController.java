package com.movieStore.controller;

import com.movieStore.model.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for Status
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public List<Status> getAllStatus(){
        return null;
    }

    @GetMapping("/{id}")
    public List<Status> getAllStatus(@PathVariable("id") Long id){
        return null;
    }

}
