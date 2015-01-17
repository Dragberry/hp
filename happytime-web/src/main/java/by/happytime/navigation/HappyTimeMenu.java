package by.happytime.navigation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import by.happytime.util.Translation;

@ManagedBean(name = "menuBean")
@SessionScoped
public class HappyTimeMenu implements Serializable {

    private static final long serialVersionUID = -6394021934348528104L;
    
    @ManagedProperty("#{translation}")
    private Translation translation;
    
    private List<MenuUnit> model = null;
    
    public void initialize() {
        model = new ArrayList<MenuUnit>();
        MenuUnit menuIndex = new MenuUnit();
        menuIndex.setId("menuIndex");
        menuIndex.setLink("/index");
        menuIndex.setTitle(translation.translate("HTmainPage"));
        model.add(menuIndex);
        
        MenuUnit menuShop = new MenuUnit();
        menuShop.setId("menuShop");
        menuShop.setTitle(translation.translate("HTshop"));
        model.add(menuShop);
        
        MenuUnit menuBalloons = new MenuUnit();
        menuBalloons.setId("menubBalloons");
        menuBalloons.setLink("/faces/shop/balloons");
        menuBalloons.setTitle(translation.translate("HTballoons"));
        menuShop.add(menuBalloons);
        
        MenuUnit menuAccessories = new MenuUnit();
        menuAccessories.setId("menuAccessories");
        menuAccessories.setLink("/faces/shop/accessories");
        menuAccessories.setTitle(translation.translate("HTaccessories"));
        menuShop.add(menuAccessories);
        
        MenuUnit menuOriginalGifts = new MenuUnit();
        menuOriginalGifts.setId("menuOriginalGifts");
        menuOriginalGifts.setLink("/faces/shop/originalGifts");
        menuOriginalGifts.setTitle(translation.translate("HToriginalGifts"));
        menuShop.add(menuOriginalGifts);
        
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

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

}
