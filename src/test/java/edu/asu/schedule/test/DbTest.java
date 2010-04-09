package edu.asu.schedule.test;

import edu.asu.schedule.dao.ScheduleDao;
import edu.asu.schedule.model.CatalogClass;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import javax.naming.NamingException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.apache.derby.jdbc.EmbeddedDriver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 *
 * @author alwold
 */
@ContextConfiguration({"/scheduleDao.xml", "/applicationContext.xml"})
public class DbTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Before
	public void setUp() throws SQLException, ClassNotFoundException, IOException, NamingException {
		Class.forName(EmbeddedDriver.class.getName());
		FileUtils.deleteDirectory(new File("scheduleDB"));
		Connection conn = DriverManager.getConnection("jdbc:derby:scheduleDB;create=true");
		Statement stmt = conn.createStatement();
		runDDL(stmt, "/ddl/PS_CLASS_TBL.sql");
		runDDL(stmt, "/ddl/PS_CLASS_INSTR.sql");
		runDDL(stmt, "/ddl/PS_CLASS_MTG_PAT.sql");
		runDDL(stmt, "/ddl/PS_NAMES.sql");
		importCsv(stmt, "PS_CLASS_TBL", "/ddl/PS_CLASS_TBL.csv");
		importCsv(stmt, "PS_CLASS_INSTR", "/ddl/PS_CLASS_INSTR.csv");
		importCsv(stmt, "PS_NAMES", "/ddl/PS_NAMES.csv");
		importCsv(stmt, "PS_CLASS_MTG_PAT", "/ddl/PS_CLASS_MTG_PAT.csv");
		stmt.close();
		conn.close();
	}

	private void runDDL(Statement stmt, String file) throws SQLException, IOException {
		for (String query: IOUtils.toString(DbTest.class.getResourceAsStream(file)).split(";")) {
			query = query.trim();
			if (!query.equals("")) {
				System.out.println("running "+query);
				try {
					stmt.executeUpdate(query);
				} catch (SQLException e) {
					System.out.println("Error in query!");
					throw e;
				}
			}
		}
	}

	private void importCsv(Statement stmt, String tableName, String file) throws SQLException {
		stmt.executeUpdate("CALL SYSCS_UTIL.SYSCS_IMPORT_DATA ('APP', '"+tableName+"', NULL, NULL, '"+ DbTest.class.getResource(file).getPath()+"', NULL, NULL, NULL, 0)");
	}

	@Test
	public void testFindClasses() {
		Collection<CatalogClass> classes = scheduleDao.findClasses("BIO", "360");
		Assert.assertEquals(23, classes.size());
	}

}
