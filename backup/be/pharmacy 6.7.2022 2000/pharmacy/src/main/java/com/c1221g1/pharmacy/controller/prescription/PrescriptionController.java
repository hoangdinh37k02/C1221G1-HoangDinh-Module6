package com.c1221g1.pharmacy.controller.prescription;

import com.c1221g1.pharmacy.dto.prescription.IMedicinePrescriptionDto;
import com.c1221g1.pharmacy.dto.prescription.PrescriptionDto;
import com.c1221g1.pharmacy.entity.prescription.Prescription;
import com.c1221g1.pharmacy.service.prescription.IPrescriptionService;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/manager-prescription/prescriptions")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService prescriptionService;

    /**
     * HienTLD
     * Danh sách toa thuốc và tìm kiếm
     * 16:00 29/06/2022
     */
    @GetMapping("")
    public ResponseEntity<Page<Prescription>> getPageAndSearchPrescription(@RequestParam Optional<String> id,
                                                                           @RequestParam Optional<String> names,
                                                                           @RequestParam Optional<String> target,
                                                                           @RequestParam Optional<String> symptom,
                                                                           @RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "5") Integer pageSize,
                                                                           @RequestParam Optional<String> sort,
                                                                           @RequestParam Optional<String> dir) {
        Pageable pageable;
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if (dirVal.equals("desc")) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            } else if (dirVal.equals("asc")){
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            }
        }

        String idVal = id.orElse("");
        String nameVal = names.orElse("");
        String targetVal = target.orElse("");
        String symptomVal = symptom.orElse("");

        Page<Prescription> prescriptionPage = this.prescriptionService.findAllPageAndSearch(pageable, idVal, nameVal, targetVal, symptomVal);

        if (!prescriptionPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prescriptionPage, HttpStatus.OK);
    }

    /**
     * HienTLD
     * Chi tiết toa thuốc
     * 16:30 29/06/2022
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<IMedicinePrescriptionDto> getInfoPrescription(@PathVariable String id) {

        IMedicinePrescriptionDto medicinePrescriptionDto = this.prescriptionService.getPrescriptionById(id);

        if (medicinePrescriptionDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(medicinePrescriptionDto, HttpStatus.OK);
    }

    /**
     * HienTLD
     * Thêm mới toa thuốc
     * 16:30 29/06/2022
     */
    @PostMapping(value = "")
    public ResponseEntity<List<FieldError>> createPrescription(@Validated @RequestBody PrescriptionDto prescriptionDto,
                                                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        Prescription prescription = new Prescription();

        prescriptionDto.setFlag(true);

        BeanUtils.copyProperties(prescriptionDto, prescription);

        this.prescriptionService.save(prescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * HienTLD
     * Xoá toa thuốc (xoá theo cờ 'flag')
     * 16:00 29/06/2022
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable("id") String id) {
        try {
            this.prescriptionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * HienTLD
     * Sửa toa thuốc (xoá theo cờ 'flag')
     * update 11:18 30/06/2022
     */
    @PatchMapping("/{id}")
    public ResponseEntity<List<FieldError>> editSmartPhone(@Validated @RequestBody PrescriptionDto prescriptionDto,
                                                           BindingResult bindingResult,
                                                           @PathVariable String id) throws NotEmpty {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Prescription prescription = new Prescription();

        prescription.setPrescriptionId(id);

        prescription.setFlag(true);

        BeanUtils.copyProperties(prescriptionDto, prescription);

        this.prescriptionService.edit(prescription);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}