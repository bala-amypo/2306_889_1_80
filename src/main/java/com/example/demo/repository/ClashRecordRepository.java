public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {
    List<ClashRecord> findByEventAIdOrEventBId(Long a, Long b);
    List<ClashRecord> findByResolvedFalse();
}
