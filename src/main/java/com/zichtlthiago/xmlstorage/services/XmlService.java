package com.zichtlthiago.xmlstorage.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zichtlthiago.xmlstorage.pojos.agent.Agent;
import com.zichtlthiago.xmlstorage.pojos.agent.Agents;

@Service
public class XmlService {
    public List<Agent> uploadFiles(List<MultipartFile> files) {
        
        removeUnsupportedFiles(files);
        List<Agent> agentsList = new ArrayList<>();

        for (MultipartFile file : files) {
            Agents agents = processFile(file);
            if (agents == null)
                continue;
            agentsList.addAll(agents.getAgent());
        }

        if (agentsList.size() > 0) {
            return agentsList;
        } else {
            return null;
        }

    }

    private void removeUnsupportedFiles(List<MultipartFile> files) {

        files.removeIf(f -> !f.getContentType().equals(MediaType.TEXT_XML_VALUE)
                && !f.getContentType().equals(MediaType.APPLICATION_XML_VALUE));

    }

    private Agents processFile(MultipartFile file) {
        Agents agents = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Agents.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            agents = (Agents) unmarshaller.unmarshal(file.getInputStream());
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
        return agents;
    }
}
