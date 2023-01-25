package no.training.project.model;

import java.util.List;

public class Response {
    private Description descriptions;
    private List<Sole> soles;

    public Description getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Description descriptions) {
        this.descriptions = descriptions;
    }

    public List<Sole> getSoles() {
        return soles;
    }

    public void setSoles(List<Sole> soles) {
        this.soles = soles;
    }
}
