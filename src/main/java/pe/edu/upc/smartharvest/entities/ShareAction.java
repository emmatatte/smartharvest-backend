package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "share_actions")
public class ShareAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "shared_content", nullable = false, length = 255)
    private String sharedContent;

    @Column(name = "target_platform", nullable = false, length = 50)
    private String targetPlatform;

    @Column(name = "share_date", nullable = false)
    private LocalDateTime shareDate;

    public ShareAction() {
    }

    public ShareAction(Users user, String sharedContent, String targetPlatform, LocalDateTime shareDate) {
        this.user = user;
        this.sharedContent = sharedContent;
        this.targetPlatform = targetPlatform;
        this.shareDate = shareDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getSharedContent() {
        return sharedContent;
    }

    public void setSharedContent(String sharedContent) {
        this.sharedContent = sharedContent;
    }

    public String getTargetPlatform() {
        return targetPlatform;
    }

    public void setTargetPlatform(String targetPlatform) {
        this.targetPlatform = targetPlatform;
    }

    public LocalDateTime getShareDate() {
        return shareDate;
    }

    public void setShareDate(LocalDateTime shareDate) {
        this.shareDate = shareDate;
    }
}