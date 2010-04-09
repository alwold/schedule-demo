package edu.asu.schedule.dao;

import edu.asu.schedule.model.CatalogClass;
import java.util.Collection;

/**
 *
 * @author alwold
 */
public interface ScheduleDao {
	public Collection<CatalogClass> findClasses(String subject, String catalogNbr);

}
