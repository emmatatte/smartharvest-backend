package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.repositories.IUsersRepository;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.entities.Parcel;
import pe.edu.upc.smartharvest.repositories.ICropRepository;
import pe.edu.upc.smartharvest.repositories.IParcelRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    private IUsersRepository repo;

    @Autowired
    private ICropRepository cR;

    @Autowired
    private IParcelRepository pR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IShareActionRepository shareActionRepository;

    public void registerSimple(SimpleRegisterDTO dto) {
        Users user = new Users();
        user.setUsername(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);
        user.setEmail(dto.getEmail());
        repo.save(user);

        Crop crop = new Crop();
        crop.setTypeCrop(dto.getCropType());
        crop.setParcel(null);
        crop.setName(dto.getCropName());
        cR.save(crop);

        Parcel parcel = new Parcel();
        parcel.setName(dto.getParcelName());
        parcel.setLocation("DEFAULT LOCATION");
        parcel.setSizem2(100);
        parcel.setGroundType("Tierra");
        parcel.setRegistrationDate(LocalDate.now());
        parcel.setUsers(user);
        pR.save(parcel);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, roles);

        return ud;
    }

    public Users updateUserPreferences(Long userId, String language, String theme) {
        Users user = repo.findById(userId).orElse(null);
        if (user != null) {
            user.setPreferredLanguage(language);
            user.setDisplayTheme(theme);
            return repo.save(user);
        }
        return null;
    }

    public Users updateFavoriteSections(Long userId, List<String> favoriteSections) {
        Users user = repo.findById(userId).orElse(null);
        if (user != null) {
            user.setFavoriteSections(favoriteSections);
            return repo.save(user);
        }
        return null;
    }

    public void logShareAction(Long userId, String sharedContent, String targetPlatform) {
        Users user = repo.findById(userId).orElse(null);
        if (user != null) {
            ShareAction shareAction = new ShareAction();
            shareAction.setUser(user);
            shareAction.setSharedContent(sharedContent);
            shareAction.setTargetPlatform(targetPlatform);
            shareAction.setShareDate(LocalDateTime.now());
            shareActionRepository.save(shareAction);
            logger.info("User {} shared content '{}' on {}", userId, sharedContent, targetPlatform);
        } else {
            logger.warn("Could not log share action for user with ID: {}", userId);
        }
    }
}