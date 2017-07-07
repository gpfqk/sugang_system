package sugang.model.dto;

public class RegistrationDTO {
	private String lecCode;
	private String lecName;
	private String majName;
	private String proName;
	private String lecDay;
	private String lecStartTime;
	private String lecEndTime;

	public RegistrationDTO() {
	}

	public RegistrationDTO(String lecCode, String lecName, String majName, String proName, String lecDay,
			String lecStartTime, String lecEndTime) {
		this.lecCode = lecCode;
		this.lecName = lecName;
		this.majName = majName;
		this.proName = proName;
		this.lecDay = lecDay;
		this.lecStartTime = lecStartTime;
		this.lecEndTime = lecEndTime;
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistrationDTO [lecCode=");
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
		builder.append("]");
		return builder.toString();
	}

}
