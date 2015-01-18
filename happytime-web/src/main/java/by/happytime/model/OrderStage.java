package by.happytime.model;

public enum OrderStage {
    FORMATION("HTorderFormation", "orderFormation.xhtml"), 
    INFORMATION("HTorderInformation", "orderInformation.xhtml"), 
    OVERVIEW("HTorderOverview", "orderOverview.xhtml"), 
    SUCCESS("HTorderSuccess", "orderSuccess.xhtml");
    
    private OrderStage(String stageKey, String stagePath) {
        this.stagePath = stagePath; 
        this.stageKey = stageKey;
    }
    
    private String stageKey;
    
    private String stagePath;
    
    public OrderStage next() {
        switch (this) {
            case FORMATION:
                return INFORMATION;
            case INFORMATION:
                return OVERVIEW;
            case OVERVIEW:
                return SUCCESS;
            case SUCCESS:
                return null;
            default:
                return null;
        }
    }
    
    public boolean hasNext() {
        return this.next() != null;
    }
    
    public OrderStage previous() {
        switch(this) {
            case FORMATION:
                return null;
            case INFORMATION:
                return FORMATION;
            case OVERVIEW:
                return INFORMATION;
            case SUCCESS:
                return null;
            default:
                return null;
        }
    }
    
    public boolean hasPrevious() {
        return this.previous() != null;
    }
    
    public boolean isSuccessStage() {
        return this == SUCCESS;
    }
    
    public String getPath() {
        return stagePath;
    }
    
    public String getKey() {
        return stageKey;
    }
}