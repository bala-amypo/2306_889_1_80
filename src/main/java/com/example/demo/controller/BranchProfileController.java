@RestController
@RequestMapping("/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BranchProfile create(@RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    @GetMapping
    public List<BranchProfile> getAll() {
        return service.getAllBranches();
    }

    @GetMapping("/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return service.getBranchById(id);
    }

    @PutMapping("/{id}/status")
    public BranchProfile updateStatus(@PathVariable Long id,
                                      @RequestParam boolean active) {
        return service.updateBranchStatus(id, active);
    }
}
