package org.behobia.scraping;

import java.util.Iterator;

import org.utilities.core.lang.iterable.IterablePipe;
import org.utilities.io.html.UtilitiesScraping;

public class BehobiaPageResults implements IterablePipe<BehobiaResult> {

	private int skip;
	private int year;

	public BehobiaPageResults(int skip, int year) {
		this.skip = skip;
		this.year = year;
	}

	@Override
	public Iterator<BehobiaResult> iterator() {
		String url = BehobiaURLBuilder.get(year, skip);
		return UtilitiesScraping.get(url, "#content section table tbody tr")
				.map(BehobiaResult::parseBehobiaRowDto)
				.iterator();
	}

}
