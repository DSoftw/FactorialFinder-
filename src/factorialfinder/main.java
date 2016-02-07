/**
 * Basic Factorial Calculator
 *
 * Copyright 2016 by David Acevedo Arredondo <david.acevedo26@hotmail.com>
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * FactorialFinder!. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package factorialfinder;

import javax.swing.JOptionPane;

/**
 *
 * @author David Acevedo
 */
public class main {

    public static FFGUI f;

    public static void main(String[] args) {
        f = new FFGUI();
        f.setVisible(true);
    }

    void findFactorial(final String text) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                double result = 0;
                double num = 0;
                try {
                    num = Double.parseDouble(text);
                    System.out.println(num);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico", "", 0);
                    f.jLabel3.setText("");
                }
                if (num > 70) {
                    f.jLabel3.setText("Math Error");
                } else if (num == 0) {
                    f.jLabel3.setText("1");
                } else {
                    for (int i = 1; i < num; i++) {
                        if (!(result > 0)) {
                            result = i * (i + 1);
                        } else {
                            result = result * (i + 1);
                        }
                    }
                    String r = result + "";
                    r = r.replace("E", " x10^");
                    r = r.replace(".0", "");
                    f.jLabel3.setText(r);
                }

            }

        });
        t.start();

    }

}
