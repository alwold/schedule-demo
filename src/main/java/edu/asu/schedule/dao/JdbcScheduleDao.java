package edu.asu.schedule.dao;

import edu.asu.schedule.model.CatalogClass;
import edu.asu.schedule.model.Instructor;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 *
 * @author alwold
 */
public class JdbcScheduleDao extends SimpleJdbcDaoSupport implements ScheduleDao {
	private String classSearchSql;

	public Collection<CatalogClass> findClasses(String subject, String catalogNbr) {
		StringBuffer sql = new StringBuffer(classSearchSql);
		sql.append(" AND SUBJECT = ? AND CATALOG_NBR LIKE ?");
		return getJdbcTemplate().query(sql.toString(), new ClassSearchResultSetExtractor(), new Date(), subject, "%"+catalogNbr);
	}

	public void setClassSearchSql(Resource resource) throws IOException {
		classSearchSql = IOUtils.toString(resource.getInputStream());
	}

	private class ClassSearchResultSetExtractor implements ResultSetExtractor<Collection<CatalogClass>> {

		public Collection<CatalogClass> extractData(ResultSet rs) throws SQLException {
			Map<CatalogClassPk, CatalogClass> classes = new HashMap<CatalogClassPk, CatalogClass>();
//			Map<InstructorPk, Instructor> instructors = new HashMap<InstructorPk, Instructor>();
			while (rs.next()) {
				CatalogClassPk ccPk = new CatalogClassPk();
				ccPk.setStrm(rs.getString("STRM"));
				ccPk.setCrseId(rs.getString("CRSE_ID"));
				ccPk.setCrseOfferNbr(rs.getInt("CRSE_OFFER_NBR"));
				ccPk.setClassSection(rs.getString("CLASS_SECTION"));
				ccPk.setSessionCode(rs.getString("SESSION_CODE"));
				CatalogClass cc = classes.get(ccPk);
				if (cc == null) {
					cc = new CatalogClass();
					cc.setStrm(ccPk.getStrm());
					cc.setClassNbr(rs.getInt("CLASS_NBR"));
					cc.setCrseId(ccPk.getCrseId());
					cc.setCrseOfferNbr(ccPk.getCrseOfferNbr());
					cc.setClassSection(ccPk.getClassSection());
					cc.setSessionCode(ccPk.getSessionCode());
					cc.setClassMtgNbr(rs.getInt("CLASS_MTG_NBR"));
					cc.setSubject(rs.getString("SUBJECT"));
					cc.setCatalogNbr(rs.getString("CATALOG_NBR"));
					cc.setCampus(rs.getString("CAMPUS"));
					cc.setLocation(rs.getString("LOCATION"));
					cc.setTitle(rs.getString("TITLE"));
					cc.setStartDt(rs.getDate("START_DT"));
					cc.setMeetingTimeStart(rs.getDate("MEETING_TIME_START"));
					cc.setEndDt(rs.getDate("END_DT"));
					cc.setMeetingTimeEnd(rs.getDate("MEETING_TIME_END"));
					cc.setMon("Y".equals(rs.getString("MON")));
					cc.setTues("Y".equals(rs.getString("TUES")));
					cc.setWed("Y".equals(rs.getString("WED")));
					cc.setThurs("Y".equals(rs.getString("THURS")));
					cc.setFri("Y".equals(rs.getString("FRI")));
					cc.setSat("Y".equals(rs.getString("SAT")));
					cc.setSun("Y".equals(rs.getString("SUN")));
					cc.setSchedulePrint("Y".equals(rs.getString("SCHEDULE_PRINT")));
					cc.setFacilityId(rs.getString("FACILITY_ID"));
					cc.setEnrlTot(rs.getInt("ENRL_TOT"));
					cc.setEnrlCap(rs.getInt("ENRL_CAP"));
					cc.setWaitTot(rs.getInt("WAIT_TOT"));
					cc.setWaitCap(rs.getInt("WAIT_CAP"));
					cc.setAcadCareer(rs.getString("ACAD_CAREER"));
					cc.setSsrComponent(rs.getString("SSR_COMPONENT"));
					cc.setConsent(rs.getString("CONSENT"));
					cc.setCrsTopicId(rs.getInt("CRS_TOPIC_ID"));
					cc.setEnrlStat(rs.getString("ENRL_STAT"));
					cc.setClassStat(rs.getString("CLASS_STAT"));
					cc.setInstructionMode(rs.getString("INSTRUCTION_MODE"));
					cc.setAcadGroup(rs.getString("ACAD_GROUP"));
					cc.setAcadOrg(rs.getString("ACAD_ORG"));
					cc.setInstructors(new HashSet<Instructor>());
//					instructors.clear();
					classes.put(ccPk, cc);
				}
				Instructor instructor = new Instructor();
				instructor.setNameFormal(rs.getString("NAME_FORMAL"));
				instructor.setName(rs.getString("NAME"));
				instructor.setFirstName(rs.getString("FIRST_NAME"));
				instructor.setLastName(rs.getString("LAST_NAME"));
				instructor.setInstrRole(rs.getString("INSTR_ROLE"));
				instructor.setSchedPrintInstr("Y".equals(rs.getString("SCHED_PRINT_INSTR")));
				cc.getInstructors().add(instructor);
			}
			return classes.values();
		}
		
	}

	private class CatalogClassPk {
		private String crseId;
		private Integer crseOfferNbr;
		private String strm;
		private String sessionCode;
		private String classSection;

		public String getClassSection() {
			return classSection;
		}

		public void setClassSection(String classSection) {
			this.classSection = classSection;
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

		public String getSessionCode() {
			return sessionCode;
		}

		public void setSessionCode(String sessionCode) {
			this.sessionCode = sessionCode;
		}

		public String getStrm() {
			return strm;
		}

		public void setStrm(String strm) {
			this.strm = strm;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final CatalogClassPk other = (CatalogClassPk) obj;
			return new EqualsBuilder()
					.append(this.crseId, other.crseId)
					.append(this.crseOfferNbr, other.crseOfferNbr)
					.append(this.strm, other.strm)
					.append(this.sessionCode, other.sessionCode)
					.append(this.classSection, other.classSection)
					.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
					.append(this.crseId)
					.append(this.crseOfferNbr)
					.append(this.strm)
					.append(this.sessionCode)
					.append(this.classSection)
					.toHashCode();
		}
	}

//	private class InstructorPk {
//		private String crseId;
//		private Integer crseOfferNbr;
//		private String strm;
//		private String sessionCode;
//		private String classSection;
//		private Integer classMtgNbr;
//		private Integer instrAssignSeq;
//	}

}
