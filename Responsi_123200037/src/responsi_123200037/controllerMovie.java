
package responsi_123200037;

import java.awt.event.*;
import javax.swing.*;
public class controllerMovie {
    modelMovie modelMovie;
    viewMovie viewMovie;
    public String data;
    public controllerMovie(modelMovie modelMovie, viewMovie viewMovie){
        this.modelMovie = modelMovie;
        this.viewMovie = viewMovie;
        
        if (modelMovie.getBanyakData()!=0) {
            String dataMovie[][] = modelMovie.readdata();
            viewMovie.tabel.setModel((new JTable(dataMovie, viewMovie.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         viewMovie.butTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double alur,penokohan,akting;
                alur=Double.parseDouble(viewMovie.tfAlur.getText());
                penokohan=Double.parseDouble(viewMovie.tfPenokohan.getText());
                akting=Double.parseDouble(viewMovie.tfAkting.getText());
                if(alur<0||alur>5||penokohan<0||penokohan>5||akting<0||akting>5){
                JOptionPane.showMessageDialog(null,"INPUTAN NILAI HARUS (0-5)");
                }
                else {
                String Judul = viewMovie.getJudul();
                double Alur = Double.parseDouble(viewMovie.getAlur());
                double Penokohan = Double.parseDouble(viewMovie.getPenokohan());
                double Akting = Double.parseDouble(viewMovie.getAkting());
                double Nilai = (Alur+Penokohan+Akting)/3;
                modelMovie.insertData(Judul, Alur, Penokohan, Akting, Nilai);
         
                String dataMovie[][] = modelMovie.readdata();
                viewMovie.tabel.setModel((new JTable(dataMovie, viewMovie.namaKolom)).getModel());
                }
               
            }
        });
         
          viewMovie.butUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double alur,penokohan,akting;
                alur=Double.parseDouble(viewMovie.tfAlur.getText());
                penokohan=Double.parseDouble(viewMovie.tfPenokohan.getText());
                akting=Double.parseDouble(viewMovie.tfAkting.getText());
                if(alur<0||alur>5||penokohan<0||penokohan>5||akting<0||akting>5){
                JOptionPane.showMessageDialog(null,"INPUTAN NILAI HARUS (0-5)");
                }
                else {
                String Judul = viewMovie.getJudul();
                double Alur = Double.parseDouble(viewMovie.getAlur());
                double Penokohan = Double.parseDouble(viewMovie.getPenokohan());
                double Akting = Double.parseDouble(viewMovie.getAkting());
                double Nilai = (Alur+Penokohan+Akting)/3;
                modelMovie.insertData(Judul, Alur, Penokohan, Akting, Nilai);
         
                String dataMovie[][] = modelMovie.readdata();
                viewMovie.tabel.setModel((new JTable(dataMovie, viewMovie.namaKolom)).getModel());
                }
               
            }
        });
         
          viewMovie.butClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                viewMovie.tfJudul.setText("");
                viewMovie.tfAlur.setText("");
                viewMovie.tfPenokohan.setText("");
                viewMovie.tfAkting.setText("");
            }
        });
        
    
          viewMovie.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = viewMovie.tabel.getSelectedRow();
                data = viewMovie.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = viewMovie.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = viewMovie.tabel.getValueAt(baris, 1).toString();
                System.out.println(data);
            }
           });
                  
          viewMovie.butDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus Judul " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelMovie.deletedata(data);
                String dataMovie[][] = modelMovie.readdata();
                viewMovie.tabel.setModel((new JTable(dataMovie, viewMovie.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });
          
         


    }
    
}
