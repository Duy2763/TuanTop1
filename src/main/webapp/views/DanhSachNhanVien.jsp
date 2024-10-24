<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhân viên</title>
    <script type="text/javascript">
        function confirmDelete() {
            return confirm("Bạn có chắc chắn muốn xóa nhân viên này không?");
        }
    </script>
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
            <h1>DANH SÁCH NHÂN VIÊN</h1>
            <table border="1">
                <tr>
                    <th>Tên phòng ban</th>
                    <th>MaNV</th>
                    <th>TênNV</th>
                    <th>Email</th>
                    <th>Địa chỉ</th>
                    <th>Điện thoại</th>
                    <th>Action</th>
                </tr>
                <c:choose>
                    <c:when test="${not empty dsNhanVien}">
                        <c:forEach var="nhanVien" items="${dsNhanVien}">
                            <tr>
                                <td>${nhanVien.phongBan.tenPhongBan}</td>
                                <td>${nhanVien.maNhanVien}</td>
                                <td>${nhanVien.tenNhanVien}</td>
                                <td>${nhanVien.email}</td>
                                <td>${nhanVien.diaChi}</td>
                                <td>${nhanVien.dienThoai}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/manage?show=delete&id=${nhanVien.maNhanVien}" onclick="return confirmDelete();">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h5>Danh sách nhân viên rỗng!</h5>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</body>
</html>
