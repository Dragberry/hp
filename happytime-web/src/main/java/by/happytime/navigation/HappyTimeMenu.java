package by.happytime.navigation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import by.happytime.domain.Category;
import by.happytime.domain.Subcategory;
import by.happytime.repository.CategoryRepo;
import by.happytime.repository.SubcategoryRepo;
import by.happytime.util.Translation;

@ManagedBean(name = "menuBean")
@SessionScoped
public class HappyTimeMenu implements Serializable {

    private static final long serialVersionUID = -6394021934348528104L;
    
    private static final Map<String, MenuUnit> CATEGORY_MENU = new HashMap<String, MenuUnit>();
    static {
    	CATEGORY_MENU.put("balloons", null);
    	CATEGORY_MENU.put("accessories", null);
    }
    
    @ManagedProperty("#{translation}")
    private Translation translation;
    @ManagedProperty("#{categoryRepo}")
    private CategoryRepo categoryRepo;
    @ManagedProperty("#{subcategoryRepo}")
    private SubcategoryRepo subcategoryRepo;
    
    private List<MenuUnit> model = null;
    
    private MenuUnit catalogMenu = null;
    
    public void initializeSubMenu(String categoryCode) {
    	CATEGORY_MENU.put(categoryCode, new MenuUnit());
    	Category category = categoryRepo.findByCode(categoryCode);
    	CATEGORY_MENU.get(categoryCode).setTitle(category.getTitle());
    	
    	MenuUnit unitAll = new MenuUnit();
        unitAll.setTitle(translation.translate("HTall"));
        unitAll.setId("all");
        unitAll.setLink("/faces/shop/productList?category=" + category.getCode());
        CATEGORY_MENU.get(categoryCode).add(unitAll);
    	
    	List<Subcategory> subcategories = subcategoryRepo.findByCategory(category);
    	for (Subcategory subcategory : subcategories) {
    		MenuUnit unit = new MenuUnit();
    		unit.setTitle(subcategory.getTitle());
    		unit.setId(subcategory.getCode());
    		unit.setLink("/faces/shop/productList?category=" + category.getCode() + "&subcategory=" + subcategory.getCode());
    		CATEGORY_MENU.get(categoryCode).add(unit);
    	}
    }
    
    private MenuUnit initializeShopMenu() {
        MenuUnit shopUnit = new MenuUnit();
        shopUnit.setId("menuShop");
        shopUnit.setTitle(translation.translate("HTshop"));
        List<Category> categoryList = categoryRepo.findAll();
        for (Category category : categoryList) {
            MenuUnit unit = new MenuUnit();
            unit.setTitle(category.getTitle());
            unit.setId(category.getCode());
            unit.setLink("/faces/shop/productList?category=" + category.getCode());
            shopUnit.add(unit);
        }
        return shopUnit;
    }
    
    public void initializeCatalogMenu() {
        catalogMenu = new MenuUnit();
        catalogMenu.setId("menu-catalog");
        catalogMenu.setTitle(translation.translate("HTshop"));
        List<Category> categoryList = categoryRepo.findAll();
        for (Category category : categoryList) {
            MenuUnit unit = new MenuUnit();
            unit.setTitle(category.getTitle());
            unit.setId(category.getCode() + "-submenu");
            catalogMenu.add(unit);
            
            MenuUnit unitAll = new MenuUnit();
            unitAll.setTitle(translation.translate("HTall"));
            unitAll.setId(category.getCode() + "-all");
            unitAll.setLink("/faces/shop/productList?category=" + category.getCode());
            unit.add(unitAll);
            
            List<Subcategory> subcategories = subcategoryRepo.findByCategory(category);
            for (Subcategory subcategory : subcategories) {
                MenuUnit subUnit = new MenuUnit();
                subUnit.setTitle(subcategory.getTitle());
                subUnit.setId(subcategory.getCode());
                subUnit.setLink("/faces/shop/productList?category=" + category.getCode() + "&subcategory=" + subcategory.getCode());
                unit.add(subUnit);
            }
        }
    }
    
    public void initialize() {
        model = new ArrayList<MenuUnit>();
        MenuUnit menuIndex = new MenuUnit();
        menuIndex.setId("menuIndex");
        menuIndex.setLink("/index");
        menuIndex.setTitle(translation.translate("HTmainPage"));
        model.add(menuIndex);
        
        MenuUnit menuShop = initializeShopMenu();
        model.add(menuShop);
        
        MenuUnit menuHolidaysOrganization = new MenuUnit();
        menuHolidaysOrganization.setId("menuHolidaysOrganization");
        menuHolidaysOrganization.setTitle(translation.translate("HTholidaysOrganization"));
        model.add(menuHolidaysOrganization);
        
        MenuUnit menuSanta = new MenuUnit();
        menuSanta.setId("menuSanta");
        menuSanta.setLink("/faces/actions/santaClaus");
        menuSanta.setTitle(translation.translate("HTsantaClaus"));
        menuHolidaysOrganization.add(menuSanta);
        
        MenuUnit menuOriginalCongratulation = new MenuUnit();
        menuOriginalCongratulation.setId("menuOriginalCongratulation");
        menuOriginalCongratulation.setLink("/faces/actions/originalCongratulation");
        menuOriginalCongratulation.setTitle(translation.translate("HToriginalCongratulation"));
        menuHolidaysOrganization.add(menuOriginalCongratulation);
        
        MenuUnit menuAnimatorAndToastmasterAndSoundman = new MenuUnit();
        menuAnimatorAndToastmasterAndSoundman.setId("menuAnimatorAndToastmasterAndSoundman");
        menuAnimatorAndToastmasterAndSoundman.setLink("/faces/actions/animatorAndToastMaster");
        menuAnimatorAndToastmasterAndSoundman.setTitle(translation.translate("HTanimatorAndToastmasterAndSoundman"));
        menuHolidaysOrganization.add(menuAnimatorAndToastmasterAndSoundman);
        
        MenuUnit menuOrderAndDelivery = new MenuUnit();
        menuOrderAndDelivery.setId("menuOrderAndDelivery");
        menuOrderAndDelivery.setLink("/faces/orderAndDelivery");
        menuOrderAndDelivery.setTitle(translation.translate("HTorderAndDelivery"));
        menuOrderAndDelivery.setPosition(MenuUnit.LEFT_POSITION_CLASS);
        model.add(menuOrderAndDelivery);
        
        MenuUnit menuAboutUs = new MenuUnit();
        menuAboutUs.setId("menuAboutUs");
        menuAboutUs.setLink("/faces/aboutUs");
        menuAboutUs.setTitle(translation.translate("HTaboutUs"));
        menuAboutUs.setPosition(MenuUnit.LEFT_POSITION_CLASS);
        model.add(menuAboutUs);
        
        MenuUnit menuPromotions = new MenuUnit();
        menuPromotions.setId("menuPromotions");
        menuPromotions.setTitle(translation.translate("HTpromotions"));
        menuPromotions.setPosition(MenuUnit.LEFT_POSITION_CLASS);
        model.add(menuPromotions);
        
        MenuUnit menuPromotionActions = new MenuUnit();
        menuPromotionActions.setId("menuPromotionActions");
        menuPromotionActions.setLink("/faces/promotions/actions");
        menuPromotionActions.setTitle(translation.translate("HTactions"));
        menuPromotions.add(menuPromotionActions);
        
        MenuUnit menuDiscountCards = new MenuUnit();
        menuDiscountCards.setId("menuDiscountCards");
        menuDiscountCards.setLink("/faces/promotions/discountCards");
        menuDiscountCards.setTitle(translation.translate("HTdiscountCards"));
        menuPromotions.add(menuDiscountCards);
        
        MenuUnit menuGiftCertificates = new MenuUnit();
        menuGiftCertificates.setId("menuGiftCertificates");
        menuGiftCertificates.setLink("/faces/promotions/giftCertificates");
        menuGiftCertificates.setTitle(translation.translate("HTgiftCertificates"));
        menuPromotions.add(menuGiftCertificates);
        
    }
    
    public List<MenuUnit> getModel() {
        if (model == null) {
            initialize();
        }
        return model;
    }
    
    public MenuUnit getCatalogMenu() {
        if (catalogMenu == null) {
            initializeCatalogMenu();
        }
        return catalogMenu;
    }
    
    public MenuUnit getShopMenu(String categoryCode) {
        if (CATEGORY_MENU.get(categoryCode) == null) {
            initializeSubMenu(categoryCode);
        }
        return CATEGORY_MENU.get(categoryCode);
    }
    
    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

	public SubcategoryRepo getSubcategoryRepo() {
		return subcategoryRepo;
	}

	public void setSubcategoryRepo(SubcategoryRepo subcategoryRepo) {
		this.subcategoryRepo = subcategoryRepo;
	}

	public CategoryRepo getCategoryRepo() {
		return categoryRepo;
	}

	public void setCategoryRepo(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

}
