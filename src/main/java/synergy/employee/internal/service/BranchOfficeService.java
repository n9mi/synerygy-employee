package synergy.employee.internal.service;

import synergy.employee.internal.entity.BranchOffice;
import synergy.employee.internal.repository.BranchOfficeRepository;

public class BranchOfficeService {
    private final BranchOfficeRepository branchOfficeRepository;

    public BranchOfficeService(BranchOfficeRepository branchOfficeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
    }

    public BranchOffice get(String id) {
        return this.branchOfficeRepository.get(id);
    }

    public void create(BranchOffice bo) throws RuntimeException {
        if (this.branchOfficeRepository.isExists(bo.getId())) {
            throw new RuntimeException("branch office already exists");
        }

        this.branchOfficeRepository.create(bo);
    }

    public void update(BranchOffice bo) throws RuntimeException {
        if (!this.branchOfficeRepository.isExists(bo.getId())) {
            throw new RuntimeException("branch office does not exist");
        }

        this.branchOfficeRepository.create(bo);
    }

    public void delete(BranchOffice bo) throws RuntimeException {
        if (!this.branchOfficeRepository.isExists(bo.getId())) {
            throw new RuntimeException("branch office does not exist");
        }

        this.branchOfficeRepository.delete(bo);
    }


}
