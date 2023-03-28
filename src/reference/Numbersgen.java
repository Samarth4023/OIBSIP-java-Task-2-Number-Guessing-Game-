/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reference;

/**
 *
 * @author LENOVO
 */
public class Numbersgen {
    
    private static int _RANDOMNUMBER = 0;
    
    public static int _r_Number() {
        _RANDOMNUMBER = (int) Math.round(Math.random() * 100);
        return _check_zero(_RANDOMNUMBER);
    }
    
    private static int _check_zero(int n) {
        int n_Num = 0;
        if (n == 0) {
            n_Num = _r_Number();
        }else {
            n_Num = n;
        }
        return n_Num;
    }
}