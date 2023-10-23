package dao;

import model.Oto;

import java.util.List;

public interface OtoDAO {
    List<Oto> getAll();
    void create(Oto oto);
    void update(Oto oto, int id);
    void deleteOto(int id);
    Oto getById(int id);
}
