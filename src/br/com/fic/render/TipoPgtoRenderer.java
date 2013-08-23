package br.com.fic.render;

import br.com.fic.bean.Produto;
import br.com.fic.bean.Unidade;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class TipoPgtoRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Produto) {
            Produto p = (Produto) value;
            setText(p.getDescricaoProduto());
        }
        return this;
    }
}