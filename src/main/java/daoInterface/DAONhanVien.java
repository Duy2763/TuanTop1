package daoInterface;

import java.util.List;

import entities.NhanVien;

public interface DAONhanVien {
	public List<NhanVien> getAllNhanVien();
	public List<NhanVien> getNhanVienByPhongBan();
	public boolean addNhanVien(NhanVien nv);
	public boolean deleteNhanVien(int id);
	public boolean checkEmail(String email);
}
