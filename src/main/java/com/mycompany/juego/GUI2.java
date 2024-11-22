/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author becer
 */
public class GUI2 extends javax.swing.JFrame {

    private static String errorHandler(int code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String nombremodelo = "gemma2:2b";
    String chats2[] = new String[20];

    ArrayList<ArrayList<String>> datos = new ArrayList<>(20);
    GUI_Juego game = new GUI_Juego(); 
    
    private static final String DB_URL = "jdbc:sqlite:chatbot.db";
    
    
    public GUI2() {
        initComponents();
        
        
    }
    
    private void prompt() {
        
        
            
    }
    
    public void rescatavectorinador(String v[]) {
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnjuego = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Juego de Ollama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 280, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 310, -1));

        btnjuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnjuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/game-console.png"))); // NOI18N
        btnjuego.setText("Abrir Juego");
        btnjuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjuegoMouseClicked(evt);
            }
        });
        getContentPane().add(btnjuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 260, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnjuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjuegoMouseClicked
        game.setVisible(true);
    }//GEN-LAST:event_btnjuegoMouseClicked
    
    
      
    
        
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
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnjuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
public static String ollama(String nombremodelo, String promptText) {
        double inicio = System.currentTimeMillis(); // Marca de tiempo de inicio
        try {
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Configura tiempos de espera para conexión y lectura
            conn.setConnectTimeout(40000); // Tiempo de espera para conectar (5 segundos)
            conn.setReadTimeout(40000); // Tiempo de espera para leer datos (5 segundos)

            String jsonInputString = String.format(
                    "{\"model\": \"%s\", \"prompt\": \"Por favor, responde siempre en español. %s\", \"stream\": false}",
                    nombremodelo, promptText);

            try ( OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            String errorMessage = errorHandler(code);
            if (errorMessage != null) {
                return errorMessage;
            } else {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                String responseText = jsonResponse.getString("response");
                // Configuramos `setConnectTimeout` y `setReadTimeout` para limitar automáticamente el tiempo de espera 
                // en la conexión y lectura, lanzando `SocketTimeoutException` si se excede el límite. Además, medimos el 
                // tiempo total de ejecución con `System.currentTimeMillis()` para monitorear el rendimiento global de la operación.

                // double fin = System.currentTimeMillis(); 
                // double tiempoTotal = fin - inicio;
                //if (tiempoTotal > 5000) { // 5000 milisegundos = 5 segundos
                //return "Error: Tiempo de respuesta excedido. Tiempo total: " + tiempoTotal + " ms";
                // }
                // Devolver la respuesta
                return "Exitoso: " + responseText;
            }

        } catch (SocketTimeoutException e) {
            return "Error: Tiempo de espera de conexión o lectura excedido";
        } catch (MalformedURLException e) {
            return "La URL es inválida: " + e.getMessage();
        } catch (IOException e) {
            return "Error de conexión: " + e.getMessage();
        }
    }
    /* esto genera un error nose por que -miguel
    private static String errorHandler(int code) {
        switch (code) {
            case 400:
                return "Error 400: Solicitud incorrecta. No terminar o empezar Prompt con tecla (Enter o Espacio).";
            case 401:
                return "Error 401: No autorizado. Verifica tus credenciales de autenticación.";
            case 403:
                return "Error 403: Prohibido. No tienes permiso para acceder a este recurso.";
            case 404:
                return "Error 404: El recurso solicitado no fue encontrado. Verifica el endpoint y el servidor.";
            case 500:
                return "Error 500: Error interno del servidor. Intenta nuevamente más tarde.";
            case 503:
                return "Error 503: Servicio no disponible. El servidor podría estar en mantenimiento.";
            default:
                return null;
        }
    }
    */
    public String[] getChats2() {
        return chats2.clone();
    }
    
    private String getConversation(String chatName) {
        int index = findChatIndexByName(chatName);
        if (index != -1) {
            StringBuilder conversation = new StringBuilder();
            for (String mensaje : datos.get(index)) {
                if (mensaje != null) {
                    conversation.append(mensaje).append("\n");
                }
            }
            return conversation.toString();
        }
        return "Conversación no encontrada.";
    }
    private int findChatIndexByName(String chatName) {
        for (int i = 0; i < chats2.length; i++) {
            if (chatName.equals(chats2[i])) {
                return i;
            }
        }
        return -1;
    }
}
