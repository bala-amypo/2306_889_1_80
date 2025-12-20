public interface BranchProfileRepository extends JpaRepository<BranchProfile, Long> {
    Optional<BranchProfile> findByBranchCode(String branchCode);
}
