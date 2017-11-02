package org.behobia.statistics;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class BehobiaStatistics extends DescriptiveStatistics {

	private static final long serialVersionUID = -9061095907313187227L;
	private static final double PRECSION = 600;

	private HashMap<Integer, Counter> counters = new HashMap<>();

	@Override
	public void addValue(double value) {
		super.addValue(value);
		counter(bin(value)).add();
	}

	private int bin(double value) {
		return (int) (value / PRECSION);
	}

	private Counter counter(int bin) {
		Counter counter = counters.get(bin);
		if (counter == null) {
			counter = new Counter();
			counters.put(bin, counter);
		}
		return counter;
	}

	public int get(int bin) {
		return counter(bin).get();
	}

	public Set<Integer> bins() {
		return new TreeSet<>(counters.keySet());
	}

	private static class Counter {
		private int total;

		public void add() {
			total++;
		}

		public int get() {
			return total;
		}
	}

}
