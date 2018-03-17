# Dokumentation des Praxisprojekts

## Inhaltsangabe 
- [Vorstellung des Praxisprojekts](#vorstellung-des-praxisprojekts) x
   - [Ablauf der Projektarbeit](#ablauf-der-projektarbeit) x
   - [Ziel der Anwendung](#ziel-der-anwendung) x   
- [Anleitung der Anwendung](#anleitung-der-anwendung)
   - [Einrichtung](#einrichtung)
   - [Konfiguration](#konfiguration)
   - [Verwendung](#verwendung)
- [Output](#output)
- [Evaluation](#evaluation) x
   - [Häufigkeitsanalyse](#häufigkeitsanalyse) x
   - [Sentimentanalyse](#sentimentanalyse) x
   - [Grafische Ausgabe](#grafische-ausgabe)  
- [Fazit](#fazit) x 

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

Das Programm testet dafür Datensätze von Twitter-Beiträgen, um die vom Nutzer am häufigsten verwendeten Wörter (Als einzelne Wörter, als Wortpaar und/oder als dreier Wortpaar) festzustellen. Dies kann in vielen verschiedenen Bereichen von Nutzen sein: Markt-, Produktakzeptenz-, **Krisenkommunikationsanalyse** oder Inhaltanalyse. Die Anwendung soll dabei helfen, den Forschern einen ersten Überblick über themenrelevante Daten und ihren Einfluss auf die Beiträge in sozialen Netzwerken zu verschaffen. Dabei gilt der Grundsatz: **Je häufiger die Wörter in Twitter-Beiträgen genutzt werden, desto relevanter sind sie für die Nutzer**. Mit dieser Funktionalität bietet die Anwendung nicht nur eine Häufigkeitsanalyse, sondern gibt Forschen die Möglichkeit den zeitlichen Zusammenhang mit zu berücksichtigen und den Kommunikationsverlauf über die Zeit zu betrachten. Außerdem kann durch die Ausgabe von Wortkombinationen der Kontext, in welchen sie gefallen sind, besser nachvollziehen. Als weitere Funktionalität, bietet die Anwendung eine Sentimentanalyse an, mit welcher die Tonalität der Beiträge herausgefunden werden können. 

Kernfunktionen der Anwendung mit _Beispiel aus der Krisenkommunikation_:
1.	Erkennung der häufigsten Wörter bzw. Wortkombinationen in einem Twitter Datensatz (Relevanz/Kontext der Thematik)
      - _Nach einem Erdbeben sind die häufigsten Wörter, die mit einer erbebenrelevanten Thematik => Das Erdbeben ist relevant_
2.	Zusammenhang mit der Zeit des Postings (Kommunikationsverlauf)
      - _Während und kurz nach dem Beben sind erdbebenthematisch Wörter am häufigsten => zeitliche Entwicklung des Kommunikationsverlaufs_
3.	Zuteilung der Tonalität der Beiträge (positiv, neutral, negativ)
      - _Sind die Beiträge eher negativ (Wut, Trauer), positiv (Erleichterung) oder neutral (Berichterstattung) => Tonalität der Beiträge_  

Damit lassen sich Aussagen über die Relevanz eines Themas, den zeitlichen Verlauf und die Tonalität der Online-Kommunikation über dieses Thema treffen.

## Anleitung der Anwendung 
Im Folgenden finden Sie eine Anleitung zur [Einrichtung](#einrichtung), [Konfiguration](#konfiguration) und [Verwendung](#verwendung) der Anwendung.

### Einrichtung
FEHLT (to do)

### Konfiguration
FEHLT (to do)

### Verwendung
**_Der zu analysierende Datensatz ist in dieser Version vorgegeben. Eine Option zum Hochladen externer Datensätze ist nicht gegeben, jedoch eine mögliche ergänzende Funktionalität._**

Der Nutzer besucht die Seite der Anwendung und sieht das User-Interface mit Eingabefeldern. Dort kann er einen Titel, sowie Ort des Geschehens eintragen. Beide Angaben haben keinen Einfluss auf die Textanalyse der Daten. Sie werden lediglich im Output als standardisierter Satz vor den Ergebnissen stehen und dient somit der Usability.
In einem weiteren Feld gibt der Nutzer eine Anfangs-/ und eine Endzeit an. Diese definieren den Zeitraum der Twitter-Beiträge, die von der Anwendung analysiert werden sollen.
Durch das Klicken auf den "Safe"-Button speichert der Nutzer die Eingaben und startet somit die Analyse des Datensatzes.

Platz für SA Erklärung? (to do?)

## Output
FEHLT (to do) 

## Evaluation 
Im Folgenden wird die Evaluation der [Häufigkeitsanalyse](#häufigkeitsanalyse), die [Sentimentsanalyse](#sentimentanalyse) und die [grafische Ausgabe](#grafische-ausgabe) der Anwendung vorgestellt.

### Häufigkeitsanalyse
Die Häufigkeitsanalyse wird auf den integrierten Twitter-Datensatz evaluiert. Sie erfolgt auf Tokenbasis. d.h. die Erkennungsrate der Tokens ist 100%. Es wurden vor dem Zählen der Tokens einige Filter angewendet, um für die Analysen unnötige Zeichen zu entfernen:

1. **Trailingcharacter Remover**, um z.B. _Punkte, Komma, und Sonderzeichen_ zu entfernen
2. **Stopwordremover**, um Wörter zu entfernen, die keine Relevanz bei der Häufikeitssuche habe z.B. _the, it, a, of_
3. **Regextokenfilter**, um Sonderzeichen zu entfernen, die keine Buchstaben sind

- Ergebnis:
  - Die Häufigkeitsanalyse zeigt die fünf häufigsten Wörter der Beiträge an. Die grafische Ausgabe können Sie hier sehen (VERLINKUNG). 
  - Da es Probleme mit der Kodierung von Sonderzeichen gab, hat man sich für den Regextokenfilter entschieden. 
  - Eine Problematik der Analyse ist zum Beispiel: Sind Wörter häufig falsch geschrieben, werden sie getrennt zu den Wörtern, die richtig geschrieben bzw. gemeint wurden gezählt.

### Sentimentanalyse 
Die Sentimentanalyse wird anhand von 30 Twitter-Beiträgen evaluiert. Diese bestehen aus jeweils 10 positiven, 10 negativen und 10 neutralen Twitter, die als "Goldstandard" festgelegt werden.

- Ergebnis:
  - **10 von 10 negativen Beiträgen wurden erkannt**
  - **10 von 10 positiven Beiträgen wurden erkannt**
  -  8 von 10 neutrale Beiträgen wurden als positiv erkannt
  -  1 von 10 von neutralen Beiträgen hat keine Übereinstimmung mit unserem Lexikon
  -  1 von 10 von neutralen Beiträgen wurde als negativ erkannt
Das Ergebnis variiert teilweise deutlich je nach Häufigkeit der Lexikonwörter im Text. Teilweise resultiert ein deutlicher Score von -(2.01) - (-0.7) oder 0.2 – 3.5.

Die Anwendung erkennt die positiven und negativen Beiträge fehlerfrei. Die neutralen Beiträge stellen ein Problem bei der Analyse dar. Eine mögliche Erklärung für die Problematik bei neutralen Beiträgen wäre, dass diese Berichterstattungen und somit teilweise auch Zitate beinhalten. So könnte die Neutralität der Beiträge durch die Emotionalität in den Zitaten oder Formulierungen beeinflusst sein.

Das genutzte Lexikon zur Evaluation der Sentinmentanalyse (SemEval-2015 English Twitter Sentimen Lexicon, created using Best-Worst Scaling(aka MaxDiff)) [finden Sie hier](http://saifmohammad.com/WebPages/lexicons.html).

### Grafische Ausgabe
FEHLT (to do)

- Ergebnis:
FEHLT (to do)

## Fazit
Im Folgenden finden Sie ein Resümee über die Anwendung:
- [x] User-Interface für die Anwendung
- [x] Häufigkeitsanalyse für den Twitter-Datensatz
- [x] Zusammenhang von Häufigkeit der Wörter und der Zeit des Postings
- [x] Grafische Ausgabe der Häufigkeitsanalyse 
- [x] Sentimentanalyse 
- [x] Ausgabe der Ergebnisse der Sentimentanalyse 
- [ ] Kommunikation zwischen dem Interface und den Funktionalitäten 

Die Anwendung läuft nicht fehlerfrei. Es gibt Kommunikationsprobleme zwischen der HTML-Seite und dem Java Code. Die HTML-Seite speichert die eingebenden Daten nicht korrekt ab und übergibt diese  nicht an die Output-Seite. Außerdem gibt es auf dem User-Interface ist kein Eingabefeld für die Parameter der Sentimentanalyse und somit kann diese Daten nur auf der Funktionsebene ausgeben. Generell steckt die Sentinemtanalyse noch in einem frühen Stadium der Entwicklung. Dadurch ist diese nur eingeschränkt nutzbar. An dieser Stelle sei aber zu erwähnen, dass die Sentinemtanalyse aufgrund eines Missverständnisses erst zu einem späteren Zeitpunkt als zusätzliche Funktionalität dazu gekommen ist.

Nichtsdestotrotz sind die elementaren Funktionalitäten der Anwendung vorhanden und funktionsfähig. Es gibt ein User-Interface, die Häufigkeitsanalyse gibt die häufigsten Wörter im Zusammenhang des Zeitraums aus und diese werden vom Programm grafisch ausgegeben. Die Kritik der Abschlusspräsentation wurden umgesetzt und die Anwendung stellt mit ein paar Problemen das dar, was die Gruppe sich zu Beginn des Praxisprojekts vorgestellt hatte.  
