package model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MLTEligibilityDTOWrapper {
    @JsonProperty("RecommendationAvailability")
    MLTEligibilityDTO recommendationAvailability;

    public MLTEligibilityDTO getRecommendationAvailability() {
        return recommendationAvailability;
    }

    public void setRecommendationAvailability(MLTEligibilityDTO recommendationAvailability) {
        this.recommendationAvailability = recommendationAvailability;
    }
}
