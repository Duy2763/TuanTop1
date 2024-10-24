package daoImpl;

import java.util.ArrayList;
import java.util.List;

import daoInterface.DAOPhongBan;
import entities.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAOPhongBanImpl implements DAOPhongBan{
	private EntityManager en;
	
	public DAOPhongBanImpl(EntityManager en) {
		super();
		this.en = en;
	}

	@Override
	public boolean themPhongBan(PhongBan pb) {
		EntityTransaction trans = null;
		try {
			trans = en.getTransaction();
			trans.begin();
			en.persist(pb);
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
	public List<PhongBan> getAllPhongBan() {
		List<PhongBan> ds = new ArrayList<PhongBan>();
		try {
			ds = en.createQuery("SELECT pb FROM PhongBan pb", PhongBan.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public PhongBan getPhongBanById(int id) {
		PhongBan pb = null;
		try {
			pb = en.createQuery("SELECT pb FROM PhongBan pb WHERE pb.maPhongBan = :id", PhongBan.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pb;
	}

}
