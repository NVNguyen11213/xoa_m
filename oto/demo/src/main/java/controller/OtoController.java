package controller;

import dao.OtoDAO;
import dao.OtoDAOImpl;
import model.Oto;
import service.OtoService;
import service.OtoServiceIpml;

import java.util.List;

public class OtoController {
    private OtoDAO otoDAO = new OtoDAOImpl();
    private OtoService otoService = new OtoServiceIpml();
    public void create(Oto oto){
        otoDAO.create(oto);
    }
    public void update(Oto oto, int id){
        otoDAO.update(oto,id);
    }
    public void delete(int id){
        otoDAO.deleteOto(id);
    }
    public List<Oto> getAll(){
        List<Oto> otoList = otoDAO.getAll();
        if (otoList.isEmpty()){
            System.out.println("not fould in DB");
        }else {
            System.out.println("list oto in DB");
            for (Oto oto: otoList){
                System.out.println(oto);
            }
        }
        return otoList;
    }
}
