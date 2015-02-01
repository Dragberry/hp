package by.happytime.repository;

import java.util.List;

import by.happytime.baserepo.BaseRepo;
import by.happytime.domain.DashboardItem;

public interface DashboardItemRepo extends BaseRepo<DashboardItem> {
    
    List<DashboardItem> findByEnabled(Boolean enabled);

}
