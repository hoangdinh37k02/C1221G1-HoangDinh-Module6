package com.exam.controller;

import com.exam.dto.ThongKe;
import com.exam.dto.TourDto;
import com.exam.model.LoaiTour;
import com.exam.model.PhamVi;
import com.exam.model.Tour;
import com.exam.service.ILoaiTourService;
import com.exam.service.IPhamViService;
import com.exam.service.ITourService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "tour")
public class TourController {
    @Autowired
    private ITourService iTourService;
    @Autowired
    private IPhamViService iPhamViService;
    @Autowired
    private ILoaiTourService iLoaiTourService;

    @GetMapping("/tour")
    public ResponseEntity<List<Tour>> getTour() {
        List<Tour> tourList = this.iTourService.getList();
        if (tourList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tourList, HttpStatus.OK);
    }

    @GetMapping(value = "/loaiTour")
    public ResponseEntity<List<LoaiTour>> getLoaiTour(){
        List<LoaiTour> loaiTourList = this.iLoaiTourService.getAll();
        if(loaiTourList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(loaiTourList,HttpStatus.OK);
    }

    @GetMapping(value = "/phamVi")
    public ResponseEntity<List<PhamVi>> getPhamVi(){
        List<PhamVi> phamViList = this.iPhamViService.getAll();
        if(phamViList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phamViList,HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createTour(@Validated @RequestBody TourDto tourDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Tour tour = new Tour();
        BeanUtils.copyProperties(tourDto, tour);
        this.iTourService.save(tour);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Tour> deleteTourById(@PathVariable int id) {
        Tour tour = this.iTourService.findById(id);
        if (tour == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iTourService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/thongKe")
    public ResponseEntity<List<ThongKe>> getThongKe(){
        List<ThongKe> thongKe = this.iTourService.getThongKe();
        if(thongKe.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(thongKe,HttpStatus.OK);
    }
}
