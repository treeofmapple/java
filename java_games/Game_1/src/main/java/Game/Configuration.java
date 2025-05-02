package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Configuration {

	private String title;
	private int fps;
	private int ups;
	private int width;
	private int height;
	private Map<String, String> configMap = new HashMap<>();
	
	public Configuration() {
		setSystemConfig();
	}
	
	public void setSystemConfig() {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("Configuration/Configs")) {
			if (input == null) {
				throw new RuntimeException("Config file not found: Configuration/Configs");
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			parseLines(reader);
			
		} catch (IOException e) {
			throw new RuntimeException("Error reading config file", e);
		}
		setTitle(configMap.getOrDefault("TITLE", "PaperMache"));
		setFps(Integer.parseInt(configMap.getOrDefault("FPS", "60")));
		setUps(Integer.parseInt(configMap.getOrDefault("UPS", "60")));
		setWidth(Integer.parseInt(configMap.getOrDefault("WIDTH", "1280")));
		setHeight(Integer.parseInt(configMap.getOrDefault("HEIGHT", "720")));
	}
	
	private void parseLines(BufferedReader reader) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("#")) continue;

			String[] parts = line.split("\\s{0,4}=\\s*", 2);
			if (parts.length == 2) {
				String key = parts[0].trim();
				String value = parts[1].trim();
				configMap.put(key, value);
			}
		}
		
	}
	
	public void setFps(int fps) {
		if (fps <= 28) throw new IllegalArgumentException("FPS must be more than 28");
	    this.fps = fps;
	}
	
	public void setUps(int ups) {
	    if (ups <= 28) throw new IllegalArgumentException("UPS must than 28");
	    this.ups = ups;
	}
	
}
