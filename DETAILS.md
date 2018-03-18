# Details
## Inhaltsangabe 
- [Ablauf der Gruppenarbeit](#ablauf-der-gruppenarbeit) 
- [Gruppeninterne Vorgehensweise](#gruppeninterne-vorgehensweise)
  - [Projektmanangement](#projektmanagement) 
  - [Anforderungsanalyse](#anforderungsanalyse) 
  - [Mock-Ups](#mock-ups)
  
## Ablauf der Gruppenarbeit
Zum Beginn der Gruppenarbeit hat die Gruppe sich eine Thematik für die zu implementierende Anwendung überlegt. Nach langem Überlegen konnte sich die Gruppe auf das Thema **Früherkennung potenzieller Gefahren in Social Media-Beiträgen** einigen. Diese Idee wurde nach der Präsentation und dem kritischen Feedback von Herrn Tobias Horsmann wieder verworfen. Die Grundlage der **Social Media Analytics** blieb jedoch bestehen. So strukturierte die Gruppe lediglich das Ziel der Analyse um.

Nachdem die Gruppe viel Zeit in die Recherche investiert hatte, hielt sie Rücksprache mit Prof. Dr.-Ing. Torsten Zech. Im Gespräch mit Ihm definierte sich eine Häufigkeitsanalyse der Wörter in Social Media-Beiträgen als gute Anwendungsfunktionalität. Daraufhin wurde eine **Textanalyse von Twitter-Beiträgen auf prägnante Themeninhalte** als Ziel der Anwendung festgelegt. Herr Tobias Horsmann schickte der Gruppe einen Twitter-Datensatz, an welchem die Analyse getestet werden konnte. An der Häufigkeitsanalyse und dem User-Interface, bei welchem zu Anfang noch zusätzliche Einstellungen geplant waren, wurde bis zur Abschlusspräsentation gearbeitet.

Die in der Abschlusspräsentation genannten Kritikpunkte hat man bis zur Abgabe versucht umzusetzen. Nach der Präsentation wurde zusätzlich zur Häufigkeitsanalyse der Unigramme sowohl noch eine Häufigkeitsanalyse der Bigramme, der Trigramme sowie eine Sentimentanalyse in die Anwendung implementiert. Parallel zur Implementierung der beiden Textanalysen wurde an der [Dokumentation des Praxisprojekts](README.md) gearbeitet.


## Gruppeninterne Vorgehensweise
### Projektmanagement 
Von Anfang an hat die Gruppe versucht sich beim Projektmanagement an den Werte der agilen Softwareentwicklung zu orientieren:
- **Individuen und Interaktionen** vor Tools
- **Funktionierende Programme** vor ausführliche Spezifikation
- **Stetige Zusammenarbeit mit dem Auftraggeber/ den Leitern**
- **Offenheit und Flexibilität** vor festgelegten Plan

Diese Werte wurden allerdings im Laufe der Gruppenarbeit durch die Ziele des Projektmanagements eingegrenzt: 
- Qualität
- Ressourcen
- Zeit

Deswegen hat man sich bei der groben Planung für die folgende Vorgehensweise entschieden:
1. Vorphase: Recherche
2. Planung und Organisation: vollständiges Design, Auswahl der Tools und Pipeline Definition
3. Produktion: Implementierung
4. Post-Produktion: Fehler-Korrektur 					

Die Hauptaufgabe der Implementierung der Anwendung wurde in Teilaufgaben unterteilt, die immer wieder miteinander verbunden und abgeglichen wurden.

### Anforderungsanalyse
Eine Anforderungsanalyse wurde mittels Brainstorming und Gesprächen zwischen den Gruppenmitgliedern durchgeführt.

ATIC Rahmen Nutzeranforderungen | Beschreibung
------------------- | ------------ 
Aufgabe | Analysieren von einem Twitter-Datensatz mit Berücksichtigung der Häufigkeit & der Tonalität der Wörter 
Rollen | Wissenschaftliche Mitarbeiter, HiWis, SHKs
Information | Twitter-Datensatz (Von Tobias Horsmann zur Verfügung gestellt)
Kontext | Eine elektronisch zu verwendende Anwendung

Der ATIC Rahmen wurde nach dem Wissen aus der Vorlesung "Mensch-Computer-Interaktion" von Prof. Dr. -Ing. Jürgen Ziegler erstellt. 

### Mock-Ups
Für die erste Version der Anwendung wurde außerdem ein Mockup Modell erstellt, um die Funktionen der Anwendung zu verdeutlichen. Natürlich weichen die Mock-Ups von der fertigen Anwendung ab:

Startseite (PowerPoint): ![Startseite](https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/Praxisprojekt%20-%20Textanalyse%20Mock%20Up%20(erste%20Version%20der%20Anwendung)/Startseite.JPG) 

Output-Seite (PowerPoint): ![Output-Seite]( https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/Praxisprojekt%20-%20Textanalyse%20Mock%20Up%20(erste%20Version%20der%20Anwendung)/Output-Seite.JPG)
