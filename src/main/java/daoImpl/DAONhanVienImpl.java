package daoImpl;

import java.util.ArrayList;
import java.util.List;

import daoInterface.DAONhanVien;
import entities.NhanVien;
import entities.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class DAONhanVienImpl implements DAONhanVien{
	private EntityManager en;
	
	public DAONhanVienImpl(EntityManager en) {
		super();
		this.en = en;
	}
	@Override
	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			ds = en.createQuery("SELECT n FROM NhanVien n", NhanVien.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public List<NhanVien> getNhanVienByPhongBan() {
		List<NhanVien> ds = new ArrayList<NhanVien>();
		String jpql = "SELECT nv FROM NhanVien nv ORDER BY nv.phongBan.tenPhongBan ASC";

		try {
			ds = en.createQuery(jpql, NhanVien.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
		
	}
	@Override
	public boolean addNhanVien(NhanVien nv) {
		EntityTransaction trans = null;
		try {
			trans = en.getTransaction();
			trans.begin();
			en.persist(nv);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteNhanVien(int id) {
		EntityTransaction trans = null;
		try {
			trans = en.getTransaction();
			trans.begin();
			NhanVien nv = en.find(NhanVien.class, id);
			if (nv != null) {
				en.remove(nv);
				trans.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
		return false;
	}
	@Override
	public boolean checkEmail(String email) {
		String jpql = "SELECT COUNT(nv) FROM NhanVien nv WHERE nv.email = :email";
        TypedQuery<Long> query = en.createQuery(jpql, Long.class);
        query.setParameter("email", email);
        Long count = query.getSingleResult();
        return count > 0;
	}

}
