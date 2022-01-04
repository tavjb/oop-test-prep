package answers.division;

import answers.division.enums.Rank;
import answers.division.exceptions.SquadIsFullException;
import answers.division.person.Soldier;

import java.util.Arrays;

public class Squad {
    private Soldier captain;
    private Soldier[] soldiers;

    public Squad(Soldier captain, Soldier[] soldiers) {
        this.captain = captain;
        this.soldiers = soldiers;
    }

    public void setCaptain(Soldier newCaptain) throws SquadIsFullException {
        if (newCaptain.getRank() == Rank.SERGEANT || newCaptain.getRank() == Rank.FIRST_SERGEANT) {
            for (int i = 0; i < soldiers.length; i++) {
                if (soldiers[i] == newCaptain) {
                    Soldier tmp = this.captain;
                    this.captain = newCaptain;
                    soldiers[i] = tmp;
                    return;
                }
            }
            if (soldiers.length > 7) {
                throw new SquadIsFullException();
            }

            Soldier[] newSoldiers = new Soldier[this.soldiers.length + 1];
            for (int i = 0; i < this.soldiers.length; i++) {
                newSoldiers[i] = this.soldiers[i];
            }
            newSoldiers[newSoldiers.length - 1] = this.captain;
            this.soldiers = newSoldiers;
            this.captain = newCaptain;
        } else {
            System.out.println("The suggested captain's rank is too low: " + newCaptain.getRank());
        }
    }

    public Soldier getCaptain() {
        return captain;
    }

    public Soldier[] getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(Soldier[] soldiers) {
        this.soldiers = soldiers;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "captain=" + captain +
                ", soldiers=" + Arrays.toString(soldiers) +
                '}';
    }
}
