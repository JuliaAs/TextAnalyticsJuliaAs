# Dokumentation des Praxisprojekts

## Inhaltsangabe 
- [Vorstellung des Praxisprojekts](#vorstellung-des-praxisprojekts) 
   - [Ablauf der Projektarbeit](#ablauf-der-projektarbeit) 
   - [Ziel der Anwendung](#ziel-der-anwendung)    
- [Anleitung der Anwendung](#anleitung-der-anwendung) 
   - [Einrichtung](#einrichtung)
   - [Verwendung](#verwendung)  
- [Output](#output) 
- [Evaluation](#evaluation) 
   - [Häufigkeitsanalyse](#häufigkeitsanalyse) 
   - [Sentimentanalyse](#sentimentanalyse) 
- [Fazit](#fazit) 

## Vorstellung des Praxisprojekts
Die Aufgabe des Praxisprojekts ist es eine **Anwendung zur Analyse von textbasierter Sprache** zu implementieren. Dafür teilten sich die Teilnehmer des Praxisprojekts in dreier Gruppen auf und überlegten sich eine Problemstellung, die sie mithilfe ihrer Anwendung lösen wollten.

### Ablauf der Projektarbeit
Das Praxisprojekt besteht aus drei Meilensteine:
1. Die Vision der Anwendung
2. Die Vorstellung der Demoversion der Anwendung
3. Die Dokumentation zu der Anwendung

Eine detaillierte Ausführung des Ablaufs finden Sie hier, [finden Sie hier](DETAILS.md).

### Ziel der Anwendung
Die Gruppe hat sich für die Entwicklung einer Anwendung im Bereich **Social Media Analytics** entschieden. Das Ziel der Anwendung ist: Die **Textanalyse von Twitter-Beiträgen auf prägnante Themeninhalte**. Die Anwendung soll eine Analyse eventbetreffender Themen durchführen und so eine Hilfestellung für Wissenschaftler sein, die sich mit Ereignissen auseinandersetzen, die auf Social Media-Plattformen diskutiert werden.

Das Programm testet dafür Datensätze von Twitter-Beiträgen, um die vom Nutzer am häufigsten verwendeten Wörter (als Unigramme, Bigramme und Trigramme) festzustellen. Dies kann in vielen verschiedenen Bereichen von Nutzen sein: Markt-, Produktakzeptenz-, **Krisenkommunikationsanalyse** oder Inhaltanalyse. Die Anwendung soll dabei helfen, den Forschern einen ersten Überblick über themenrelevante Daten und ihren Einfluss auf die Beiträge in sozialen Netzwerken zu verschaffen. Dabei gilt der Grundsatz: **Je häufiger die Wörter in Twitter-Beiträgen genutzt werden, desto relevanter sind sie für die Nutzer**. Mit dieser Funktion bietet die Anwendung nicht nur eine Häufigkeitsanalyse, sondern gibt Forschen die Möglichkeit den zeitlichen Zusammenhang mit zu berücksichtigen und den Kommunikationsverlauf über die Zeit zu betrachten. Außerdem kann durch die Ausgabe von Bi- und Trigramme der Kontext, in welchen sie genutzt wurden, besser nachvollziehen. Als weitere Funktionalität bietet die Anwendung eine Sentimentanalyse an, mit welcher die Tonalität der Beiträge herausgefunden werden kann.

Kernfunktionen der Anwendung mit _Beispiel aus der Krisenkommunikation_, da dies am Anfang der Schwerpunkt war: 
1.	Erkennung der häufigsten Wörter bzw. Wortkombinationen in einem Twitter Datensatz (Relevanz/Kontext der Thematik)
      - _Nach einem Erdbeben sind die häufigsten Wörter, die mit einer erbebenrelevanten Thematik => Das Erdbeben ist relevant_
2.	Zusammenhang mit der Zeit des Postings (Kommunikationsverlauf)
      - _Während und kurz nach dem Beben sind erdbebenthematisch Wörter am häufigsten => zeitliche Entwicklung des Kommunikationsverlaufs_
3.	Zuteilung der Tonalität der Beiträge (positiv, neutral, negativ)
      - _Sind die Beiträge eher negativ (z.B. Wut, Trauer), positiv (z.B. Erleichterung) oder neutral (z.B. Berichterstattung) => Tonalität der Beiträge_  

Damit lassen sich Aussagen über die Relevanz eines Themas, den zeitlichen Verlauf und die Tonalität der Online-Kommunikation über dieses Thema treffen.

## Anleitung der Anwendung 
Im Folgenden finden Sie eine Anleitung zur [Einrichtung](#einrichtung), [Konfiguration](#konfiguration) und [Verwendung](#verwendung) der Anwendung.

### Einrichtung
- Das Programm wurde entwickelt und getestet mit:
   - Eclipse jee Oxygen 2 4.7.2
   - Tomcat 8.5
   - JDK 1.8.0

- Zusätzlich wurden folgende Tools verwendet:
   - JSP
   - jstl 1.2
   - JFreeCharts 1.0.19

- ...und die Voraussetzungen für die Anwendung ist:
   - JRE 1.7 (oder größer)
   - Tomcat 8.0 (und neuer)
   
Die Einrichtung in Eclipse sieht wie folgt aus: 

file → new → other → server → server → next → apache → tomcat →next/yourPathToTomcat

/window → open perspective → other → java ee 

Der Start ist: 

webproject → webcontent → right click startseite.html → run as → run on server (ggf. choose existing server) 

Eclipse intern Browser Starts, Klick Start

Eine alternative Methode ist: click server → start server → open browser → http://localhost:8080/de.unidue.langtech.teaching.pp.juleho/Startseite.html 

Alternative Einrichtung mit „deployment as war file“ 

right click project→export→war file

$TOMCAT_HOME/conf/tomcat-users.xml einfügen 

< user username="admin" password="admin" roles="manager-gui" /> in < tomcat-users> 
Copy the WAR file into $CATALINA_HOME\webapps directory, http://localhost:8080/manager

Start application (in manager): http://localhost:8080/de.unidue.langtech.teaching.pp.juleho/Startseite.html

**Trouble Shooting**: 

server tab → right click → add / remove → choose project 

window/preferences → server/runtime environments → add server runtime

right click project → properties → project facets → runtimes tab → check server

right click project → properties → java compiler → compliance level 1.8

right click project → properties → deployment assembly → add → folder → maven dependency

3 Files werden auf dem Client gespeichert, unter Windows erfolgreich getestet.

### Verwendung
_**Der zu analysierende Datensatz ist in dieser Version vorgegeben. Eine Option zum Hochladen externer Datensätze ist nicht gegeben, jedoch wäre dies eine Funktionalität, die bei einer eventuellen Veröffentlichung der Anwendung dazu kommen sollte. Der jetztige Entwicklungstand dient nur zur Veranschaulichung der Funktionalitäten der Anwendung innerhalb des Praxisprojekts**_

Der Nutzer ruft die Startseite der Anwendung auf und sieht ein Startbutton. Nachdem dieser angeklickt worden ist, startet die Analyse des integrieten Datensatzes. Es folgt ein Output, der die Häufigkeitsanalyse der häufigsten fünf Wörter/Wortkombinationen (Uni-, Bi- sowie Trigramme) und eine Sentimentanalyse der Beiträge beinhaltet. 

## Output
Die Anwendung gibt nach den Analysen vier verschiedene Outputs aus:
- Häufigkeitsanalyse
  - Unigram-Output
  - Bigram-Output
  - Trigram-Output
- Sentimentanalyse 

Eine Übersicht aller Outputs der Anwendung in grafischer Form ![finden Sie zusätzlich hier](Output). 

_Unigram-Output:_ 

Der **Unigram**-Output ist ein Liniendiagramm mit der Überschrift "Häufigkeit der Wörter" und einer x- und einer y-Achse. Auf der y-Achse ist die Anzahl der Wörter vermerkt und auf der x-Achse die lineare Zeit. Die Zuordnung der Zeit findet mithilfe der Zeitangaben der Twitter-Beiträge statt. Jedes der fünf häufigsten Wörter in den Beiträgen + "default", welches eine Eigenart von JFreeCharts darstellt, hat jeweils eine eigene Linienfarbe. Unter dem Diagramm ist eine Legende abgebildet, die den Wörtern eine Farbe zuordnet. Durch die Achsenbeschriftung und der Höhe der Linien ist deutlich zu erkennen, welches Wort am häufigsten genutzt wurde:

![Unigram](https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/Output/Unigram.png)

_Bi- und Trigram-Output:_

Sowohl  die **Bi-** als auch die **Trigramme** sind im Gegensatz dazu als Säulendiagramme dargestellt. Diese geben jeweils die Häufigkeit der Bi- oder Trigramme an. Auf der y-Achse kann man die Anzahl dieser sehen. Genau wie beim Unigram-Output wird mit jeweils verschiedene Farben gearbeitet, um die Anzahl deutlich zu machen. Auch hier wird eine Legende zur Orientierung unter dem Diagramm dargestellt:

![Bigram](https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/Output/Bigram.png) 

![Trigram](https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/Output/Trigram.png) 

_Sentimentanalyse-Output:_ 

Die Ergebnisse der **Sentimentanalyse** werden in Form einer Tabelle ausgegeben. Auf der linken Seite der Tabelle stehen die untersuchten Twitter-Beiträge und rechts stehen in der jeweiligen Zeile der errechnete Score für diese Beiträge:

![Sentimentanalyse](https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/Output/Sentimentresults.png)

## Evaluation 
Im Folgenden wird die Evaluation der [Häufigkeitsanalyse](#häufigkeitsanalyse) und der [Sentimentsanalyse](#sentimentanalyse) der Anwendung vorgestellt.

### Häufigkeitsanalyse
Die Häufigkeitsanalyse wird auf den integrierten Twitter-Datensatz evaluiert. Sie erfolgt auf Tokenbasis. d.h. die Erkennungsrate der Tokens ist 100%. Es wurden vor dem Zählen der Tokens einige Filter angewendet, um die für die Analysen unnötige Zeichen zu entfernen:

1. **Trailingcharacter Remover**, um z.B. _Punkte, Komma, und Sonderzeichen_ zu entfernen
2. **Stopwordremover**, um Wörter zu entfernen, die keine Relevanz bei der Häufikeitssuche habe z.B. _the, it, a, of_
3. **Regextokenfilter**, um Sonderzeichen zu entfernen, die keine Buchstaben sind

- Ergebnis:
  - Die Häufigkeitsanalyse gibt die fünf häufigsten Wörter/Wortkombination der Beiträge als Grafiken aus. 
  - Da es Probleme mit der Kodierung von Sonderzeichen gab, hat man sich für den Regextokenfilter entschieden. 
  - Eine Problematik der Analyse ist zum Beispiel: Sind Wörter häufig falsch geschrieben, werden sie getrennt zu den Wörtern, die richtig geschrieben bzw. gemeint wurden gezählt.

### Sentimentanalyse 
Die Sentimentanalyse wird anhand von 30 Twitter-Beiträgen evaluiert. Diese bestehen aus jeweils 10 positiven, 10 negativen und 10 neutralen Twitter-Beiträgen, die als "Goldstandard" festgelegt werden. Diese sind im Ressouce-Ordner unter [sagold.txt](https://github.com/JuliaAs/TextAnalyticsJuliaAs/blob/master/de.unidue.langtech.teaching.pp.juleho/src/test/resources/test/sagold.txt) für Sie einsehbar.

- Ergebnis:
  - **10 von 10 negativen Beiträgen wurden erkannt**
  - **10 von 10 positiven Beiträgen wurden erkannt**
  -  8 von 10 neutrale Beiträgen wurden als positiv erkannt
  -  1 von 10 von neutralen Beiträgen hat keine Übereinstimmung mit unserem Lexikon
  -  1 von 10 von neutralen Beiträgen wurde als negativ erkannt
  
Das Ergebnis variiert teilweise deutlich je nach Häufigkeit der Lexikonwörter im Text. Teilweise resultiert ein deutlicher Score von -(2.01) - (-0.7) oder 0.2 – 3.5. 

Der restliche Text wurde nicht „linguistisch normalisiert“ , da das genutzte Sentiment Lexikon nicht normalisierte Wörter auf Basis des „Best-Worst Scaling (aka MaxDiff)“  benutzt. Auf Basis des Lexikons sucht man in den Twitter-Beiträgen z.B. nach _„love“ , „loves“, „luv“ und „lovee“_ und anderen Varianten, die häufig in Twitter-Beiträgen benutzt und unterschiedlich gewertet werden, die aber nicht unbedingt in Lexika vorkommen. Daher kann man sagen, dass die Erkennung der Wörter auf Tokenbasis zuverlässig funktioniert, aber man nicht alle Formen der Sprache berücksichtigen kann, wie z.B. neue Trendwörter, die nicht in dem Sentiment Lexikon enthalten sind, oder z.B. _„not hate“, „not love“_. 

Abgesehen davon erkennt die Anwendung die händisch ausgewählten positiven und negativen Beiträge 10 von 10 mal. Dies ist kein Beweis für absolute Fehlerfreiheit, jedoch zeigt diese Evaluation eine Posivität der Funktionalität. Die neutralen Beiträge stellen ein Problem bei der Analyse dar. Eine mögliche Erklärung für die Problematik bei neutralen Beiträgen wäre, dass diese Berichterstattungen und somit teilweise auch Zitate beinhalten. So könnte die Neutralität der Beiträge durch die Emotionalität in den Zitaten oder Formulierungen beeinflusst sein.

Das genutzte Lexikon zur Evaluation der Sentinmentanalyse (SemEval-2015 English Twitter Sentimen Lexicon, created using Best-Worst Scaling(aka MaxDiff)) [finden Sie hier](http://saifmohammad.com/WebPages/lexicons.html).

## Fazit
Im Folgenden finden Sie ein Resümee über die Anwendung:
- [x] User-Interface der Anwendung
- [x] Häufigkeitsanalyse der Wörter in den Twitter-Beiträgen
- [x] Zusammenhang von Häufigkeit der Wörter und der Zeit des Postings
- [x] Grafische Ausgabe der Häufigkeitsanalyse 
- [x] Sentimentanalyse der Twitter- Beiträge
- [x] Ausgabe der Ergebnisse der Sentimentanalyse 

Die Funktionalitäten der Anwendung sind auf die Häufigkeits- und Sentimentanalyse beschränkt. Das Programm unterstützt in der jetzigen Version keine Arbeit mit externen Datensätze und der Nutzer kann keine Einstellungen an der Anwendung vornehmen. Dies ist unter anderem der Fall, da die geplante Einstellung des Zeitraums der zu analysierenden Beiträge zu Problemen bei der Kodierung geführt hat und somit wegfiel. Bei der Evaluation zeigte die Häufigkeitsanalyse außerdem eine Problematik mit falsch geschriebenen Wörtern und  die Sentimentanalyse eine Schwäche für Neutralität und Trendwörter sowie Verneinungen in den Beiträgen.     

Die Funktionalitäten zeigen jedoch keine größere Fehleranfälligkeit. Es gibt ein **User-Interface**, die **Häufigkeitsanalyse** sucht die häufigsten Wörter/Wortkombinationen im Zusammenhang der jeweiligen Zeitangaben der Beiträge, gibt diese grafisch als **Uni-, Bi- und Trigramme** aus und die **Sentimentanalyse** lässt Schlüsse über die Tonalität der Beiträge ziehen. 
