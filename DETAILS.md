# Details
## Inhaltsangabe 
- [Ablauf der Gruppenarbeit](#ablauf-der-gruppenarbeit) 
- [Gruppeninterne Vorgehensweise](#gruppeninterne-vorgehensweise)
  - [Projektmanangment](#projektmanagment) 
  - [Auswertung der Anforderungsanalyse](#auswertung-der-anforderungsanalyse) 
  
## Ablauf der Gruppenarbeit
Zum Beginn der Gruppenarbeit hat die Gruppe sich eine Thematik für die zu implementierende Anwendung überlegt. Nach langem Überlegen konnte sich die Gruppe auf das Thema **Früherkennung potenzieller Gefahren in Social Media-Beiträgen** einigen. Diese Idee wurde nach der Präsentation und dem kritischen Feedback von Herrn Tobias Horsmann wieder verworfen. Die Grundlage der Social Media Analytics blieb jedoch bestehen. So strukturierte die Gruppe lediglich das Ziel der Analyse um.

Nachdem die Gruppe viel Zeit in die Recherche investiert hatte, hielt sie Rücksprache mit Prof. Dr.-Ing. Torsten Zech. Im Gespräch mit Ihm definierte sich eine Häufigkeitsanalyse der Wörter in Beiträgen als gute Anwendungsfunktionalität. Daraufhin wurde eine **Textanalyse von Twitter-Beiträgen auf prägnante Themeninhalte als Ziel der Anwendung festgelegt**. Herr Tobias Horsmann schickte der Gruppe einen Twitter-Datensatz, an welchem die Analyse getestet werden konnte. An der Häufigkeitsanalyse und dem User-Interface wurde bis zur Abschlusspräsentation gearbeitet.

Die in der Abschlusspräsentation genannten Kritikpunkte hat man bis zur Abgabe versucht umzusetzen. Dies ist mit Ausnahmen auch passiert. Für weitere Funktionalitäten innerhalb der Anwendung war die Zeit zwischen der Abschlusspräsentation und Abgabe der Anwendung neben der Prüfungsphase zu knapp. Parallel zur Implementierung (VERLINKUNG ZUR IMPLEMENTIERUNG) wurde an der [Dokumentation des Praxisprojekts](README.md) gearbeitet.


## Gruppeninterne Vorgehensweise

### Projektmanagment 
Von Anfang an hat die Gruppe versucht sich beim Projektmanagement an den Werte der agile Softwareentwicklung zu orientieren:
- Individuen und Interaktionen vor Tools
- Funktionierende Programme vor ausführliche Spezifikation
- Stetige Zusammenarbeit mit dem Auftraggeber
- Offenheit und Flexibilität vor festgelegten Plan

Diese Werte wurden allerdings im Laufe der Gruppenarbeit durch die Ziele des Projektmanagements eingegrenzt: 
- Qualität
- Ressourcen
- Zeit

Deswegen hat man sich bei der groben Planung für die folgende Vorgehensweise entschieden:
1. Vorphase: Recherche
2. Planung und Organisation: vollständiges Design, Auswahl der Tools und Pipeline Definition
3. Produktion: Implementierung
4. Post-Produktion: Fehler-Korrektur 					

Die Hauptaufgabe wurde in Teilaufgaben unterteilt, die immer wieder miteinander verbunden und abgeglichen wurden.

Nachdem die Idee des Projektes festgelegt haben, wurde die Anforderungsanalyse als weitere Schritt ausgewählt und mittels gemeinsames Brainstormings und mittels Experten-Gespräch durchgef ührt, um das Ziel des Projektes zu definieren.

### Auswertung der Anforderungsanalyse  																							
Business Case: Bei der Analyse der Kommunikation in sozialen Netzwerken in Krisensituation helfen eine Aussage über das Posting-Verhalten von Nutzer sozialer Netzwerke über ein Krisenthema.

Ziel: Eine Anwendung zu programmieren, die eine Analyse über den Posting-Verhalten während einer Krisensituation in sozialen Netzwerken liefert. Die Anwendung untersucht Beiträge in sozialen Netzwerken auf die am häufigsten kommunizierten Wörter in Abhängigkeit des zeitlichen Ablaufs der Krisensituation.

Nutzeranforderungen | Beschreibung
------------------- | ------------
Ziel | Kommunikation in einer Krisensituation zu untersuchen.
Test
Aufgabe | Eine zeitliche Abhängigkeit zwischen einem Ereignis und relevantem Thema festzustellen.
Aktivität | Datenbank hochladen und einen Grafik anzeigen lassen.
Operationen | Datenbank hochladen, Grafik erstellen, die Tendenzen anzeigen lassen.
Sozialer Kontext | Arbeit an der Universität oder allgemeine Datenanalyse.
Rollen | Wissenschaftliche Mitarbeiter, HiWis, SHKs.
Gebraucht | Datenbanken von sozialen Netzwerken, wie Twitter Posting, von Behörden und normalen Nutzer mit der Zeitangabe und Textinhalt.
Resultat | Zuweisung von Textinhalten (Top 5 Wörter) zur zeitlichen Angaben in Form von Diagramm (y-Achse Häufigkeit der Wörter, x-Achse Zeit). Darstellung der Tonalität der relevantesten Wörter. 						 Bild 3.
Kontext | Im Büro am PC an der Universität oder in der Bibliothek. Die Anwendung soll an allen Browser funktionsfähig sein.

Die Dauer der Auftrag: ca 10 Minuten.

Für die geplante Anwendung wurde außerdem das Mockup Modell in Form vom Bild und HTML Seite entwickelt, um die Funktionen der App zu verdeutlichen
