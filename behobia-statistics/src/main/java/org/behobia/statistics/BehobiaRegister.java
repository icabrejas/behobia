package org.behobia.statistics;

public class BehobiaRegister {

	public Integer year;
	public Integer overallPosition;
	public String name;
	public String surname;
	public String time;
	public Integer dorsal;
	public String category;
	public Integer categoryPosition;
	public String origin;

	@Override
	public String toString() {
		try {
			return JSONMapper.toJSON(this);
		} catch (Exception e) {
			throw new Error(e);
		}
	}
}
