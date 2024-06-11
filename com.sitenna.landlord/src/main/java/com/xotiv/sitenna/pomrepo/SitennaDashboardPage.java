package com.xotiv.sitenna.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitennaDashboardPage {
	WebDriver driver;
	public SitennaDashboardPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);	
		}
	
	@FindBy(xpath = "//button[@feature = 'Favorites']")
	private WebElement favoriteIcon;
	public WebElement getfavoriteIcon() {
		return favoriteIcon;
	}
	
	@FindBy(xpath = "//div[text() = 'Favorites']")
	private WebElement favoriteModal;
	public WebElement getfavoriteModal() {
		return favoriteModal;
	}
	
	@FindBy(id = "inputsearch")
	private WebElement searchBar;
	public WebElement getsearchBar() {
		return searchBar;
	}
	
	@FindBy(xpath = "//div[@class = 'itemcounter']")
	private WebElement itemCount;
	public WebElement getitemCount() {
	return itemCount;
	}
	
	@FindBy(xpath = "//img[@class = 'mb-4']")
	private WebElement yellowStar;
	public WebElement getyellowStar() {
		return yellowStar;
	}
	
	@FindBy(xpath = "//p[text() = 'You currently have no favorites sites.']")
	private WebElement youCurrentlyHaveNoFavoritesSitesMSG;
	public WebElement getyouCurrentlyHaveNoFavoritesSitesMSG() {
		return youCurrentlyHaveNoFavoritesSitesMSG;
	}
	
//	@FindBy(xpath = "//img[@src = 'https://sitenna-public-downloads.s3.eu-west-2.amazonaws.com/sitenna-asset/images/icon-close-light-blue.svg']")
//	private WebElement closeFavoriteIcon;
//	public WebElement getcloseFavoriteIcon() {
//		return closeFavoriteIcon;
//	}
	
	@FindBy(xpath = "//div[@class='mapboxgl-ctrl-geocoder mapboxgl-ctrl mapboxgl-ctrl-geocoder--collapsed']")
	private WebElement searchIcon;
	public WebElement getsearchIcon() {
		return searchIcon;
	}
	
	@FindBy(xpath = "//button[@aria-label = 'Clear']")
	private WebElement searchIconFieldCrossIcon;
	public WebElement getsearchIconFieldCrossIcon() {
		return searchIconFieldCrossIcon;
	}
	@FindBy(xpath = "//input[@aria-label = 'Search']")
	private WebElement searchIconTextField;
	public WebElement getsearchIconTextField() {
		return searchIconTextField;
	}
	
	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement searchTextField;
	public WebElement getsearchTextField() {
		return searchTextField;
	}
	
	@FindBy(tagName = "ellipse")
	private WebElement map;
	public WebElement getmap() {
		return map;
	}
	
	@FindBy(xpath = "//img[@src = 'https://sitenna-public-downloads.s3.eu-west-2.amazonaws.com/sitenna-asset/images/icon-close-light-blue.svg']")
	private WebElement crosslink;
	public WebElement getcrosslink() {
		return crosslink;
	}
	
	@FindBy(xpath = "//img[@alt = 'Save as task']")
	private WebElement favoriteIconSiteModal;
	public WebElement getfavoriteIconSiteModal() {
		return favoriteIconSiteModal;
	}
	
	@FindBy(xpath = "//img[contains(@src, 'sitenna-asset/images/icon-close-light-blue.svg')]")
	private WebElement closeIcon;
	public WebElement getcloseSiteModal() {
		return closeIcon;
	}
	
	@FindBy(xpath = "//h2[@class = 'font-20 mb-0']")
	private WebElement siteModal;
	public WebElement getsiteModal() {
		return siteModal;
	}
	@FindBy(xpath = "//div[text() = 'demo site 01']")
	private WebElement selectedFavoriteSite;
	public WebElement getselectedFavoriteSite() {
		return selectedFavoriteSite;
	}
	
	@FindBy(xpath = "//h2[text() = 'demo site 01']")
	private WebElement markedFavoriteSiteModal;
	public WebElement getmarkedFavoriteSiteModal() {
		return markedFavoriteSiteModal;
	}
	
	@FindBy(xpath = "//img[@alt = 'Task saved']")
	private WebElement starIconInFavoriteSite;
	public WebElement getstarIconInFavoriteSite() {
		return starIconInFavoriteSite;
	}
	
	@FindBy(id = "sites_menu_item")    
	private WebElement manageSiteFirstElement;
	public WebElement getmanageSiteFirstElement() {
		return manageSiteFirstElement;
	}
	
	@FindBy(xpath = "//span[text() = ' Manage Sites ']")
	private WebElement manageSiteSecondElement;
	public WebElement getmanageSiteSecondElement() {
		return manageSiteSecondElement;
	}
	
	@FindBy(id = "inputsearch")
	private WebElement searchTextFieldManageSite;
	public WebElement getsearchTextFieldManageSite() {
        return searchTextFieldManageSite;
	}
	@FindBy(xpath = "//span[text() = 'demo site 01']")
	private WebElement demoSiteName;
	public WebElement getdemoSiteName() {
		return demoSiteName;
	}
	
	@FindBy(id = "dashboard_menu_item")
	private WebElement dashboardIcon;
	public WebElement getdashboardIcon() {
		return dashboardIcon;
	}
	
	@FindBy(xpath = "//label[text() = 'REF: #0123N6']")
	private WebElement refID;
	public WebElement getrefID() {
		return refID;
	}
	
	@FindBy(xpath = "//div[text() = 'demo site 01']")
	private WebElement siteName_demoSite01;
	public WebElement getsiteName_demoSite01() {
		return siteName_demoSite01;
	}
	
	@FindBy(xpath = "//p[text() = 'Greenfield']")
	private WebElement siteType_Greenfield;
	public WebElement getsiteType_Greenfield() {
		return siteType_Greenfield;
	}
	
	@FindBy(xpath = "//p[text() = 'Automation_Landlord']")
	private WebElement siteOwner_Automation_Landlord;
	public WebElement getsiteOwner_Automation_Landlord() {
		return siteOwner_Automation_Landlord;
	}
	
	@FindBy(xpath = "//span[text() = '0 Sites']")
	private WebElement siteCount;
	public WebElement getsiteCount() {
		return siteCount;
	}
	
	@FindBy(xpath = "//div[text() = 'demo site 01']")
	private WebElement favoriteIconSiteName_demosite01;
	public WebElement getfavoriteIconSiteName_demosite01() {
		return favoriteIconSiteName_demosite01;
	}
	
	@FindBy(xpath = "//button[@feature = 'Filter Sites']")
	private WebElement filterIcon;
	public WebElement getfilterIcon() {
		return filterIcon;
	}
	
	@FindBy(xpath ="//img[contains(@src, '/sitenna-asset/images/icon-close-light-blue.svg')]")
	private WebElement crossIcon;
	public WebElement getcrossIcon() {
		return crossIcon;
	}
	
	@FindBy(xpath = "//label[text() = 'Site Type']")
	private WebElement siteTypeLabel;
	public WebElement getsiteTypeLabel() {
		return siteTypeLabel;
	}
	
	@FindBy(id = "Greenfield")
	private WebElement greenfieldCheckBox;
	public WebElement getgreenfieldCheckBox() {
		return greenfieldCheckBox;
	}
	
	@FindBy(xpath = "//div[text() = 'Greenfield']")
	private WebElement greenfieldSiteType;
	public WebElement getgreenfieldSiteType() {
		return greenfieldSiteType;
	}
	
	@FindBy(id = "Rooftop")
	private WebElement rooftopCheckBox;
	public WebElement getrooftopCheckBox() {
		return rooftopCheckBox;
	}
	
	@FindBy(xpath = "//div[text() = 'Rooftop']")
	private WebElement rooftopfieldSiteType;
	public WebElement getrooftopfieldSiteType() {
		return rooftopfieldSiteType;
	}
	
	@FindBy(id = "StreetAsset")
	private WebElement streetassetCheckBox;
	public WebElement getstreetassetCheckBox() {
		return streetassetCheckBox;
	}
	
	@FindBy(xpath = "//div[text() = 'Street Asset']")
	private WebElement streetassetSiteType;
	public WebElement getstreetassetSiteType() {
		return streetassetSiteType;
	}
	
	@FindBy(id ="Tower")
	private WebElement towerCheckBox;
	public WebElement gettowerCheckBox() {
		return towerCheckBox;
	}
	
	@FindBy(xpath = "//div[text() = 'Tower']")
	private WebElement towerSiteType;
	public WebElement gettowerSiteType() {
		return towerSiteType;
	}
	
	@FindBy(id = "MobileAsset")
	private WebElement mobileCheckBox;
	public WebElement getmobileCheckBox() {
		return mobileCheckBox;
	}
	
	@FindBy(xpath = "//div[text() = 'Mobile Asset']")
	private WebElement mobileSiteType;
	public WebElement getmobileSiteType() {
		return mobileSiteType;
	} 
	
	@FindBy(xpath = "//label[text() = 'Site Subtype']")
	private WebElement siteSubType;
	public WebElement getsiteSubType() {
		return siteSubType;
	}
	
	@FindBy(id = "Active")
	private WebElement activeCheckBox;
	public WebElement getactiveCheckBox() {
		return activeCheckBox;
	}
	
	@FindBy(xpath = "//div[contains(text() , 'Active')]")
	private WebElement activeSiteSubType;
	public WebElement getactiveSiteSubType() {
		return activeSiteSubType;
	}
	
	@FindBy(id = "Passive")
	private WebElement passiveCheckBox;
	public WebElement getpassiveCheckBox() {
		return passiveCheckBox;
	}
	
	@FindBy(xpath = "//div[contains(text() , 'Passive')]")
	private WebElement passiveSiteSubType;
	public WebElement getpassiveSiteSubType() {
		return passiveSiteSubType;		
	}
	
	@FindBy(id = "NewBuild")
	private WebElement newBuildCheckBox;
	public WebElement getnewBuildCheckBox() {
		return newBuildCheckBox;
	}
	
	@FindBy(xpath = "//div[contains(text() , 'New Build')]")
	private WebElement newBuildSiteSubType;
	public WebElement getnewBuildSiteSubType() {
		return newBuildSiteSubType;
	}
	
	@FindBy(xpath = "//label[contains(text() , 'Owner')]")
	private WebElement ownerSection;
	public WebElement getownerSection() {
		return ownerSection;
	}

	@FindBy(id = "self_organization")
	private WebElement yourOrganisationCheckBox;
	public WebElement getyourOrganisationCheckBox() {
		return yourOrganisationCheckBox;
	}
	
	
	@FindBy(id = "your_organization")
	private WebElement yourOrganisationMapIcon;
	public WebElement getyourOrganisationMapIcon() {
		return yourOrganisationMapIcon;
	}
	
	@FindBy(xpath = "//div[contains(text() , 'Your organisation')]")
	private WebElement yourOrganisationOwnerSection;
	public WebElement getyourOrganisationOwnerSection() {
		return yourOrganisationOwnerSection;
	}
	
	@FindBy(id = "other_organization")
	private WebElement otherOrganizationCheckBox;
	public WebElement getotherOrganizationCheckBox() {
		return otherOrganizationCheckBox;
	}
	
	@FindBy(xpath = "//div[contains(text() , 'Other Organisations')]")
	private WebElement otherOrganizationOwnerSection;
	public WebElement getotherOrganizationOwnerSection() {
		return otherOrganizationOwnerSection;
	}
	
	@FindBy(xpath = "//label[text() = 'Classification']")
	private WebElement classificationSection;
	public WebElement getclassificationSection() {
		return classificationSection;
	}
	
	@FindBy(xpath = "//div[text() = 'Select Classification']")
	private WebElement selectClassificationSection;
	public WebElement getselectClassificationSection() {
		return selectClassificationSection;
	}
	
	@FindBy(xpath = "//span[@class = 'ng-arrow']")
	private WebElement selectClassificationSectionDropDown;
	public WebElement getselectClassificationSectionDropDown() {
		return selectClassificationSectionDropDown;
	}
	
	@FindBy(xpath = "//label[text() = 'Height Range']")
	private WebElement heightRangeSection;
	public WebElement getheightRangeSection() {
		return heightRangeSection;
	}
	
    @FindBy(xpath = "//label[text() = 'From (meters)']")
    private WebElement fromMeterHeightRangeSection;
    public WebElement getfromMeterHeightRangeSection() {
    	return fromMeterHeightRangeSection;
    }
    
    @FindBy(xpath = "//label[text() = 'To (meters)']")
	private WebElement toMeterHeightRangeSection;
    public WebElement gettoMeterHeightRangeSection() {
    	return toMeterHeightRangeSection;
    }
          
    @FindBy(xpath = "//label[text() = 'Facilities']")
    private WebElement facilityLabel;
    public WebElement getfacilityLabel() {
    	return facilityLabel;
    }
    
    @FindBy(id = "power")
    private WebElement facilityPowerCheckBox;
    public WebElement getfacilityPowerCheckBox() {
    	return facilityPowerCheckBox;
    }
    
    @FindBy(xpath = "//div[contains(text() , 'Power')]")
    private WebElement powerfacilitySection;
    public WebElement getpowerfacilitySection() {
    	return powerfacilitySection;
    }
    
    @FindBy(id = "fibre")
    private WebElement facilityFibreCheckBox;
    public WebElement getfacilityFibreCheckBox() {
    	return facilityFibreCheckBox;
    }
    
    @FindBy(xpath = "//div[contains(text(), 'Fibre')]")
    private WebElement fibreFacilitySection;
    public WebElement getfibreFacilitySection() {
    	return fibreFacilitySection;
    }
	
    @FindBy(xpath = "//a[text() = 'Clear All Filters']")
    private WebElement clearAllFilterLink;
    public WebElement getclearAllFilterLink() {
    	return clearAllFilterLink;
    }
    
    @FindBy(xpath = "//span[text() = 'Apply']")
    private WebElement applyButton;
    public WebElement getapplyButton() {
    	return applyButton;
    }
    
    @FindBy(xpath = "//p[text() = 'Greenfield']")
    private WebElement greenFieldSiteModal;
    public WebElement getgreenFieldSiteModal() {
    	return greenFieldSiteModal;
    }
    
    @FindBy(xpath = "//button[contains(@class, 'badge')]")
    private WebElement filterIconWithRedDot;
    public WebElement getfilterIconWithRedDot() {
    	return filterIconWithRedDot;
    }
    
    @FindBy(xpath = "//div[contains(text(), 'Greenfield')]")
    private WebElement greenFieldAppliedParameter;
    public WebElement getgreenFieldAppliedParameter() {
    	return greenFieldAppliedParameter;
    }
    
    @FindBy(xpath = "//img[contains(@src , '/sitenna-asset/images/icon-close.svg')]")
    private WebElement crossIconAppliedParameter;
    public WebElement getcrossIconAppliedParameter() {
    	return crossIconAppliedParameter;
    }
	
    @FindBy(xpath = "//div[contains(text(), 'Clear All Filters')]")
    private WebElement clearAllFilters;
    public WebElement getclearAllFilters() {
    	return clearAllFilters;
    }
    @FindBy(xpath = "//img[contains(@src, '/sitenna-asset/images/icon-close-red.svg')]")
    private WebElement clearAllFiltersCloseIcon;
    public WebElement clearAllFiltersCloseIcon() {
    	return clearAllFiltersCloseIcon;
    }
    
    @FindBy(xpath = "//span[contains(text() , 'Hide Filters')]")
    private WebElement hideFilterLink;
    public WebElement gethideFilterLink() {
    	return hideFilterLink;
    }
    
    @FindBy(xpath = "//img[contains(@src, '/sitenna-asset/images/arrow-down-blue.svg')]")
    private WebElement hideFilterLinkWithUpsideArrow;
    public WebElement gethideFilterLinkWithUpsideArrow() {
    	return hideFilterLinkWithUpsideArrow;
    }
    
    @FindBy(xpath = "//p[text() = 'Rooftop']")
    private WebElement roofTopSiteModal;
    public WebElement getroofTopSiteModal() {
    	return roofTopSiteModal;
    }
    
    @FindBy(xpath = "//div[contains(text(), 'Rooftop')]")
    private WebElement roofTopAppliedParameter;
    public WebElement getroofTopAppliedParameter() {
    	return roofTopAppliedParameter;
    }
    
    @FindBy(xpath = "//p[text() = 'Street Asset']")
    private WebElement streetAssetSiteModal;
    public WebElement getstreetAssetSiteModal() {
    	return streetAssetSiteModal;
    }
    
    @FindBy(xpath = "//div[contains(text() , 'Street Asset')]")
    private WebElement streetAssetAppliedParameter;
    public WebElement getstreetAssetAppliedParameter() {
    	return streetAssetAppliedParameter;
    }
    
    @FindBy(xpath = "//h2[contains(text() , 'Filter')]")
    private WebElement filterHeading;
    public WebElement getfilterHeading() {
    	return filterHeading;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
