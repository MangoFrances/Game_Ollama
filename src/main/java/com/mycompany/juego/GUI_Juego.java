/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.juego;


import java.awt.Color;
import javax.swing.JOptionPane;


/**
 *
 * @author migue
 */
public class GUI_Juego extends javax.swing.JFrame {
 
    
    public GUI_Juego() {
        
        initComponents();
             

    // Inicializar selección en la posición (0, 0)
        matriz.changeSelection(row, column, false, false);
        String nombre = JOptionPane.showInputDialog(null, "Escribe tu nombre:", "Ingresar Nombre", JOptionPane.QUESTION_MESSAGE);
        nombretxt.setText(nombre);
                            
        // Inicializar selección en la posición (0, 0)
        matriz.changeSelection(row, column, false, false);
        //la casilla donde el jugador aparece no tiene nada que es en 0,0
        matriz.setValueAt(1, 0, 0);
        
        int i, j,nf=10,nc=10;
         i=0;
         j=0;
         
         int [][]v= new int [nf][nc];
         llenar (v,nf,nc,i,j);
         for (i = 0; i < 10; i++) {
            for ( j = 1; j < 10; j++) {
               // System.out.print(v[i][j]+" ");
            }
             System.out.println("");
          }
                
         matriz.setCellSelectionEnabled(false);
         matriz.setRowSelectionAllowed(false);
         matriz.setColumnSelectionAllowed(false);   
         matriz.setDefaultEditor(Object.class, null);
                 
         
    }
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output_pista = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        matriz = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tesoros = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        puntaje_actual = new javax.swing.JTextField();
        nombretxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rowtxt = new javax.swing.JTextField();
        columntxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        down = new javax.swing.JButton();
        left = new javax.swing.JButton();
        up = new javax.swing.JButton();
        right = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(747, 458));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pista.png"))); // NOI18N
        jButton2.setText("Pedir pista");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        output_pista.setColumns(20);
        output_pista.setRows(5);
        jScrollPane1.setViewportView(output_pista);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Treasure Finder");

        jScrollPane2.setBackground(new java.awt.Color(255, 204, 0));
        jScrollPane2.setForeground(new java.awt.Color(255, 204, 0));

        matriz.setBackground(new java.awt.Color(255, 204, 0));
        matriz.setBorder(new javax.swing.border.MatteBorder(null));
        matriz.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        matriz.setAutoscrolls(false);
        matriz.setUpdateSelectionOnSort(false);
        matriz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matrizMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(matriz);
        if (matriz.getColumnModel().getColumnCount() > 0) {
            matriz.getColumnModel().getColumn(0).setResizable(false);
            matriz.getColumnModel().getColumn(1).setResizable(false);
            matriz.getColumnModel().getColumn(2).setResizable(false);
            matriz.getColumnModel().getColumn(3).setResizable(false);
            matriz.getColumnModel().getColumn(4).setResizable(false);
            matriz.getColumnModel().getColumn(5).setResizable(false);
            matriz.getColumnModel().getColumn(6).setResizable(false);
            matriz.getColumnModel().getColumn(7).setResizable(false);
            matriz.getColumnModel().getColumn(8).setResizable(false);
            matriz.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setText("Casillas de tesoros");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Estadisticas de");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tesoros encontrados:");

        tesoros.setBackground(new java.awt.Color(255, 255, 255));
        tesoros.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tu puntaje actual:");

        puntaje_actual.setBackground(new java.awt.Color(255, 255, 255));
        puntaje_actual.setForeground(new java.awt.Color(0, 0, 0));
        puntaje_actual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntaje_actualActionPerformed(evt);
            }
        });

        nombretxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(153, 0, 0));
        nombretxt.setText("-");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Posición actual:");

        rowtxt.setBackground(new java.awt.Color(255, 255, 255));
        rowtxt.setForeground(new java.awt.Color(0, 0, 0));
        rowtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowtxtActionPerformed(evt);
            }
        });

        columntxt.setBackground(new java.awt.Color(255, 255, 255));
        columntxt.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("X:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Y:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tesoros, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(puntaje_actual)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(9, 9, 9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(23, 23, 23)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rowtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(columntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombretxt)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tesoros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(puntaje_actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        down.setText("Down");
        down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downMouseClicked(evt);
            }
        });

        left.setText("Left");
        left.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftMouseClicked(evt);
            }
        });
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        up.setText("Up");
        up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upMouseClicked(evt);
            }
        });

        right.setText("Right");
        right.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightMouseClicked(evt);
            }
        });
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(116, 116, 116)
                                        .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(243, 243, 243)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(down, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                            .addComponent(up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(145, 145, 145)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
        JOptionPane.showMessageDialog(null, "Gracias por jugar!", "Salida", JOptionPane.CLOSED_OPTION);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void puntaje_actualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntaje_actualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puntaje_actualActionPerformed

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rightActionPerformed

    private void matrizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matrizMouseClicked
      int row = matriz.rowAtPoint(evt.getPoint());
      int column = matriz.columnAtPoint(evt.getPoint());
      System.out.println("Clic en la celda: (" + row + ", " + column + ")");
      JOptionPane.showMessageDialog(GUI_Juego.this,
                        "Posición seleccionada: Fila = " + row + ", Columna = " + column,
                        "Posición de la Casilla",
                        JOptionPane.INFORMATION_MESSAGE);
      //esto es para verificar el contenido de las celdas, se quita en la version final  
      //Object valor = matriz.getValueAt(row, column);
      //System.out.println("Valor " +valor);
      
    }//GEN-LAST:event_matrizMouseClicked

    private void upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseClicked
        moverJugador(-1, 0);
    }//GEN-LAST:event_upMouseClicked

    private void downMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downMouseClicked
        moverJugador(1, 0);
    }//GEN-LAST:event_downMouseClicked

    private void leftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftMouseClicked
        moverJugador(0, -1);
    }//GEN-LAST:event_leftMouseClicked

    private void rightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightMouseClicked
        moverJugador(0, 1);
        
    }//GEN-LAST:event_rightMouseClicked

    private void rowtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowtxtActionPerformed
    
    
    public void llenar (int m[][],int nf, int nc,int i ,int j){
    
    if (i>=nf){
        return;
    }
    if (Math.random()*1<=0.50){
        m[i][j]= 1;
        matriz.setValueAt(1, i, j);
    }else if (Math.random()*1>0.50&& Math.random()*1<=0.75){
        m[i][j]=2;
        matriz.setValueAt(2, i, j);
    }else {
        m[i][j]=3;
        matriz.setValueAt(3, i, j);
        //si m=1 esta vacio si m=2 es tesoro y si m=3 es trampa
    }
    if (j<nc-1){
        llenar (m,nf,nc,i,j+1);
    }else {
        llenar (m,nf,nc,i+1,0);
    }   
    //esto es para que en la posición 0, 0 de la matriz no haya nada (que es la posición inicial del jugador)
    matriz.setValueAt(1, 0, 0);
}
    int row = 0;
    int column = 0;
    private int ct = 0;
    private int punt = 0;
    //funcion para mover el jugador y calular puntajes
    private void moverJugador(int dRow, int dColumn) {
        int newRow = row + dRow;
        int newColumn = column + dColumn;
       
        //esto verifica que la nueva posición esté dentro de los límites del JTable
        if (newRow >= 0 && newRow < matriz.getRowCount() && newColumn >= 0 && newColumn < matriz.getColumnCount()) {
                       
            //actualiza la posición del jugador
            row = newRow;
            column = newColumn;
             
            matriz.changeSelection(row, column, false, false);

            //obtener el valor de la celda a la que llegó el jugador
            int cellValue = (int) matriz.getValueAt(row, column);
            
            //las variables row y column indican la posición actual del jugador
            System.out.println("El jugador llegó a la posición (" + row + ", " + column + ") con valor: " + cellValue);
            String rowtemp; 
            String columntemp;
            rowtemp = Integer.toString(row);
            columntemp = Integer.toString(column);
            rowtxt.setText(rowtemp);
            columntxt.setText(columntemp);
            String tes, strpunt;
         if(cellValue == 2){
                ct = ct + 1;
                tes = String.valueOf(ct);
                tesoros.setText(tes);
                punt = punt + 500;
                strpunt = String.valueOf(punt);
                puntaje_actual.setText(strpunt);
          }
          if(cellValue == 3){
              punt = punt - 200;
              strpunt = String.valueOf(punt);
              puntaje_actual.setText(strpunt);
          }               
    }
    
   }
    
          
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField columntxt;
    private javax.swing.JButton down;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton left;
    private javax.swing.JTable matriz;
    private javax.swing.JLabel nombretxt;
    private javax.swing.JTextArea output_pista;
    private javax.swing.JTextField puntaje_actual;
    private javax.swing.JButton right;
    private javax.swing.JTextField rowtxt;
    private javax.swing.JTextField tesoros;
    private javax.swing.JButton up;
    // End of variables declaration//GEN-END:variables
}
