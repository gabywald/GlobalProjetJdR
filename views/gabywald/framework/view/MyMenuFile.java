package gabywald.framework.view;

import gabywald.global.data.File;
import gabywald.global.data.TextualInfoFile;

/**
 * 
 * @author Gabriel Chandesris (2012, 2026)
 */
@SuppressWarnings("serial")
public class MyMenuFile extends File {
	private static MyMenuFile instance;

	private MyMenuFile() 
		{ super(TextualInfoFile.getFrameworkContext().getValueOf("menuConf")); }

	public static MyMenuFile getInstance() {
		if (MyMenuFile.instance == null) 
			{ MyMenuFile.instance = new MyMenuFile(); }
		return MyMenuFile.instance;
	}

}
