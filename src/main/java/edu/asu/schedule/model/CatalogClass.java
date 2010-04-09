package edu.asu.schedule.model;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author alwold
 */
public class CatalogClass {
	private String strm;
	private Integer classNbr;
	private String crseId;
	private Integer crseOfferNbr;
	private String classSection;
	private String sessionCode;
	private Integer classMtgNbr;
	private String subject;
	private String catalogNbr;
	private String campus;
	private String location;
	private String title;
	private Date startDt;
	private Date meetingTimeStart;
	private Date endDt;
	private Date meetingTimeEnd;
	private Boolean mon;
	private Boolean tues;
	private Boolean wed;
	private Boolean thurs;
	private Boolean fri;
	private Boolean sat;
	private Boolean sun;
	private Boolean schedulePrint;
	private String facilityId;
	private Integer enrlTot;
	private Integer enrlCap;
	private Integer waitTot;
	private Integer waitCap;
	private String acadCareer;
	private String ssrComponent;
	private String consent;
	private Integer crsTopicId;
	private String enrlStat;
	private String classStat;
	private String instructionMode;
	private String acadGroup;
	private String acadOrg;
	private Set<Instructor> instructors;

	public String getAcadCareer() {
		return acadCareer;
	}

	public void setAcadCareer(String acadCareer) {
		this.acadCareer = acadCareer;
	}

	public String getAcadGroup() {
		return acadGroup;
	}

	public void setAcadGroup(String acadGroup) {
		this.acadGroup = acadGroup;
	}

	public String getAcadOrg() {
		return acadOrg;
	}

	public void setAcadOrg(String acadOrg) {
		this.acadOrg = acadOrg;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCatalogNbr() {
		return catalogNbr;
	}

	public void setCatalogNbr(String catalogNbr) {
		this.catalogNbr = catalogNbr;
	}

	public Integer getClassMtgNbr() {
		return classMtgNbr;
	}

	public void setClassMtgNbr(Integer classMtgNbr) {
		this.classMtgNbr = classMtgNbr;
	}

	public Integer getClassNbr() {
		return classNbr;
	}

	public void setClassNbr(Integer classNbr) {
		this.classNbr = classNbr;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

	public String getClassStat() {
		return classStat;
	}

	public void setClassStat(String classStat) {
		this.classStat = classStat;
	}

	public String getConsent() {
		return consent;
	}

	public void setConsent(String consent) {
		this.consent = consent;
	}

	public Integer getCrsTopicId() {
		return crsTopicId;
	}

	public void setCrsTopicId(Integer crsTopicId) {
		this.crsTopicId = crsTopicId;
	}

	public String getCrseId() {
		return crseId;
	}

	public void setCrseId(String crseId) {
		this.crseId = crseId;
	}

	public Integer getCrseOfferNbr() {
		return crseOfferNbr;
	}

	public void setCrseOfferNbr(Integer crseOfferNbr) {
		this.crseOfferNbr = crseOfferNbr;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public Integer getEnrlCap() {
		return enrlCap;
	}

	public void setEnrlCap(Integer enrlCap) {
		this.enrlCap = enrlCap;
	}

	public String getEnrlStat() {
		return enrlStat;
	}

	public void setEnrlStat(String enrlStat) {
		this.enrlStat = enrlStat;
	}

	public Integer getEnrlTot() {
		return enrlTot;
	}

	public void setEnrlTot(Integer enrlTot) {
		this.enrlTot = enrlTot;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getFri() {
		return fri;
	}

	public void setFri(Boolean fri) {
		this.fri = fri;
	}

	public String getInstructionMode() {
		return instructionMode;
	}

	public void setInstructionMode(String instructionMode) {
		this.instructionMode = instructionMode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getMeetingTimeEnd() {
		return meetingTimeEnd;
	}

	public void setMeetingTimeEnd(Date meetingTimeEnd) {
		this.meetingTimeEnd = meetingTimeEnd;
	}

	public Date getMeetingTimeStart() {
		return meetingTimeStart;
	}

	public void setMeetingTimeStart(Date meetingTimeStart) {
		this.meetingTimeStart = meetingTimeStart;
	}

	public Boolean getMon() {
		return mon;
	}

	public void setMon(Boolean mon) {
		this.mon = mon;
	}

	public Boolean getSat() {
		return sat;
	}

	public void setSat(Boolean sat) {
		this.sat = sat;
	}

	public Boolean getSchedulePrint() {
		return schedulePrint;
	}

	public void setSchedulePrint(Boolean schedulePrint) {
		this.schedulePrint = schedulePrint;
	}

	public String getSessionCode() {
		return sessionCode;
	}

	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}

	public String getSsrComponent() {
		return ssrComponent;
	}

	public void setSsrComponent(String ssrComponent) {
		this.ssrComponent = ssrComponent;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public String getStrm() {
		return strm;
	}

	public void setStrm(String strm) {
		this.strm = strm;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getSun() {
		return sun;
	}

	public void setSun(Boolean sun) {
		this.sun = sun;
	}

	public Boolean getThurs() {
		return thurs;
	}

	public void setThurs(Boolean thurs) {
		this.thurs = thurs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getTues() {
		return tues;
	}

	public void setTues(Boolean tues) {
		this.tues = tues;
	}

	public Integer getWaitCap() {
		return waitCap;
	}

	public void setWaitCap(Integer waitCap) {
		this.waitCap = waitCap;
	}

	public Integer getWaitTot() {
		return waitTot;
	}

	public void setWaitTot(Integer waitTot) {
		this.waitTot = waitTot;
	}

	public Boolean getWed() {
		return wed;
	}

	public void setWed(Boolean wed) {
		this.wed = wed;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	public String getDaysAsString() {
		StringBuffer sb = new StringBuffer();
		if (mon) sb.append("M ");
		if (tues) sb.append("T ");
		if (wed) sb.append("W ");
		if (thurs) sb.append("Th ");
		if (fri) sb.append("F ");
		if (sat) sb.append("Sa ");
		if (sun) sb.append("Su ");
		return sb.toString();
	}
}
