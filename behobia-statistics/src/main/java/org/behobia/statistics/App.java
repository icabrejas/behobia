package org.behobia.statistics;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class App {

	public static void main(String[] args) throws IOException {
		JFileChooser chooser = new JFileChooser("E:/");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			Statistics participations = statistics(file);
			for (int year : new TreeSet<>(participations.keySet())) {
				System.out.println(participations.write(year));
			}
		}
	}

	private static Statistics statistics(File file) throws IOException {
		Map<Integer, Set<String>> categories = new TreeMap<>();
		Statistics participation = new Statistics();
		LineIterator it = FileUtils.lineIterator(file);
		while (it.hasNext()) {
			String line = (String) it.next();
			BehobiaRegister register = toRegister(line);
			// if (register.categoryPosition != null) {
			// participation.add(register);
			// }
			Set<String> category = categories.get(register.year);
			if (category == null) {
				category = new TreeSet<>();
				categories.put(register.year, category);
			}
			category.add(register.category);
		}
		for (int year : categories.keySet()) {
			System.out.println(year + ":" + categories.get(year));
		}
		return participation;
	}

	private static BehobiaRegister toRegister(String line) {
		try {
			return JSONMapper.toClass(line, BehobiaRegister.class);
		} catch (IOException e) {
			System.out.println(line);
			throw new Error(e);
		}
	}

	private static int count(String text, String part) {
		int total = 0;
		int index = -1;
		while (-1 < (index = text.indexOf(part, index + 1))) {
			total++;
		}
		return total;
	}
}
