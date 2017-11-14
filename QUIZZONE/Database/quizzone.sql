-- IF EXISTS DROP DATABASE quizzone;
CREATE DATABASE IF NOT EXISTS quizzone;
USE quizzone;

CREATE TABLE IF NOT EXISTS quiz (
  id int(11) NOT NULL,
  domanda text,
  risposta text,
  risposta_1 text,
  risposta_2 text,
  risposta_3 text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO quiz (id, domanda, risposta, risposta_1, risposta_2, risposta_3) VALUES
(1, 'In che anno si tenne la prima edizione del campionato mondiali di calcio?', '1930', '1900', '1948', '1940'),
(2, 'Con chi vinse la Nazionale Italiana la finale dei campionati mondiali 2006?', 'Francia', 'Olanda', 'Germania', 'Spagna'),
(3, 'Il 17 ottobre 1975 fu giocata in messico la famosa partita Brasile-Nicaragua e terminata..', '14-0', '4-0', '10-10', '7-4'),
(4, 'Di che colore è la maglia indossata dalla nazionale italiana ai campionati del mondo?', 'Azzurra', 'Rossa', 'Nera', 'Verde'),
(5, 'Qual’è l’unica squadra che ha partecipato a tutti i campionati di Serie A dalla sua fondazione ?', 'Inter', 'Milan', 'Sampdoria', 'Napoli'),
(6, 'La squadra del Milan venne fondata nel...', '1899', '1889', '1888', '1092'),
(7, 'Quale tra queste squadre ha vinto il maggior numero di titoli UEFA Champions League?', 'Real Madrid', 'Liverpool', 'Milan', 'Barcellona'),
(8, 'Dal 2004 nel campionato di serie A giocano...', '20 squadre', '24 squadre', '21 squadre', '18 squadre'),
(9, 'Il titolo di Campione d’Italia venne assegnato per la prima volta nel 1898. Quale squadra lo ricevette?', 'Genoa', 'Torino', 'SPAL', 'Inter'),
(10, 'Con la maglia del Brasile Pele ha disputato in totale...', '92 partite', '112 partite', '161 partite', '95 partite'),
(11, 'La Valle dei Re si trova...', 'in Egitto', 'in Florida', 'in Tunisia', 'in Iran'),
(12, 'Chi dipinse «L´ultima cena?»', 'Leonardo Da Vinci.', 'Leonardo Sciascia.', 'Il Giorgione.', 'Il Caravaggio.'),
(13, 'Chi scrisse la canzone «Generale»', 'Francesco De Gregori.', 'Francesco Guccini', 'Rino Gaetano.', 'Franco Battiato.'),
(14, 'Paul Verlanie era un...', 'un poeta francese.', 'uno scrittore e medico francese.', 'uno poeta spagnolo.', 'un filosofo belga.'),
(15, 'Quali animali trainano la slitta di Babbo Natale?', 'Delle renne.', 'Dei buoi.', 'Dei cani da slitta.', 'Dei muli.'),
(17, 'Se vedo la fontana di Trevi, mi trovo a...', 'Roma', 'Pescara', 'Milano', 'Monaco'),
(18, 'La branca della medicina che studia la pelle si chiama...', 'dermatologia.', 'chirurgia.', 'ematologia.', 'nefrologia.'),
(19, 'Chi inventó la corrente elettrica alternata?', 'Nikola Tesla.', 'Levi Strauss.', 'Thomas Alva Edison.', 'Antonio Meucci.'),
(20, 'Il Testimone nello sport é...', 'indica la bacchetta che viene passata tra gli atleti della stessa squadra.', 'un sinonimo di arbitro.', 'il codice di comportamento da tenere tra atleti.', 'l’insieme delle regole sportive.');
