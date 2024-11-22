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
        for (int i = 0; i < 20; i++) {
            datos.add(new ArrayList<>());
        }
        prompt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.isShiftDown()) {
                        // Shift + Enter: Añadir salto de línea sin enviar el mensaje
                        prompt.setText(prompt.getText() + "\n");
                        e.consume(); // Evitar que se interprete como un envío
                    } else {
                        // Enter sin Shift: Envía el mensaje
                        e.consume(); // Previene el salto de línea en el JTextPane
                        prompt();    // Envía el mensaje
                    }
                }
            }
        });
    }
    
    private void prompt() {
        String texto = prompt.getText().trim(); // Toca usar una variable para limpiar espacios sera erroneo si lo hacemos directo en el IF
        if (!texto.isEmpty()) {
            output.append("Usuario: " + texto + "\n");

            String entrada = texto;
            String milagro = (ollama(nombremodelo, entrada) + "\n");

            output.append("Respuesta: " + milagro + "\n");
            prompt.setText("");

            int index = chats.getSelectedIndex();
            if (index != -1) {
                datos.get(index).add("Usuario: " + entrada);
                datos.get(index).add("Respuesta: " + milagro);
                System.out.println("Mensajes almacenados en el chat " + index + ": " + datos.get(index)); // Prueba debug
            }
        }
    }
    
    public void rescatavectorinador(String v[]) {
        String v2[] = new String[v.length];
      
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prompt = new javax.swing.JTextPane();
        terminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        chats = new javax.swing.JList<>();
        btneliminar = new javax.swing.JButton();
        btnjuego = new javax.swing.JButton();
        btnhistorial = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        btn_prompt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Ollama Chatbot");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 160, -1));

        output.setColumns(20);
        output.setForeground(new java.awt.Color(255, 255, 255));
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 550, 480));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 310, -1));

        jLabel3.setText("Introduce tu texto aqui:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 240, -1));

        jScrollPane2.setViewportView(prompt);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 460, -1));

        terminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/save.png"))); // NOI18N
        terminar.setText("Save");
        terminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                terminarMouseClicked(evt);
            }
        });
        getContentPane().add(terminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 563, 80, 30));

        chats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(chats);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 540));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/recycle-bin.png"))); // NOI18N
        btneliminar.setText("Delete");
        btneliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminarMouseClicked(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        btnjuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/game-console.png"))); // NOI18N
        btnjuego.setText("Abrir Juego");
        btnjuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjuegoMouseClicked(evt);
            }
        });
        getContentPane().add(btnjuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 130, 50));

        btnhistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/chat.png"))); // NOI18N
        btnhistorial.setText("History");
        btnhistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhistorialMouseClicked(evt);
            }
        });
        getContentPane().add(btnhistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 130, -1));

        btnborrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/data-cleaning.png"))); // NOI18N
        btnborrar.setText("Clean");
        btnborrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnborrarMouseClicked(evt);
            }
        });
        getContentPane().add(btnborrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 130, -1));

        btn_prompt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/juego/send-message.png"))); // NOI18N
        btn_prompt.setText("Send");
        btn_prompt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_promptMouseClicked(evt);
            }
        });
        getContentPane().add(btn_prompt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatsMouseClicked
        int index = chats.getSelectedIndex();
        if (index != -1) {
            output.setText("");

            // Obtiene el historial completo del chat seleccionado desde `datos`
            ArrayList<String> conversation = datos.get(index);

            System.out.println("Contenido de conversation para el chat " + index + ": " + conversation);//Prueba ddebug
            StringBuilder conversationText = new StringBuilder();
            for (String mensaje : conversation) {
                conversationText.append(mensaje).append("\n");
            }

            output.setText(conversationText.toString());
        }
    }//GEN-LAST:event_chatsMouseClicked

    private void terminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_terminarMouseClicked
        int i = 0;
        while (i < chats2.length && chats2[i] != null) {
            i++;
        }

        String name = JOptionPane.showInputDialog(null, "Ingrese nombre del nuevo chat", "Guardar chat", JOptionPane.INFORMATION_MESSAGE);
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingresó un nombre válido para el chat.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean guardado = false;

        // Encuentra una posición vacía en `chats2` para el nuevo chat
        for (i = 0; i < chats2.length; i++) {
            if (chats2[i] == null) {
                chats2[i] = name;
                guardado = true;

                // Asegúrate de que `datos` tenga una lista para este nuevo chat
                // Si `datos` ya tiene listas adicionales, usa la que corresponde al índice, de lo contrario, agrega una nueva
                if (i < datos.size()) {
                    datos.set(i, new ArrayList<>());
                } else {
                    datos.add(new ArrayList<>());
                }

                break;
            }
        }

        if (guardado) {
            chats.setListData(chats2);  // Actualiza la lista de chats visibles
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo crear el chat. Verifique el nombre.", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_terminarMouseClicked

    private void btneliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseClicked
        int index = chats.getSelectedIndex();

        if (index != -1 && chats2[index] != null) {

            for (int i = index; i < chats2.length - 1; i++) {
                chats2[i] = chats2[i + 1];
            }
            chats2[chats2.length - 1] = null;

            chats.setListData(chats2);
            JOptionPane.showMessageDialog(null, "Chat eliminado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un chat válido para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarMouseClicked

    private void btnjuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjuegoMouseClicked
        game.setVisible(true);
    }//GEN-LAST:event_btnjuegoMouseClicked

    private void btnhistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhistorialMouseClicked
        //historial.setVisible(true);
        chats.setListData(chats2);
        JOptionPane.showMessageDialog(null, "Esta función no esta disponible", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnhistorialMouseClicked

    private void btn_promptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_promptMouseClicked
        prompt();
    }//GEN-LAST:event_btn_promptMouseClicked

    private void btnborrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnborrarMouseClicked
        output.setText("");
    }//GEN-LAST:event_btnborrarMouseClicked
    
    
    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {                                        

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (evt.isShiftDown()) {
                // Shift + Enter: Inserta un salto de línea en el prompt
                prompt.setText(prompt.getText() + "\n");
            } else {

                evt.consume();
                prompt();
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
    private javax.swing.JButton btn_prompt;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnhistorial;
    private javax.swing.JButton btnjuego;
    private javax.swing.JList<String> chats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea output;
    private javax.swing.JTextPane prompt;
    private javax.swing.JButton terminar;
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
