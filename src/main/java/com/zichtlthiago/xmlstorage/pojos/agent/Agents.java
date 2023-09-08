package com.zichtlthiago.xmlstorage.pojos.agent;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agentes")

public class Agents {

    private List<Agent> agent;

    @XmlElement(name = "agente")
    public List<Agent> getAgent() {
        return agent;
    }

    public void setAgent(List<Agent> agent) {
        this.agent = agent;
    }

}
