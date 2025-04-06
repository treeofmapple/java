package base;

import java.io.File;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {
	public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration();

            // Path to your acoustic model, dictionary, and language model
            configuration.setAcousticModelPath("file:model/en-us/en-us");
            configuration.setDictionaryPath("file:model/en-us/cmudict-en-us.dict");
            configuration.setLanguageModelPath("file:model/en-us/en-us.lm.bin");
            System.out.println(new File("model/en-us/en-us").getAbsolutePath());

            
            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);

            System.out.println("Speak something...");
            SpeechResult result;

            while ((result = recognizer.getResult()) != null) {
                System.out.println("You said: " + result.getHypothesis());
            }

            recognizer.stopRecognition();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
