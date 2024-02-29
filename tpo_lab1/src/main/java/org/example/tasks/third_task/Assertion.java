package org.example.tasks.third_task;

import java.util.Arrays;

public class Assertion {

    private HumanFeature[] goodFeatures = {HumanFeature.АВАНТЮРИСТ, HumanFeature.ТУСОВЩИК};
    private HumanFeature[] badFeatures = new HumanFeature[]{HumanFeature.НАРЦИССИСТ, HumanFeature.ТЯЖЕЛЫЙ_В_ОБЩЕНИИ};

    HumanBeing author;
    HumanBeing object;

    HumanFeature feature;

    private FeatureRate rate;

    public FeatureRate getRate() {
        return rate;
    }

    public void setRate(FeatureRate rate) {
        this.rate = rate;
    }

    public Assertion(HumanBeing author, HumanBeing object, HumanFeature feature, FeatureRate rate) throws RuntimeException {
        if (author == null || object == null || feature == null) {
            throw new RuntimeException("some of necessary parameters are null");
        }
        this.author = author;
        this.object = object;
        this.feature = feature;
        this.rate = rate;

        for (int i = 0; i < goodFeatures.length; i++) {
            if (feature.equals(goodFeatures[i])) {
                object.setCurrentState(object.getCurrentState() + 10);
            }
        }

        for (int i = 0; i < badFeatures.length; i++) {
            if (feature.equals(badFeatures[i])) {
                object.setCurrentState(object.getCurrentState() - 10);
            }
        }

    }
}
