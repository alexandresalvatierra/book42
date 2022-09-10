package com.book42.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book42.backend.services.LoanService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/books/{id}/loan")
public class LoanController {
  final LoanService loanService;

  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  /* @PostMapping
  public ResponseEntity<Object> saveBook(@RequestBody @Valid BookDto bookDto){
      if(bookService.existsByLicensePlateCar(bookDto.getLicensePlateCar())){
          return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
      }
      if(bookService.existsByParkingSpotNumber(bookDto.getParkingSpotNumber())){
          return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
      }
      if(bookService.existsByApartmentAndBlock(bookDto.getApartment(), bookDto.getBlock())){
          return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
      }
      var book = new Book();
      BeanUtils.copyProperties(bookDto, book);
      book.setCreated_at(LocalDateTime.now(ZoneId.of("UTC")));
      return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
  } */
}
