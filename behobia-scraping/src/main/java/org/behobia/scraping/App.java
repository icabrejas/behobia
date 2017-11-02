package org.behobia.scraping;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.utilities.core.lang.iterable.IterablePipe;
import org.utilities.core.lang.iterable.UtilitiesIterable;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class App {

	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = new FileWriter("C:/tmp/yourfile.csv");) {
			StatefulBeanToCsv<BehobiaResult> beanToCSV = new StatefulBeanToCsvBuilder<>(writer).build();
			IterablePipe<BehobiaResult> results = UtilitiesIterable.sequence(1979, 2016)
					.println()
					.flatMap(BehobiaYearResults::new)
					.log(1000);
			for (BehobiaResult result : results) {
				beanToCSV.write(result);
			}
		}

	}

}
