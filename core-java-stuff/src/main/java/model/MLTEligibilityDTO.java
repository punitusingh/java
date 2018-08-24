package model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

public class MLTEligibilityDTO {
    private List<Integer> items;
    private String modelId;

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
}
