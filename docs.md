

https://m.gostudent.at/t-98752389243

# Use cases 	

Meerdere modellen mogelijk:

Methode 1: Diagram 

| Item            | Omschrijving                                                 |
| --------------- | ------------------------------------------------------------ |
| Actor           | Wie gaat mijn systeem gebruiken                              |
| Use case        | Hoe gebruikt de actor het systeem om een doel te behalen binnen je systeem |
| Relationship    | Wanneer actors elkaar raken                                  |
| System boundary | Alles wat binnen het systeem mogelijk is                     |

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\use_cases.png)

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\use_case_diagram_extend_include.png)

## <<include>> Use Case
The time to use the <<include>> relationship is after you have completed the first cut 
description of all your main Use Cases. 
You can now look at the Use Cases and identify common sequences of user-system interaction.

## <<extend>> Use Case
An extending use case is, effectively, an alternate course of the base use case. 
The <<extend>> use case accomplishes this by conceptually inserting additional action 
sequences into the base use-case sequence.

## Sub domeinen/systemen 

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\subsystems.png)

Methode 2: Tabel 

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\use_case_template.png)

## Use case vs. user story

Terwijl een use case specifieker is en direct kijkt naar hoe een systeem zich zal gedragen, is een user story een Agile-ontwikkelingstechniek die zich richt op het resultaat van de activiteiten en het voordeel van het proces dat wordt beschreven.

## MosCoW 

Wat wil een gebruiken MosCoW:

- **M** - **must haves**: deze eisen (*[requirements](https://nl.wikipedia.org/wiki/Requirement)*) *moeten* in het eindresultaat terugkomen, zonder deze eisen is het product niet bruikbaar;
- **S** - **should haves**: deze eisen zijn zeer gewenst, maar zonder is het product wel bruikbaar;
- **C** - **could haves**: deze eisen zullen alleen aan bod komen als er tijd genoeg is;
- **W** - **won't haves**: deze eisen zullen in dit project niet aan bod komen maar kunnen in de toekomst, bij een vervolgproject, interessant zijn.

# Domein modellen 		<- UML
- Object georiënteerd 
- Object types binnen je software
- Conceptuele klassen

Stappen: 

- Identificeer de belangrijke concepten uit het applicatiedomein en lijst ze op.
- Identificeer de belangrijke concepten uit het applicatiedomein en lijst ze op.
- Identificeer de onderlinge relaties tussen concepten.
- Benoem de associaties en duid de multipliciteiten aan.
  - ![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\Associaties.png)

 - -: private
 -  #: protected 
 - +: public

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\klas.png)

- Overerving

  ​		![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\Overerving.png)



Persoon
naam {m, v}
scroe {0, 100}

Persoon heeft 0 of meer autos 
Auto heeft 1 persoon


Een persoon heeft 0 of meerdere lockers
Locker heeft 0 of 1 persoon voor bepaalde tijd

Boek 
8

# UML

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\uml_relationship_notation.png)

## Dependency

can niet bestaan zonder

Wanneer er een verandering optreedt in de structuur of het gedrag van een klasse die gevolgen heeft voor de andere klasse, wordt een dergelijke relatie een afhankelijkheid genoemd. Of, simpel gezegd, we kunnen zeggen dat een klasse die in een andere klasse is opgenomen, een afhankelijkheid wordt genoemd. Het is een unidirectionele relatie.

Ik delete een persoon dat moeten ook al zijn gegevens gewist worden 

## Association

Relatie tussen klasse 

Associatie is een structurele relatie die weergeeft hoe twee entiteiten binnen een systeem met elkaar zijn verbonden of verbonden. Er kunnen verschillende soorten associaties worden gevormd, zoals één-op-één, één-op-veel, veel-op-één, en veel-op-veel. Een ternaire associatie is een associatie die uit drie links bestaat. Zij geeft de statische relatie weer tussen de entiteiten van twee klassen.

één-op-één = 1		1

één-op-veel = 1		1..*	

veel-op-één = 1..*	 1

veel-op-veel = 1..* 	1..*

## Aggregation

wordt meestal overgeslagen want is bijna hetzelfde als association 

wanneer een klasse een collectie is van een andere klasse 

Een aggregatie is een speciale vorm van een associatie. Het geeft een part-of relatie weer. het vormt een binaire relatie, het geen betekent dat het niet meer dan twee klassen kan omvatten. Het is ook bekend als Has-a relatie. Het geeft de richting aan van een object dat in een ander object is opgenomen.

In aggregatie kan een child onafhankelijk van de parent bestaan.

banaan -> fruit 

#### Composition

In een compositierelatie is het kind afhankelijk van de ouder. Het vormt een tweerichtingsrelatie. Het is een speciaal geval van aggregatie. Het staat bekend als Part-of relatie.

![](C:\Users\rikpe\Documents\Software\GoStudent lessen\Lina\domain_model.png)