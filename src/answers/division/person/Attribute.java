package answers.division.person;

import answers.division.enums.AttributeType;

public class Attribute {
    public Attribute(AttributeType attribute, int points) {
        this.attributeType = attribute;
        this.points = points;
    }

    private AttributeType attributeType;
    private int points;

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
