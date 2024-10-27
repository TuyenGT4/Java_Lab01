package Model_Controller;

import View.Interface;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class controller {
    private Interface view;
    private DanhSachSanPham model;
    private DefaultTableModel tableModel;

    public controller(Interface view) {
        this.view = view;
        this.model = new DanhSachSanPham();
        this.tableModel = (DefaultTableModel) view.getTable().getModel();
        
        // Khởi tạo các sự kiện
        initializeEvents();
    }

    private void initializeEvents() {
        // Sự kiện nút Thêm
        view.getBtnThem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                enableFields(true);
                view.getBtnLuu().setEnabled(true);
                view.getBtnKLuu().setEnabled(true);
            }
        });

        // Sự kiện nút Xóa
        view.getBtnXoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    int option = JOptionPane.showConfirmDialog(view,
                            "Bạn có chắc muốn xóa sản phẩm này?",
                            "Xác nhận xóa",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        clearFields();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Vui lòng chọn sản phẩm cần xóa!");
                }
            }
        });

        // Sự kiện nút Sửa
        view.getBtnSua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    enableFields(true);
                    view.getBtnLuu().setEnabled(true);
                    view.getBtnKLuu().setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(view, "Vui lòng chọn sản phẩm cần sửa!");
                }
            }
        });

        // Sự kiện nút Lưu
        view.getBtnLuu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    SanPham sp = new SanPham(
                            view.getTextFieldMaLoai().getText(),
                            view.getTextFieldTenLoai().getText(),
                            Long.parseLong(view.getTextFieldDonGia().getText())
                    );
                    
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow >= 0) {
                        // Cập nhật sản phẩm
                        updateTableRow(selectedRow, sp);
                    } else {
                        // Thêm sản phẩm mới
                        addTableRow(sp);
                    }
                    
                    clearFields();
                    enableFields(false);
                    view.getBtnLuu().setEnabled(false);
                    view.getBtnKLuu().setEnabled(false);
                }
            }
        });

        // Sự kiện nút Không Lưu
        view.getBtnKLuu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                enableFields(false);
                view.getBtnLuu().setEnabled(false);
                view.getBtnKLuu().setEnabled(false);
            }
        });

        // Sự kiện nút Thoát
        view.getBtnThoat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(view,
                        "Bạn có chắc muốn thoát chương trình?",
                        "Xác nhận thoát",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Sự kiện click vào bảng
        view.getTable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    String maLoai = tableModel.getValueAt(selectedRow, 0).toString();
                    String tenLoai = tableModel.getValueAt(selectedRow, 1).toString();
                    String donGia = tableModel.getValueAt(selectedRow, 2).toString();
                    
                    view.getTextFieldMaLoai().setText(maLoai);
                    view.getTextFieldTenLoai().setText(tenLoai);
                    view.getTextFieldDonGia().setText(donGia);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    private boolean validateInput() {
        if (view.getTextFieldMaLoai().getText().trim().isEmpty() ||
            view.getTextFieldTenLoai().getText().trim().isEmpty() ||
            view.getTextFieldDonGia().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }
        
        try {
            Long.parseLong(view.getTextFieldDonGia().getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Đơn giá phải là số!");
            return false;
        }
        
        return true;
    }

    private void clearFields() {
        view.getTextFieldMaLoai().setText("");
        view.getTextFieldTenLoai().setText("");
        view.getTextFieldDonGia().setText("");
    }

    private void enableFields(boolean enable) {
        view.getTextFieldMaLoai().setEnabled(enable);
        view.getTextFieldTenLoai().setEnabled(enable);
        view.getTextFieldDonGia().setEnabled(enable);
    }

    private void addTableRow(SanPham sp) {
        Object[] row = new Object[]{
                sp.getMaLoai(),
                sp.getTenLoai(),
                sp.getDonGia()
        };
        tableModel.addRow(row);
        model.themSanPham(sp);
    }

    private void updateTableRow(int row, SanPham sp) {
        tableModel.setValueAt(sp.getMaLoai(), row, 0);
        tableModel.setValueAt(sp.getTenLoai(), row, 1);
        tableModel.setValueAt(sp.getDonGia(), row, 2);
    }
}
