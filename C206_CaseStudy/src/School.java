public class School {

private int SchoolId;
private String SchoolName;
private String SchoolTag;
	
	public School(String SchoolTag, String SchoolName, int SchoolId) {
		//super(assetTag, description);
		this.SchoolId=SchoolId;
		this.SchoolName=SchoolName;
		this.SchoolTag=SchoolTag;
	}

	public int getSchools() {
		return SchoolId;
	}

	/**
	 * @return the schoolId
	 */
	public int getSchoolId() {
		return SchoolId;
	}

	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(int schoolId) {
		SchoolId = schoolId;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return SchoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}

	/**
	 * @return the schoolTag
	 */
	public String getSchoolTag() {
		return SchoolTag;
	}

	/**
	 * @param schoolTag the schoolTag to set
	 */
	public void setSchoolTag(String schoolTag) {
		SchoolTag = schoolTag;
	}
	
}
