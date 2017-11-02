package org.behobia.statistics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

public class Statistics {

	public static final DateFormat TIME_FORMAT;

	static {
		TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
		TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	private HashMap<Integer, BehobiaStatistics> statistics = new HashMap<>();

	private BehobiaStatistics find(Integer year) {
		BehobiaStatistics summary = statistics.get(year);
		if (summary == null) {
			summary = new BehobiaStatistics();
			statistics.put(year, summary);
		}
		return summary;
	}

	public Set<Integer> keySet() {
		return statistics.keySet();
	}

	public String write(int year) {
		for (int yearA : statistics.keySet()) {
			Set<Integer> binsA = statistics.get(yearA).bins();
			for (int yearB : statistics.keySet()) {
				for (int bin : binsA) {
					statistics.get(yearB).get(bin);
				}	
			}
		}
		BehobiaStatistics summary = find(year);
		StringBuilder builder = new StringBuilder();
		builder.append(year);
		// percentages(builder, summary);
		for (int bin : summary.bins()) {
			builder.append(',').append(summary.get(bin));
		}
		return builder.toString();
	}

	private void percentages(StringBuilder builder, BehobiaStatistics summary) {
		builder.append(',').append(summary.getMin());
		for (int perc = 5; perc < 100; perc += 5) {
			builder.append(',').append(summary.getPercentile(perc));
		}
		builder.append(',').append(summary.getMax());
	}

	public void add(BehobiaRegister register) {
		Integer timeInSeconds = timeInSeconds(register);
		if (timeInSeconds != null) {
			find(register.year).addValue(timeInSeconds.doubleValue());
		}
	}

	private static Integer timeInSeconds(BehobiaRegister register) {
		try {
			return (int) TIME_FORMAT.parse(register.time).getTime() / 1000;
		} catch (ParseException e) {
			return null;
		}
	}

}
