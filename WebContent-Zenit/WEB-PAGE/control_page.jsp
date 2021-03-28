<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='subjectBean' class='zenit.web.bean.SubjectBean' scope='session'></jsp:useBean>
<c:out value="${subjectBean.initialize(pageContext.session)}"></c:out>
<c:out value="${subjectBean.subjectController.refresh()}"></c:out>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Study Subjects</title>
		<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/WEB-CSS/links.css'></link>
	</head>
	<body>
		<h2>Study Subjects List</h2>
		<form method='POST'>
			<dl>
				<dt><b>ПРЕДМЕТИ</b></dt>
				<dd><br></dd>
				<dd><table>
					<c:forEach var='subjectId' items='${subjectBean.getSubjectKeys()}'>
						<c:set var='subject' value='${subjectBean.subjectController.get(subjectId)}'></c:set>
						<tr>
							<td>
								<a href='${pageContext.request.contextPath}/WEB-PAGE/report_preview.jsp?subject_id=${subjectBean.utilBean.url(subject.subjectId)}' style='text-decoration:none' target='_blank'><c:out value='${subjectId}'></c:out></a>
							</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>
								<a href='${pageContext.request.contextPath}/WEB-PAGE/report_preview.jsp?subject_id=${subjectBean.utilBean.url(subject.subjectId)}' style='text-decoration:none' target='_blank'><c:out value='${subject.subjectName}'></c:out></a>
							</td>
						</tr>
				</c:forEach>
				</table></dd>
			</dl>
	 	 </form>
	</body>
</html>