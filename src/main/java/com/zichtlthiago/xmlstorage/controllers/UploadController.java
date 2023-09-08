package com.zichtlthiago.xmlstorage.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zichtlthiago.xmlstorage.pojos.agent.Agent;
import com.zichtlthiago.xmlstorage.services.XmlService;

@RestController
@RequestMapping("/upload")
@CrossOrigin("http://localhost:4200")
public class UploadController {

    private final XmlService service;

    public UploadController(XmlService service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void upload(@RequestPart List<MultipartFile> multipartFiles) {     
        List<Agent> lista = service.uploadFiles(multipartFiles);
        for(Agent agent : lista){
            System.out.println(agent.getCode());
        }
    }

    
}
