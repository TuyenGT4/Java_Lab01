package Model_Controller;

import java.util.ArrayList;

public class DanhSachLoaiSanPham {
	private ArrayList<LoaiSP> list;
	public DanhSachLoaiSanPham() {
		list = new ArrayList<LoaiSP>();
	}
	
	public void themSanPham(LoaiSP obj) {
		list.add(obj);
	}
	public void xoaSanPham(LoaiSP obj) {
		list.remove(obj);
	}
	
	 public ArrayList<LoaiSP> getList() {
	        return list;
	 }
}
