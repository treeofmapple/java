package base;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS {
	
	protected static Voice setVoice(String type){
        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        return VoiceManager.getInstance().getVoice(type);
	}
	
}