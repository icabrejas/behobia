package org.behobia.scraping;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;
import org.utilities.core.lang.iterable.UtilitiesIterable;
import org.utilities.core.util.function.BiFunctionPlus;
import org.utilities.io.html.UtilitiesScraping;

public class BehobiaYearResults implements Iterable<BehobiaResult> {

	public static final int LIMIT = 20;

	private int year;

	public BehobiaYearResults(int year) {
		this.year = year;
	}

	@Override
	public Iterator<BehobiaResult> iterator() {
		return UtilitiesIterable.sequence(0, LIMIT * (total() / LIMIT), LIMIT)
				.parallelFlatMap(BiFunctionPlus.parseFunction(this::page, year))
				.iterator();
	}

	private List<BehobiaResult> page(int skip, int year) {
		return new BehobiaPageResults(skip, year).toList();
	}

	private int total() {
		String url = BehobiaURLBuilder.get(year, 0);
		Element anchor = UtilitiesScraping.get(url, "#ancla p")
				.toList()
				.get(0);
		String total = anchor.text();
		List<String> strongs = anchor.select("strong")
				.stream()
				.map(Element::text)
				.collect(Collectors.toList());
		for (String strong : strongs) {
			total = total.replace(strong, "");
		}
		total = total.replace(".", "")
				.trim();
		return Integer.parseInt(total);
	}

}
