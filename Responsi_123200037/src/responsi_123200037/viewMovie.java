
package responsi_123200037;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class viewMovie extends JFrame{
  JLabel lJudul = new JLabel("Judul Movie");
    JLabel lAlur = new JLabel("Alur Cerita");
    JLabel lPenokohan = new JLabel("Penokohan");
    JLabel lAkting = new JLabel("Akting");
    
    public JTextField tfJudul = new JTextField();
    public JTextField tfAlur = new JTextField();
    public JTextField tfPenokohan = new JTextField();
    public JTextField tfAkting=  new JTextField();
    
    public JButton butTambah = new JButton("Tambah");
    public JButton butUpdate = new JButton("Update");
    public JButton butDelete = new JButton("Delete");
    public JButton butClear = new JButton("Clear");
   
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Nilai Alur ", "Nilai Penokohan", "Nilai Akting", "Nilai Rating"};

    public viewMovie() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Rating Movie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(870,550);
        
        add(scrollPane);
        scrollPane.setBounds(30, 30, 550, 370);
        
        add(lJudul);
        lJudul.setBounds(680, 20, 90, 20);
        add(tfJudul);
        tfJudul.setBounds(630, 40, 160, 20);
        
        add(lAlur);
        lAlur.setBounds(680, 60, 90, 20);
        add(tfAlur);
        tfAlur.setBounds(630, 80, 160, 20);
        
        add(lPenokohan);
        lPenokohan.setBounds(680, 100, 90, 20);
        add(tfPenokohan);
        tfPenokohan.setBounds(630, 120, 160, 20);
        
        add(lAkting);
        lAkting.setBounds(690, 140, 90, 20);
        add(tfAkting);
        tfAkting.setBounds(630, 160, 160, 20);
        
        add(butTambah);
        butTambah.setBounds(610, 210, 90, 20);
        add(butUpdate);
        butUpdate.setBounds(720, 210, 90, 20);
        add(butDelete);
        butDelete.setBounds(610, 250, 90, 20);
        add(butClear);
        butClear.setBounds(720, 250, 90, 20);
     
    }
    
    public String getJudul(){
        return tfJudul.getText();
    }
    
    public String getAlur(){
        return tfAlur.getText();
    }
    
    public String getPenokohan(){
        return tfPenokohan.getText();
    }
    
    public String getAkting(){
        return tfAkting.getText();
    }
}