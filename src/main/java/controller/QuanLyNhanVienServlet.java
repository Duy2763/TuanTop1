package controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import daoImpl.DAONhanVienImpl;
import daoImpl.DAOPhongBanImpl;
import entities.NhanVien;

/**
 * Servlet implementation class QuanLyNhanVienServlet
 */
public class QuanLyNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private EntityManager manager;
	private DAOPhongBanImpl daoPhongBan;
	private DAONhanVienImpl daoNhanVien;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyNhanVienServlet() {
    	util = new EntityManagerFactoryUtil();
    	manager = util.getEntityManager();
    	daoPhongBan = new DAOPhongBanImpl(manager);
    	daoNhanVien = new DAONhanVienImpl(manager);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGetList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<NhanVien> dsNhanVien = daoNhanVien.getNhanVienByPhongBan();
    	request.setAttribute("dsNhanVien", dsNhanVien);
    	request.getRequestDispatcher("/views/DanhSachNhanVien.jsp").forward(request, response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGetAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("dsPhongBan", daoPhongBan.getAllPhongBan());
    	request.getRequestDispatcher("/views/ThemNhanVien.jsp").forward(request, response);
    }
    
    protected void doGetDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
    	daoNhanVien.deleteNhanVien(Integer.parseInt(id));
    	doGetList(request, response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPostAddNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String maPhongBan = request.getParameter("maPhongBan");
    	String tenNV = request.getParameter("tenNV");
    	String email = request.getParameter("email");
    	String diaChi = request.getParameter("diaChi");
    	String dienThoai = request.getParameter("dienThoai");
    	NhanVien nv = new NhanVien(tenNV, email, diaChi, dienThoai, daoPhongBan.getPhongBanById(Integer.parseInt(maPhongBan)));
    	// Tạo Validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        // Kiểm tra lỗi
        Set<ConstraintViolation<NhanVien>> violations = validator.validate(nv);
        if (!violations.isEmpty()) {
        	request.setAttribute("errors", violations);
        	doGetAdd(request, response);
        } else {
        	if (!daoNhanVien.checkEmail(email)) {
        		daoNhanVien.addNhanVien(nv);
            	doGetList(request, response);
        	} else 
        		request.setAttribute("errorEmail", "Email đã tồn tại");
        		doGetAdd(request, response);
        }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show = request.getParameter("show");
		switch (show) {
		case "list": 
			doGetList(request, response);
			break;
		case "add": 
			doGetAdd(request, response);
			break;
		case "delete": 
			doGetDelete(request, response);
			break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPostAddNV(request, response);
	}

}
