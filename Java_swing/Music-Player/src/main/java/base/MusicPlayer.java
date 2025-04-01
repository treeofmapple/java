package base;

import javax.swing.SwingUtilities;

import frame.PageBuilder;

public class MusicPlayer {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PageBuilder.selectTheme();
			PageBuilder musicSystem = new PageBuilder();
			musicSystem.setVisible(true);
		});
	}
}
