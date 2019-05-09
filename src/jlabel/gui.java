package jlabel;

import converte.escalaCinza;
import funcoes.funcoes;
import transformacaoGeometrica.TransformacaoGeometrica;
import filtros.brilhoContraste;
import filtros.media;
import filtros.mediana;
import filtros.gauss;
import filtros.limiarizacao;
import filtros.sobel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class gui extends javax.swing.JFrame {

    public gui() {
        initComponents();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImgOriginal = new javax.swing.JLabel();
        txtImagemOriginal = new javax.swing.JLabel();
        txtImagemEditada = new javax.swing.JLabel();
        labelImgEditada = new javax.swing.JLabel();
        sliderRotacao = new javax.swing.JSlider();
        labelRotacao = new javax.swing.JLabel();
        sliderEscala = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        offsetX = new javax.swing.JSpinner();
        offsetY = new javax.swing.JSpinner();
        labelOffSetX = new javax.swing.JLabel();
        labelOffSetY = new javax.swing.JLabel();
        sliderBrilho = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        labelValorBrilho = new javax.swing.JLabel();
        sliderContraste = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        labelValorContraste = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        arquivoAbrir = new javax.swing.JMenuItem();
        menuEscalaCinza = new javax.swing.JMenu();
        cinzaConverter = new javax.swing.JMenuItem();
        cinzaDados = new javax.swing.JMenuItem();
        menuSuavizacao = new javax.swing.JMenu();
        suavizacaoMedia = new javax.swing.JMenuItem();
        suavizacaoMediana = new javax.swing.JMenuItem();
        suavizacaoGauss = new javax.swing.JMenuItem();
        menuEspelhar = new javax.swing.JMenu();
        espelharHorizontalmente = new javax.swing.JMenuItem();
        espelharVerticalmente = new javax.swing.JMenuItem();
        menuThreshold = new javax.swing.JMenu();
        thresholdSobel = new javax.swing.JMenuItem();
        thresholdLimiarizacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Processamento Digital de Imagens");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.white);

        labelImgOriginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtImagemOriginal.setText("Imagem original");

        txtImagemEditada.setText("Imagem editada");

        labelImgEditada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sliderRotacao.setMaximum(360);
        sliderRotacao.setValue(0);
        sliderRotacao.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderRotacaoStateChanged(evt);
            }
        });

        labelRotacao.setText("Rotacionar");

        sliderEscala.setMaximum(200);
        sliderEscala.setValue(100);
        sliderEscala.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderEscalaStateChanged(evt);
            }
        });

        jLabel2.setText("Escala");

        offsetX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                offsetXStateChanged(evt);
            }
        });

        offsetY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                offsetYStateChanged(evt);
            }
        });

        labelOffSetX.setText("Offset X");

        labelOffSetY.setText("Offset Y");

        sliderBrilho.setMinimum(-100);
        sliderBrilho.setValue(0);
        sliderBrilho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrilhoStateChanged(evt);
            }
        });

        jLabel1.setText("Brilho");

        labelValorBrilho.setText("0");

        sliderContraste.setMaximum(200);
        sliderContraste.setValue(100);
        sliderContraste.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderContrasteStateChanged(evt);
            }
        });

        jLabel3.setText("Contraste");

        labelValorContraste.setText("1");

        menuArquivo.setText("Arquivo");

        arquivoAbrir.setText("Abrir");
        arquivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(arquivoAbrir);

        barraMenu.add(menuArquivo);

        menuEscalaCinza.setText("Escala Cinza");

        cinzaConverter.setText("Converter");
        cinzaConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinzaConverterActionPerformed(evt);
            }
        });
        menuEscalaCinza.add(cinzaConverter);

        cinzaDados.setText("Dados");
        cinzaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinzaDadosActionPerformed(evt);
            }
        });
        menuEscalaCinza.add(cinzaDados);

        barraMenu.add(menuEscalaCinza);

        menuSuavizacao.setText("Suavização");

        suavizacaoMedia.setText("Media");
        suavizacaoMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suavizacaoMediaActionPerformed(evt);
            }
        });
        menuSuavizacao.add(suavizacaoMedia);

        suavizacaoMediana.setText("Mediana");
        suavizacaoMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suavizacaoMedianaActionPerformed(evt);
            }
        });
        menuSuavizacao.add(suavizacaoMediana);

        suavizacaoGauss.setText("Graussiano");
        suavizacaoGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suavizacaoGaussActionPerformed(evt);
            }
        });
        menuSuavizacao.add(suavizacaoGauss);

        barraMenu.add(menuSuavizacao);

        menuEspelhar.setText("Espelhar");

        espelharHorizontalmente.setText("Horizontal");
        espelharHorizontalmente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espelharHorizontalmenteActionPerformed(evt);
            }
        });
        menuEspelhar.add(espelharHorizontalmente);

        espelharVerticalmente.setText("Vertical");
        espelharVerticalmente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espelharVerticalmenteActionPerformed(evt);
            }
        });
        menuEspelhar.add(espelharVerticalmente);

        barraMenu.add(menuEspelhar);

        menuThreshold.setText("Threshold");

        thresholdSobel.setText("Sobel");
        thresholdSobel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdSobelActionPerformed(evt);
            }
        });
        menuThreshold.add(thresholdSobel);

        thresholdLimiarizacao.setText("Limiarização");
        thresholdLimiarizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdLimiarizacaoActionPerformed(evt);
            }
        });
        menuThreshold.add(thresholdLimiarizacao);

        barraMenu.add(menuThreshold);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sliderBrilho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelValorContraste))
                            .addComponent(labelImgOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImagemOriginal)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(sliderEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(sliderContraste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelValorBrilho)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelOffSetX)
                                    .addComponent(labelOffSetY))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(offsetX, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(offsetY)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtImagemEditada)
                                    .addComponent(labelImgEditada, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRotacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderRotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImagemOriginal)
                    .addComponent(txtImagemEditada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelImgOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(labelImgEditada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRotacao)
                    .addComponent(sliderRotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(offsetX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOffSetX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(offsetY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOffSetY)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(sliderEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(sliderContraste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelValorBrilho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(sliderBrilho, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelValorContraste))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelImgOriginal.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    BufferedImage imagem_original = null;
    BufferedImage imagem_editada = null;
    BufferedImage copia_editada = null;
    
    guiDados gDados = new guiDados();
    
    funcoes funcoes = new funcoes();
    escalaCinza cinza = new escalaCinza();
    TransformacaoGeometrica transfoma = new TransformacaoGeometrica();
       
    private void arquivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoAbrirActionPerformed
        //Abre a imagem
        imagem_original = funcoes.carregaImagem();
        //Copia a imagem
        imagem_editada = funcoes.copiaImagem(imagem_original);
        copia_editada = funcoes.copiaImagem(imagem_editada);
        //Sets dos labels com escalas
        labelImgOriginal.setIcon(new ImageIcon(imagem_original.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
        //Reseta os sliders
        sliderRotacao.setValue(0);
        sliderEscala.setValue(100);
        sliderBrilho.setValue(0);
        sliderContraste.setValue(100);        
    }//GEN-LAST:event_arquivoAbrirActionPerformed

    private void sliderRotacaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderRotacaoStateChanged
        imagem_editada = transfoma.rotaciona_imagem(imagem_original, sliderRotacao.getValue());
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_sliderRotacaoStateChanged

    private void sliderEscalaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderEscalaStateChanged
        imagem_editada = transfoma.redimensiona_imagem(imagem_original, sliderEscala.getValue());
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_sliderEscalaStateChanged

    private void offsetXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_offsetXStateChanged
        imagem_editada = transfoma.move_imagem(copia_editada, (int) offsetX.getValue(), (int) offsetY.getValue());
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_offsetXStateChanged

    private void offsetYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_offsetYStateChanged
        imagem_editada = transfoma.move_imagem(copia_editada, (int) offsetX.getValue(), (int) offsetY.getValue());
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_offsetYStateChanged

    private void sliderBrilhoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBrilhoStateChanged
        brilho_contraste();
    }//GEN-LAST:event_sliderBrilhoStateChanged

    private void sliderContrasteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderContrasteStateChanged
        brilho_contraste();
    }//GEN-LAST:event_sliderContrasteStateChanged

    private void suavizacaoMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suavizacaoMediaActionPerformed
        imagem_editada = media.media(copia_editada);
        copia_editada = funcoes.copiaImagem(imagem_editada);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_suavizacaoMediaActionPerformed

    private void suavizacaoMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suavizacaoMedianaActionPerformed
        imagem_editada = mediana.mediana(imagem_editada);
        copia_editada = funcoes.copiaImagem(imagem_editada);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_suavizacaoMedianaActionPerformed

    private void suavizacaoGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suavizacaoGaussActionPerformed
        imagem_editada = gauss.gauss(imagem_editada);
        copia_editada = funcoes.copiaImagem(imagem_editada);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_suavizacaoGaussActionPerformed

    private void espelharHorizontalmenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espelharHorizontalmenteActionPerformed
        imagem_editada = transfoma.espelha_horizontal(imagem_original);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_espelharHorizontalmenteActionPerformed

    private void espelharVerticalmenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espelharVerticalmenteActionPerformed
        imagem_editada = transfoma.espelha_vertical(imagem_original);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_espelharVerticalmenteActionPerformed

    private void cinzaConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinzaConverterActionPerformed
        imagem_editada = cinza.converter(imagem_original);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
        calculos();
    }//GEN-LAST:event_cinzaConverterActionPerformed

    private void cinzaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinzaDadosActionPerformed
        gDados.setVisible(true);                
    }//GEN-LAST:event_cinzaDadosActionPerformed

    private void thresholdSobelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdSobelActionPerformed
        imagem_editada = sobel.sobel(copia_editada);
        copia_editada = funcoes.copiaImagem(imagem_editada);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_thresholdSobelActionPerformed

    private void thresholdLimiarizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdLimiarizacaoActionPerformed
        limiarizacao limiariza = new limiarizacao();
        
        imagem_editada = limiariza.limiarizacao(copia_editada);
        copia_editada = funcoes.copiaImagem(imagem_editada);
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
    }//GEN-LAST:event_thresholdLimiarizacaoActionPerformed
    
    private void brilho_contraste(){
        float valorContraste = sliderContraste.getValue();
        valorContraste = valorContraste / 100;
        
        imagem_editada = brilhoContraste.brilhoContraste(copia_editada, valorContraste, sliderBrilho.getValue());
        labelImgEditada.setIcon(new ImageIcon(imagem_editada.getScaledInstance(550, 394, Image.SCALE_DEFAULT)));
        
        labelValorBrilho.setText(Integer.toString(sliderBrilho.getValue()));
        labelValorContraste.setText(Float.toString(valorContraste));
    }
    
    private void calculos(){
        //Cálculos
        gDados.alteraDados(cinza.getModa(), cinza.getMedia(), cinza.getMediana(), cinza.getVariancia());
        cinza.criaGraficoHistograma();
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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem arquivoAbrir;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem cinzaConverter;
    private javax.swing.JMenuItem cinzaDados;
    private javax.swing.JMenuItem espelharHorizontalmente;
    private javax.swing.JMenuItem espelharVerticalmente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelImgEditada;
    private javax.swing.JLabel labelImgOriginal;
    private javax.swing.JLabel labelOffSetX;
    private javax.swing.JLabel labelOffSetY;
    private javax.swing.JLabel labelRotacao;
    private javax.swing.JLabel labelValorBrilho;
    private javax.swing.JLabel labelValorContraste;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuEscalaCinza;
    private javax.swing.JMenu menuEspelhar;
    private javax.swing.JMenu menuSuavizacao;
    private javax.swing.JMenu menuThreshold;
    private javax.swing.JSpinner offsetX;
    private javax.swing.JSpinner offsetY;
    private javax.swing.JSlider sliderBrilho;
    private javax.swing.JSlider sliderContraste;
    private javax.swing.JSlider sliderEscala;
    private javax.swing.JSlider sliderRotacao;
    private javax.swing.JMenuItem suavizacaoGauss;
    private javax.swing.JMenuItem suavizacaoMedia;
    private javax.swing.JMenuItem suavizacaoMediana;
    private javax.swing.JMenuItem thresholdLimiarizacao;
    private javax.swing.JMenuItem thresholdSobel;
    private javax.swing.JLabel txtImagemEditada;
    private javax.swing.JLabel txtImagemOriginal;
    // End of variables declaration//GEN-END:variables
}
