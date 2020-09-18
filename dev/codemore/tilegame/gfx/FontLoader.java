package dev.codemore.tilegame.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
	public static Font LoadFont(String path, float size) {
		try {
			InputStream is = new FileInputStream("src/dev/codemore/tilegame/res/textures/slkscr.ttf");

		    Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, is);

		    Font ttfReal = ttfBase.deriveFont(Font.PLAIN, size);
		    
		    return ttfReal; 
	    } catch (FontFormatException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
