<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="programBean" class='zenit.web.bean.ProgramBean' scope='session'></jsp:useBean>
<c:out value="${programBean.initialize(pageContext.session)}"></c:out>
<c:out value="${programBean.programController.refresh()}"></c:out>

<c:set var='subject' value='${linkSubjectBean.get(pageContext.request)}'></c:set>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Study Programs</title>
		<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/WEB-CSS/links.css'></link>
	</head>
	<body>
		<h2>Study Programs List</h2>
		<form method='POST'>
			<dl>
				<dt><b>ПРЕДМЕТИ</b></dt>
				<dd><br></dd>
				<dd><table>
					<c:forEach var='programId' items='${programBean.getProgramKeys()}'>
						<c:set var='program' value='${programBean.programController.get(programId)}'></c:set>
						<tr>
							<td>
								<a href='${pageContext.request.contextPath}/WEB-PAGE/program-report.jsp?program_name=${programBean.utilBean.url(program.id)}' style='text-decoration:none' target='_blank'><c:out value='${program.id}'></c:out></a>
							</td>
						</tr>
				</c:forEach>
				</table></dd>
			</dl>
		</form>
	</body>
</html>