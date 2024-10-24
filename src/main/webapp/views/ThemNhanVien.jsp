<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm nhân viên</title>
<style type="text/css">
	.error{
		color: red;
	}
	
</style>
</head>
<body>
	<div>
		<p>68_TuanTop1_88888888</p>
		<div style="display: flex; align-items: center; gap: 10px">	
			<a href="${pageContext.request.contextPath}/manage?show=list">Danh sách Nhân Viên</a>
			<p> | </p>
			<a href="${pageContext.request.contextPath}/manage?show=add">Thêm mới nhân viên</a>
		</div>
		<div>
			<h1>THÊM NHÂN VIÊN</h1>
			<form action="manage" method="POST">
				<div>
					<label for="tenPhongBan">Tên phòng ban</label>
					<select name="maPhongBan" id="tenPhongBan">
						<c:forEach var="phongBan" items="${dsPhongBan}">
							<option value="${phongBan.maPhongBan }">${phongBan.tenPhongBan }</option>
						</c:forEach>
					</select>
				</div>
				
				<div>
					<c:forEach var="violation" items="${errors}">
                        <c:if test="${ violation.propertyPath == 'tenNhanVien' }">
                             <div class="error">${violation.message}</div>
                        </c:if>
                    </c:forEach>
					<label for="tenNV">Tên nhân viên</label>
					<input placeholder="Tên nhân viên" id="tenNV" name="tenNV">
				</div>
				<div>
					<c:forEach var="violation" items="${errors}">
                        <c:if test="${ violation.propertyPath == 'email' }">
                             <div class="error">${violation.message}</div>
                        </c:if>
                    </c:forEach>
                    <c:if test="${ not empty errorEmail }">
                    	<div class="error">${errorEmail}</div>
                    </c:if>
					<label for="email">Email</label>
					<input placeholder="Email" id="email" name="email">
				</div>
				<div>
					<c:forEach var="violation" items="${errors}">
                       <c:if test="${ violation.propertyPath == 'diaChi' }">
                             <div class="error">${violation.message}</div>
                       </c:if>
                    </c:forEach>
					<label for="diaChi">Địa chỉ</label>
					<input placeholder="Địa chỉ" id="diaChi" name="diaChi">
				</div>
				<div>
					<c:forEach var="violation" items="${errors}">
                        <c:if test="${ violation.propertyPath == 'dienThoai' }">
                             <div class="error">${violation.message}</div>
                        </c:if>
                    </c:forEach>
					<label for="dienThoai">Điện thoại</label>
					<input placeholder="Điện thoại" id="dienThoai" name="dienThoai">
				</div>
				<input type="submit" value="Thêm">
			</form>
		</div>
	</div>
</body>
</html>