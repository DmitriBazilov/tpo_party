package org.example.tasks.third_task;

public class HumanBeing {


    private final double maxCurrentState = 100;
    private final double minCurrentState = 0;

    private double currentState;

    public double getCurrentState() {
        return currentState;
    }

    public void setCurrentState(double currentState) {
        if (currentState < minCurrentState) {
            this.currentState = minCurrentState;
            return;
        } else if (currentState > maxCurrentState) {
            this.currentState = maxCurrentState;
            return;
        }
        this.currentState = currentState;
    }

    private String name;

    private HumanFeature publicOpinion;
    private FeatureRate featureRate;

    public HumanFeature getPublicOpinion() {
        return publicOpinion;
    }

    public void setPublicOpinion(HumanFeature publicOpinion) {
        this.publicOpinion = publicOpinion;
    }

    public FeatureRate getRate() {
        return featureRate;
    }

    public void setFeatureRate(FeatureRate rate) {
        this.featureRate = rate;
    }

    public HumanBeing(String name) {
        this.name = name;
        this.currentState = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
