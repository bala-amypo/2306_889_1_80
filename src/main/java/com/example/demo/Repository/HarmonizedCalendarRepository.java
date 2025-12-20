public interface HarmonizedCalendarRepository extends JpaRepository<HarmonizedCalendar, Long> {
    List<HarmonizedCalendar>
    findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(LocalDate d1, LocalDate d2);
}
