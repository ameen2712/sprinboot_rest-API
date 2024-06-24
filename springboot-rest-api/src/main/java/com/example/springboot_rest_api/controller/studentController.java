package com.example.springboot_rest_api.controller;

import com.example.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class studentController {
    //http::localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getstudent(){
        Student student = new Student(
                1,"ameen","ahammad"
        );
       // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","ameen")
                .body(student);
    }

    //http::localhost:8080/Students
  @GetMapping
    public ResponseEntity<List<Student>> getstudentlist(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"mazza","ahamad"));
        students.add(new Student(3,"firdo","parveen"));
        students.add(new Student(4,"karimulla","mohammad"));
        return ResponseEntity.ok(students);
    }
//    //there are three methods in path variable
//@GetMapping("{id}")
//    public student getpathvariable(@PathVariable int id){
//        return new student(id, "sabira","mohammad");
//    }
//@GetMapping("{id}")
//    public student getpathvariable2(@PathVariable("id")int studentId){
//        return new student(studentId,"sabira","mohammad");
//    }
//@GetMapping("{id}/{name}/{lastname}")
//    public student getpathvariable3(@PathVariable("id") int studentId ,
//                                    @PathVariable("name") String name,
//                                    @PathVariable("lastname") String lastname){
//        return new student(studentId,name,lastname);
//    }
    //http://localhost:8080/students/query?id=1
//    @GetMapping("query")
//    public student getpathvariable(@RequestParam int id){
//        return new student(id, "ameen","ahammad");
//    }
    //http://localhost:8080/students/query?id=1&name=ameen&lastname=ahammad
//    @GetMapping("query")
//    public student getpathvariable(@RequestParam int id,@RequestParam String name ,@RequestParam String lastname){
//        return new student(id,name,lastname);
//    }



    // rest-API which is used to get data from the user by using
    // @PostMapping and @RequestBody

  @PostMapping("post")
    public ResponseEntity<Student> createdetails(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getLastname());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updatestudentdetails(@RequestBody Student student, @PathVariable("id")  int studentId ){
        System.out.println(student.getName());
        System.out.println(student.getLastname());
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deletestudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student details deleted successfully");
    }
}

