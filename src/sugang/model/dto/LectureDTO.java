package sugang.model.dto;

public class LectureDTO {
	private String lecCode;
	private String lecName;
	private String majName;
	private String proName;
	private String lecDay;
	private String lecStartTime;
	private String lecEndTime;
	private int lecLimitCount;
	private int lecCurrentCount;

	public LectureDTO() {
	}

	public LectureDTO(String lecCode, String lecName, String majName, String proName, String lecDay,
			String lecStartTime, String lecEndTime, int lecLimitCount, int lecCurrentCount) {
		this.lecCode = lecCode;
		this.lecName = lecName;
		this.majName = majName;
		this.proName = proName;
		this.lecDay = lecDay;
		this.lecStartTime = lecStartTime;
		this.lecEndTime = lecEndTime;
		this.lecLimitCount = lecLimitCount;
		this.lecCurrentCount = lecCurrentCount;
	}

	public String getLecCode() {
		return lecCode;
	}

	public void setLecCode(String lecCode) {
		this.lecCode = lecCode;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public String getMajName() {
		return majName;
	}

	public void setMajName(String majName) {
		this.majName = majName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getLecDay() {
		return lecDay;
	}

	public void setLecDay(String lecDay) {
		this.lecDay = lecDay;
	}

	public String getLecStartTime() {
		return lecStartTime;
	}

	public void setLecStartTime(String lecStartTime) {
		this.lecStartTime = lecStartTime;
	}

	public String getLecEndTime() {
		return lecEndTime;
	}

	public void setLecEndTime(String lecEndTime) {
		this.lecEndTime = lecEndTime;
	}

	public int getLecLimitCount() {
		return lecLimitCount;
	}

	public void setLecLimitCount(int lecLimitCount) {
		this.lecLimitCount = lecLimitCount;
	}

	public int getLecCurrentCount() {
		return lecCurrentCount;
	}

	public void setLecCurrentCount(int lecCurrentCount) {
		this.lecCurrentCount = lecCurrentCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LectureDTO [lecCode=");
		builder.append(lecCode);
		builder.append(", lecName=");
		builder.append(lecName);
		builder.append(", majName=");
		builder.append(majName);
		builder.append(", proName=");
		builder.append(proName);
		builder.append(", lecDay=");
		builder.append(lecDay);
		builder.append(", lecStartTime=");
		builder.append(lecStartTime);
		builder.append(", lecEndTime=");
		builder.append(lecEndTime);
		builder.append(", lecLimitCount=");
		builder.append(lecLimitCount);
		builder.append(", lecCurrentCount=");
		builder.append(lecCurrentCount);
		builder.append("]");
		return builder.toString();
	}

}
