package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.ShareAction;

import java.util.List;

public interface IShareActionService {
    void insert(ShareAction shareAction);
    List<ShareAction> list();
    ShareAction listId(int id);
    void delete(int id);
}