package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.ShareAction;
import pe.edu.upc.smartharvest.repositories.IShareActionRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IShareActionService;

import java.util.List;

@Service
public class ShareActionServiceImplement implements IShareActionService {

    @Autowired
    private IShareActionRepository shareActionRepository;

    @Override
    public void insert(ShareAction shareAction) {
        shareActionRepository.save(shareAction);
    }

    @Override
    public List<ShareAction> list() {
        return shareActionRepository.findAll();
    }

    @Override
    public ShareAction listId(int id) {
        return shareActionRepository.findById((long) id).orElse(new ShareAction());
    }

    @Override
    public void delete(int id) {
        shareActionRepository.deleteById((long) id);
    }
}
