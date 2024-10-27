package Model_Controller;

import java.util.ArrayList;

public class DanhSachSanPham {
	private ArrayList<SanPham> list;
	public DanhSachSanPham() {
		list = new ArrayList<SanPham>();
	}
	
	public void themSanPham(SanPham obj) {
		list.add(obj);
	}
	public void xoaSanPham(SanPham obj) {
		list.remove(obj);
	}
	
	 public ArrayList<SanPham> getList() {
	        return list;
	 }
}
