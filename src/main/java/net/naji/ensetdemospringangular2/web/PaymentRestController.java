package net.naji.ensetdemospringangular2.web;

import net.naji.ensetdemospringangular2.dtos.NewPaymentDTO;
import net.naji.ensetdemospringangular2.entities.Payment;
import net.naji.ensetdemospringangular2.entities.PaymentStatus;
import net.naji.ensetdemospringangular2.entities.PaymentType;
import net.naji.ensetdemospringangular2.entities.Student;
import net.naji.ensetdemospringangular2.repository.PaymentRepository;
import net.naji.ensetdemospringangular2.repository.StudentRepository;
import net.naji.ensetdemospringangular2.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class PaymentRestController {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;
    private PaymentService paymentService;

    public PaymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository, PaymentService paymentService) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }
    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> paymentsByStudent(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path = "/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }


    @GetMapping(path = "/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }



@GetMapping(path="/payments/{id}")
   public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
   }
   @GetMapping("/students")
   public List<Student> allStudents(){
        return studentRepository.findAll();
   }
   @GetMapping("/students/{code}")
   public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
   }
   @GetMapping("/studentsByProgramId")
   public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
   }
   @PutMapping("/payments/{id}")
   public Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id){
       return paymentService.updatePaymentStatus(status,id);
   }

   @PostMapping(path = "/payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public Payment savePayment(@RequestParam ("file") MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {

       return this.paymentService.savePayment(file, newPaymentDTO);
   }
   @CrossOrigin
   @GetMapping(value = "/payments/{paymentId}/file",produces =  MediaType.APPLICATION_PDF_VALUE)
   public byte[] getPaymentFile(@PathVariable Long paymentId) throws IOException {
        return paymentService.getPaymentFile(paymentId);
   }
}
