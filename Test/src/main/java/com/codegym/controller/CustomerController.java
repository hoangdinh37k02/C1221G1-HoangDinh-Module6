package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.Type;
import com.codegym.service.ICustomerService;
import com.codegym.service.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping(value = "")
    public ResponseEntity<Page<Customer>> getAllEmployee(@RequestParam Optional<String> name,
                                                         @RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "2") Integer size) {
        String nameVal =name.orElse("");
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customers = this.iCustomerService.getAll(nameVal,pageable);
        if (!customers.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/type")
    public ResponseEntity<List<Type>> getAllPosition(){
        List<Type> typeList = this.iTypeService.getAll();
        if(typeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeList,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {
        Customer customer = this.iCustomerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Customer> deleteEmployeeById(@PathVariable int id) {
        Customer customer = this.iCustomerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iCustomerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createCustomer(@Validated @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        customerDto.setFlag(true);
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<List<FieldError>> updateCustomer(@PathVariable int id,
                                                           @Validated @RequestBody CustomerDto customerDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> customerOptional = Optional.ofNullable(iCustomerService.findCustomerById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDto.setCustomerId(customerOptional.get().getCustomerId());
        customerDto.setFlag(true);
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
