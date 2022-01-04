# Task

Create a 'Division' class that represents
a division in the army.
The division will have several squads, with each
squad having a captain and a few soldiers (captain and soldiers will
be of the same type, 'Soldier').

Each soldier (including the captain) will have several
attributes with each attribute having a type and points (1 - 10)

The squad will have a setCaptain method that sets a new captain
if it's in the right rank (Sergeant or First sergeant)
the new captain could be selected from the current squad members or
from outside the squad, however, the squad cannot have more than 8 members total,
if a new captain is added and there is not enough space in the squad, throw an exception.

Furthermore, write the following static methods:

```
getAverageDivisionAge(division) - gets the average age in the division (including the captain)
getStrongestAttribute(division) - gets the attribute with the most points in the division
getAverageAttributePoints(division, attributeType) - gets the average points in a certain attribute in the squad```
```
## Classes

**Divison**

```
- squads
```

**Squad**
```
- captain
- soldiers 
- setCaptain(Soldier newCaptain) throws SquadIsFullException
```

**Person**
```
- name
- age
```
**Soldier : Person**
```
- seniorityInMonths
- rank
```

**Attribute**
```
- attributeType
- points
```

## Enums

**AttributeType**
```
STRENGTH,
AGILITY,
INTELLIGENCE,
CHARISMA
```

**Rank**
```
PRIVATE,
SERGEANT,
FIRST_SERGEANT,
```

