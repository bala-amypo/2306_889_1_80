public class UserAccount{
    @ID
    @Column(unique=true)
    private String FullName;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;
}