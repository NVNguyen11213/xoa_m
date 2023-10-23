package service;

import model.Oto;

import java.util.List;

public interface OtoService {
    List<Oto> getAll();
    Oto create(Oto oto);
    Oto update(Oto oto, int id);
    void delete(int id);
}
