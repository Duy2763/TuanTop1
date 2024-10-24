package daoInterface;

import java.util.List;

import entities.PhongBan;

public interface DAOPhongBan {
	public boolean themPhongBan(PhongBan pb);
	public List<PhongBan> getAllPhongBan();
	public PhongBan getPhongBanById(int id);
}
