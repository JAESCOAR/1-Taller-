package com.software2ex.apiRest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2ex.apiRest.model.Car;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/cars")
public class CarContriller {
    private List <Car> cars;

    public CarContriller(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car[] carsArray = objectMapper.readValue(new ClassPathResource("cars.json").getFile(), Car[].class);
            cars = new ArrayList<>(Arrays.asList(carsArray));
        } catch (IOException e) {
            e.printStackTrace();
            cars = new ArrayList<>();
        }
    }

    @GetMapping
    public List<Car> getAllUsers(){
        return cars;
    }


    @GetMapping("/{id}")
    public Car getUserById(@PathVariable Long id){
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);

    }
    
    @PostMapping
    public Car createUser(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    @PutMapping("/{id}")
    public Car updateUser(@PathVariable Long id, @RequestBody Car updatedUser) {
        Car car = getUserById(id);
        if (car != null) {
            car.setMarca(updatedUser.getMarca());
            car.setModelo(updatedUser.getModelo());
            return car;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
       
}

