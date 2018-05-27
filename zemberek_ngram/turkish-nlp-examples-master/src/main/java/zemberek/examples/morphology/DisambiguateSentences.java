package zemberek.examples.morphology;

import zemberek.core.logging.Log;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

import java.io.IOException;
import java.util.List;

public class DisambiguateSentences {

  public static void main(String[] args) throws IOException {

    TurkishMorphology morphology = TurkishMorphology.createWithDefaults();

    String sentence = "sevdiiiceğim benim selcan'ın ";
    Log.info("Sentence  = " + sentence);
    List<WordAnalysis> analyses = morphology.analyzeSentence(sentence);

    Log.info("Sentence word analysis result:");
    for (WordAnalysis entry : analyses) {
      Log.info("Word = " + entry.getInput());
      for (SingleAnalysis analysis : entry) {
        Log.info(analysis.formatLong());
      }
    }
    SentenceAnalysis result = morphology.disambiguate(sentence, analyses);

    Log.info("\nAfter ambiguity resolution : ");
    result.bestAnalysis().forEach(Log::info);
  }
}
