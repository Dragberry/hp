package by.happytime.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.DashboardItem;
import by.happytime.repository.DashboardItemRepo;

@ManagedBean(name = "dashboard")
@SessionScoped
public class Dashboard implements Serializable {

    private static final long serialVersionUID = -676004161147259309L;
    
    @ManagedProperty("#{dashboardItemRepo}")
    private DashboardItemRepo dashboardItemRepo;
    
    private List<DashboardItem> dashboardItems = null;

    public List<DashboardItem> getDashboardItems() {
        if (dashboardItems == null) {
            dashboardItems = initializeDashboard();
        }
        return dashboardItems;
    }

    private List<DashboardItem> initializeDashboard() {
        return dashboardItemRepo.findByEnabled(true);
    }

    public void setDashboardItems(List<DashboardItem> dashboardItems) {
        this.dashboardItems = dashboardItems;
    }

    public DashboardItemRepo getDashboardItemRepo() {
        return dashboardItemRepo;
    }

    public void setDashboardItemRepo(DashboardItemRepo dashboardItemRepo) {
        this.dashboardItemRepo = dashboardItemRepo;
    }
    
}
