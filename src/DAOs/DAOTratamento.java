package DAOs;


import Entidades.Tratamento;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOTratamento extends DAOGenerico<Tratamento> {

    public DAOTratamento() {
        super(Tratamento.class);
    }

    public int autoIdTratamento() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTratamento) FROM Tratamento e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Tratamento> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Tratamento e WHERE e.nomeTratamento LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Tratamento> listById(int id) {
        return em.createQuery("SELECT e FROM Tratamento e WHERE e.idTratamento = :id").setParameter("id", id).getResultList();
    }

    public List<Tratamento> listInOrderNome() {
        return em.createQuery("SELECT e FROM Tratamento e ORDER BY e.nomeTratamento").getResultList();
    }

    public List<Tratamento> listInOrderId() {
        return em.createQuery("SELECT e FROM Tratamento e ORDER BY e.idTratamento").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Tratamento> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTratamento() + "-" + lf.get(i).getNomeTratamento());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOTratamento daoTratamento = new DAOTratamento();
        List<Tratamento> listaTratamento = daoTratamento.list();
        for (Tratamento tratamento : listaTratamento) {
            System.out.println(tratamento.getIdTratamento() + "-" + tratamento.getNomeTratamento());
        }
    }}
