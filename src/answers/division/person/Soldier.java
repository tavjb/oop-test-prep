package answers.division.person;

import answers.division.enums.AttributeType;
import answers.division.enums.Rank;

import java.util.Random;

public class Soldier extends Person {
    public Soldier(String name, int age, int seniorityInMonths, Rank rank) {
        super(name, age);
        this.rank = rank;
        this.seniorityInMonths = seniorityInMonths;
    }

    private final Attribute[] attributes = {
        new Attribute(AttributeType.STRENGTH, new Random().nextInt(10) + 1),
        new Attribute(AttributeType.AGILITY, new Random().nextInt(10) + 1),
        new Attribute(AttributeType.CHARISMA, new Random().nextInt(10) + 1),
        new Attribute(AttributeType.INTELLIGENCE, new Random().nextInt(10) + 1)
    };

    private int seniorityInMonths;
    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getSeniorityInMonths() {
        return seniorityInMonths;
    }

    public void setSeniorityInMonths(int seniorityInMonths) {
        this.seniorityInMonths = seniorityInMonths;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }
}
