package service;

import dao.OtoDAO;
import dao.OtoDAOImpl;
import model.Oto;

import java.util.List;

public class OtoServiceIpml implements OtoService{
    private final OtoDAO otoDAO = new OtoDAOImpl();
    @Override
    public List<Oto> getAll() {
        return null;
    }

    @Override
    public Oto create(Oto oto) {
        return null;
    }

    @Override
    public Oto update(Oto oto, int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        Oto oto = otoDAO.getById(id);
        if (oto != null){
            oto.setDelete(true);
            otoDAO.update(oto,id);
        }
    }
}
