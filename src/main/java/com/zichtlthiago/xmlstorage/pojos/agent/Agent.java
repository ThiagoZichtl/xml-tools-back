package com.zichtlthiago.xmlstorage.pojos.agent;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Agent {
    
    private Long code;
    private String date;

    private List<Region> regions;

    @XmlElement(name = "codigo")
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @XmlElement(name = "data")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "regiao")
    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
