package gabywald.global.filters;

import gabywald.global.data.Utils;

/**
 * Specific FileFilter for BibTeX files...
 * @author Gabriel Chandesris (2011)
 */
public class BibTeXFilter extends GenericFileFilter {
	public BibTeXFilter() 
		{ super(Utils.bib); }

	@Override
	public String getDescription() 
		{ return "BibTeX Files"; }
}
