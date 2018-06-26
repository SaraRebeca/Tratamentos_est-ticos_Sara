package GUIs;
import DAOs.DAOTratamento;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;
import DAOs.*;
public class GUITratamento extends JFrame {
ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
JButton btnCreate = new JButton(iconeCreate);
JButton btnRetrieve = new JButton(iconeRetrieve);
JButton btnUpdate = new JButton(iconeUpdate);
JButton btnDelete = new JButton(iconeDelete);
JButton btnSave = new JButton(iconeSave);
JButton btnCancel = new JButton(iconeCancel);
JButton btnList = new JButton(iconeListar);
private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
private JPanel pnCentro = new JPanel(new GridLayout(2, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbIdTratamento = new JLabel("IdTratamento");
private JTextField tfIdTratamento = new JTextField(10);
private JLabel lbNomeTratamento = new JLabel("NomeTratamento");
private JTextField tfNomeTratamento = new JTextField(10);
private JPanel pnTipoTratamentoIdTipoTratamento = new JPanel(new GridLayout(1, 2));
private JLabel lbTipoTratamentoIdTipoTratamento = new JLabel("TipoTratamentoIdTipoTratamento");
private JTextField tfTipoTratamentoIdTipoTratamento = new JTextField();
private JButton btTipoTratamentoIdTipoTratamento = new JButton("Procurar");
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOTratamento daoTratamento = new DAOTratamento();
Tratamento tratamento;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUITratamento() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Tratamento");
Container cp = getContentPane();cp = getContentPane();
btnCreate.setToolTipText("Inserir novo registro");
btnRetrieve.setToolTipText("Pesquisar por chave");
btnUpdate.setToolTipText("Alterar");
btnDelete.setToolTipText("Excluir");
btnList.setToolTipText("Listar todos");
btnSave.setToolTipText("Salvar");
btnCancel.setToolTipText("Cancelar");cp.setLayout(new BorderLayout());
cp.add(pnNorte, BorderLayout.NORTH);
cp.add(pnCentro, BorderLayout.CENTER);
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbIdTratamento);
pnNorte.add(tfIdTratamento);
pnNorte.add(btnRetrieve);
pnNorte.add(btnCreate);
pnNorte.add(btnUpdate);
pnNorte.add(btnDelete);
pnNorte.add(btnSave);
pnNorte.add(btnList);
btnCancel.setVisible(false);
btnDelete.setVisible(false);
btnCreate.setVisible(false);
btnSave.setVisible(false);
btnUpdate.setVisible(false);
pnCentro.add(lbNomeTratamento);
pnCentro.add(tfNomeTratamento);
pnCentro.add(lbTipoTratamentoIdTipoTratamento);
pnCentro.add(pnTipoTratamentoIdTipoTratamento);
pnTipoTratamentoIdTipoTratamento.add(tfTipoTratamentoIdTipoTratamento);
pnTipoTratamentoIdTipoTratamento.add(btTipoTratamentoIdTipoTratamento);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfNomeTratamento.setEditable(false);
tfTipoTratamentoIdTipoTratamento.setEditable(false);
btTipoTratamentoIdTipoTratamento.setEnabled(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfIdTratamento.setBackground(Color.white);
jTextArea.setText("");
tratamento = new Tratamento();
int identificador = Integer.valueOf(tfIdTratamento.getText());
tratamento.setIdTratamento(identificador);
tratamento = daoTratamento.obter(tratamento.getIdTratamento());
if (tratamento == null) {
pnNorte.setBackground(Color.red);
tfNomeTratamento.setText("");
tfTipoTratamentoIdTipoTratamento.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
tfNomeTratamento.setText(tratamento.getNomeTratamento());
String dao1 = String.valueOf(tratamento.getTipoTratamentoIdTipoTratamento());
String [] aux1 = dao1.split("-");
tfTipoTratamentoIdTipoTratamento.setText(aux1[0]);
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfIdTratamento.setEditable(false);
tfNomeTratamento.setEditable(false);
btTipoTratamentoIdTipoTratamento.setEnabled(false);
tfIdTratamento.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfIdTratamento.requestFocus();
tfIdTratamento.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfIdTratamento.setEditable(false);
tfNomeTratamento.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
tratamento = new Tratamento();
tfNomeTratamento.setEditable(true);
btTipoTratamentoIdTipoTratamento.setEnabled(true);
tfIdTratamento.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
tratamento = new Tratamento();
tratamento.setIdTratamento(Integer.valueOf(tfIdTratamento.getText()));
tratamento.setNomeTratamento(tfNomeTratamento.getText());
String [] aux0 = tfTipoTratamentoIdTipoTratamento.getText().split("-");
DAOTipoTratamento daoTipoTratamento = new DAOTipoTratamento();
TipoTratamento d0 = daoTipoTratamento.obter(Integer.valueOf(aux0[0]));
tratamento.setTipoTratamentoIdTipoTratamento(d0);
if (qualAcao.equals("incluir")) {
daoTratamento.inserir(tratamento);
} else {
daoTratamento.atualizar(tratamento);
}
tfIdTratamento.setEditable(true);
tfIdTratamento.requestFocus();
tfNomeTratamento.setText("");
tfTipoTratamentoIdTipoTratamento.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
tfNomeTratamento.setEditable(false);
btTipoTratamentoIdTipoTratamento.setEnabled(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfIdTratamento.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfNomeTratamento.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
tfNomeTratamento.setEditable(true);
btTipoTratamentoIdTipoTratamento.setEnabled(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + tratamento.getIdTratamento() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoTratamento.remover(tratamento);
tfIdTratamento.requestFocus();
tfNomeTratamento.setText("");
tfTipoTratamentoIdTipoTratamento.setText("");
tfIdTratamento.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemTratamento guiListagem = new GUIListagemTratamento(daoTratamento.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});
DAOTipoTratamento daoTipoTratamento = new DAOTipoTratamento();
btTipoTratamentoIdTipoTratamento.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoTipoTratamento.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfTipoTratamentoIdTipoTratamento.setText(aux[0]);
} else {
jTextArea.setText("Nenhum dado adicionado!");
}
}
}
});
tfIdTratamento.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoTratamento.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfIdTratamento.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfIdTratamento.requestFocus();tfIdTratamento.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUITratamento guiTratamento = new GUITratamento();
}
}
