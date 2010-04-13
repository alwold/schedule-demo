package edu.asu.schedule.web;

import edu.asu.schedule.dao.ScheduleDao;
import edu.asu.schedule.model.CatalogClass;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author alwold
 */
public class ScheduleSearchServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(ScheduleSearchServlet.class);
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ScheduleDao dao = (ScheduleDao) ctx.getBean("scheduleDao");

		String subject = request.getParameter("subject");
		String catalogNbr = request.getParameter("catalogNbr");

		Collection<CatalogClass> classes = dao.findClasses(subject, catalogNbr);
		request.setAttribute("classes", classes);
		logger.trace("got "+classes.size()+" classes back from search");
		request.setAttribute("timeFormatter", new HashMap<Date, String>() {
			private DateFormat df = new SimpleDateFormat("h:mm a");

			@Override
			public String get(Object key) {
				return df.format((Date) key);
			}
		});
		
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
	}

}
