package gabywald.framework.view;

import gabywald.global.data.Fichier;
import gabywald.global.data.TextualInfoFile;

/**
 * 
 * @author Gabriel Chandesris (2012)
 */
public class MyMenuFile extends Fichier {
	private static MyMenuFile instance;

	private MyMenuFile() 
		{ super(TextualInfoFile.getFrameworkContext().getValueOf("menuConf")); }

	public static MyMenuFile getInstance() {
		if (MyMenuFile.instance == null) 
			{ MyMenuFile.instance = new MyMenuFile(); }
		return MyMenuFile.instance;
	}

}
