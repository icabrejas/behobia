package org.behobia.scraping;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Element;

import com.opencsv.bean.CsvBindByName;

public class BehobiaResult {

	@CsvBindByName(column = "Year")
	private String year;
	@CsvBindByName(column = "Absolute Position")
	private String absolutePosition;
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Time")
	private String time;
	@CsvBindByName(column = "Dorsal")
	private String dorsal;
	@CsvBindByName(column = "Cathegory")
	private String cathegory;
	@CsvBindByName(column = "Cathegory Position")
	private String cathegoryPosition;
	@CsvBindByName(column = "Origin")
	private String origin;
	@CsvBindByName(column = "Start Time")
	private String startTime;
	@CsvBindByName(column = "Start Position")
	private String startPosition;
	@CsvBindByName(column = "km 5 Time")
	private String km5Time;
	@CsvBindByName(column = "Km 5 Position")
	private String km5Position;
	@CsvBindByName(column = "Km 10 Time")
	private String km10Time;
	@CsvBindByName(column = "Km 10 Position")
	private String km10Position;
	@CsvBindByName(column = "Km 15 Time")
	private String km15Time;
	@CsvBindByName(column = "Km 15 Position")
	private String km15Position;
	@CsvBindByName(column = "Photo")
	private String photo;
	@CsvBindByName(column = "Video")
	private String video;
	@CsvBindByName(column = "Certificate")
	private String certificate;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAbsolutePosition() {
		return absolutePosition;
	}

	public void setAbsolutePosition(String absolutePosition) {
		this.absolutePosition = absolutePosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public String getCathegory() {
		return cathegory;
	}

	public void setCathegory(String cathegory) {
		this.cathegory = cathegory;
	}

	public String getCathegoryPosition() {
		return cathegoryPosition;
	}

	public void setCathegoryPosition(String cathegoryPosition) {
		this.cathegoryPosition = cathegoryPosition;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}

	public String getKm5Time() {
		return km5Time;
	}

	public void setKm5Time(String km5Time) {
		this.km5Time = km5Time;
	}

	public String getKm5Position() {
		return km5Position;
	}

	public void setKm5Position(String km5Position) {
		this.km5Position = km5Position;
	}

	public String getKm10Time() {
		return km10Time;
	}

	public void setKm10Time(String km10Time) {
		this.km10Time = km10Time;
	}

	public String getKm10Position() {
		return km10Position;
	}

	public void setKm10Position(String km10Position) {
		this.km10Position = km10Position;
	}

	public String getKm15Time() {
		return km15Time;
	}

	public void setKm15Time(String km15Time) {
		this.km15Time = km15Time;
	}

	public String getKm15Position() {
		return km15Position;
	}

	public void setKm15Position(String km15Position) {
		this.km15Position = km15Position;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public static BehobiaResult parseBehobiaRowDto(Element row) {
		List<String> cells = cells(row);
		BehobiaResult rowDto = new BehobiaResult();
		rowDto.setYear(cells.get(0));
		rowDto.setAbsolutePosition(cells.get(1));
		rowDto.setName(cells.get(2));
		rowDto.setTime(cells.get(3));
		rowDto.setDorsal(cells.get(4));
		rowDto.setCathegory(cells.get(5));
		rowDto.setCathegoryPosition(cells.get(6));
		rowDto.setOrigin(cells.get(7));
		rowDto.setStartTime(cells.get(8));
		rowDto.setStartPosition(cells.get(9));
		rowDto.setKm5Time(cells.get(10));
		rowDto.setKm5Position(cells.get(11));
		rowDto.setKm10Time(cells.get(12));
		rowDto.setKm10Position(cells.get(13));
		rowDto.setKm15Time(cells.get(14));
		rowDto.setKm15Position(cells.get(15));
		rowDto.setPhoto(cells.get(16));
		rowDto.setVideo(cells.get(17));
		rowDto.setCertificate(cells.get(18));
		return rowDto;
	}

	private static List<String> cells(Element row) {
		return row.select("td")
				.stream()
				.map(Element::text)
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "BehobiaRowDto [year=" + year + ", absolutePosition=" + absolutePosition + ", name=" + name + ", time="
				+ time + ", dorsal=" + dorsal + ", cathegory=" + cathegory + ", cathegoryPosition=" + cathegoryPosition
				+ ", Procedencia=" + origin + ", startTime=" + startTime + ", startPosition=" + startPosition
				+ ", km5Time=" + km5Time + ", km5Position=" + km5Position + ", km10Time=" + km10Time + ", km10Position="
				+ km10Position + ", km15Time=" + km15Time + ", km15Position=" + km15Position + ", photo=" + photo
				+ ", video=" + video + ", certificate=" + certificate + "]";
	}

}
