package answers.division;

import answers.division.enums.AttributeType;
import answers.division.enums.Rank;
import answers.division.exceptions.SquadIsFullException;
import answers.division.person.Attribute;
import answers.division.person.Soldier;

public class Main {

    public static void main(String[] args) {
        Soldier soldier = new Soldier("Guy", 19, 10, Rank.PRIVATE);
        soldier.getAttributes();
        Soldier[] soldiers = { soldier };
        Soldier captain = new Soldier("Cap", 21, 20, Rank.SERGEANT);
        Squad squad = new Squad(captain, soldiers);
        try {
            squad.setCaptain(new Soldier("Dude", 20, 13, Rank.SERGEANT));
        } catch (SquadIsFullException e) {
            System.err.println(e.getMessage());
        }

        try {
            squad.setCaptain(soldier);
        } catch (SquadIsFullException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(squad);
        Squad[] squads = { squad };
	    Division division = new Division(squads);
        System.out.println(getAverageDivisionAge(division));
        AttributeType strongestAttribute = getStrongestAttribute(division);
        System.out.println(strongestAttribute);
        System.out.println(getAverageAttributePoints(division, strongestAttribute));
    }

    private static int getAverageDivisionAge(final Division division) {
        int soldierCount = 0;
        int ageSum = 0;
        for (Squad squad : division.getSquads()) {
            ageSum += squad.getCaptain().getAge();
            soldierCount++;
            for (Soldier soldier : squad.getSoldiers()) {
                ageSum += soldier.getAge();
                soldierCount++;
            }
        }
        return ageSum / soldierCount;
    }

    private static AttributeType getStrongestAttribute(final Division division) {
        int strengthSum = 0;
        int agilitySum = 0;
        int intelligenceSum = 0;
        int charismaSum = 0;

        for (Squad squad : division.getSquads()) {
            for (Soldier soldier : squad.getSoldiers()) {
                for (Attribute attribute : soldier.getAttributes()) {
                    switch (attribute.getAttributeType()) {
                        case STRENGTH:
                            strengthSum += attribute.getPoints();
                            break;

                        case AGILITY:
                            agilitySum += attribute.getPoints();
                            break;

                        case INTELLIGENCE:
                            intelligenceSum += attribute.getPoints();
                            break;

                        default: charismaSum += attribute.getPoints();
                    }
                }
            }
        }

        AttributeType strongestAttribute;
        int strongestAttributeSum;
        if (strengthSum > agilitySum) {
            strongestAttribute = AttributeType.STRENGTH;
            strongestAttributeSum = strengthSum;
        } else {
            strongestAttribute = AttributeType.AGILITY;
            strongestAttributeSum = agilitySum;
        }

        if (charismaSum > strongestAttributeSum) {
            strongestAttribute = AttributeType.CHARISMA;
            strongestAttributeSum = charismaSum;
        }

        if (intelligenceSum > strongestAttributeSum) {
            strongestAttribute = AttributeType.INTELLIGENCE;
        }

        return strongestAttribute;
    }

    private static int getAverageAttributePoints(final Division division, final AttributeType attributeType) {
        int soldierCount = 0;
        int points = 0;
        for (Squad squad : division.getSquads()) {
            soldierCount++;
            for (Attribute attribute : squad.getCaptain().getAttributes()) {
                if (attribute.getAttributeType() == attributeType) {
                    points += attribute.getPoints();
                }
            }
            for (Soldier soldier : squad.getSoldiers()) {
                for (Attribute attribute : soldier.getAttributes()) {
                    if (attribute.getAttributeType() == attributeType) {
                        points += attribute.getPoints();
                        soldierCount++;
                    }
                }
            }
        }
        return points / soldierCount;
    }
}
