<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Search Results</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${empty(requestScope.classes)}">
				No classes found!
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Class #</th>
						<th>Course</th>
						<th>Title</th>
						<th>Units</th>
						<th>Dates</th>
						<th>Days</th>
						<th>Start</th>
						<th>End</th>
						<th>Location</th>
						<th>Instructors</th>
						<th>Seats</th>
					</tr>
					<c:forEach var="catalogClass" items="${requestScope.classes}">
						<tr>
							<td>${catalogClass.classNbr}</td>
							<td>${catalogClass.subject} ${catalogClass.catalogNbr}</td>
							<td>${catalogClass.title}</td>
							<td></td>
							<td>${catalogClass.startDt} - ${catalogClass.endDt}</td>
							<td>${catalogClass.daysAsString}</td>
							<td>${catalogClass.meetingTimeStart}</td>
							<td>${catalogClass.meetingTimeEnd}</td>
							<td>${catalogClass.location}</td>
							<td>instructors</td>
							<td>${catalogClass.enrlTot} of ${catalogClass.enrlCap}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>
