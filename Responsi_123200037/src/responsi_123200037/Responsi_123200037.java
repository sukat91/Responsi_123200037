/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package responsi_123200037;

/**
 *
 * @author HP
 */
public class Responsi_123200037 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        viewMovie view = new viewMovie();
        modelMovie model = new modelMovie();
        controllerMovie controller = new controllerMovie(model, view);
    }
    
}
