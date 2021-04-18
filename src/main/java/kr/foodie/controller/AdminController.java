package kr.foodie.controller;

import kr.foodie.config.security.auth.AuthUserDetails;
import kr.foodie.domain.shop.HashTag;
import kr.foodie.domain.shop.Region;
import kr.foodie.domain.shop.Shop;
import kr.foodie.service.RegionService;
import kr.foodie.service.ShopService;
import kr.foodie.service.TagService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private final ShopService shopService;
//    private final TagService tagService;
//    private final RegionService regionService;

    public AdminController(ShopService shopService, TagService tagService, RegionService regionService) {
        this.shopService = shopService;
//        this.tagService = tagService;
//        this.regionService = regionService;
    }

    @GetMapping("/main")
    public String renderAdminShopRed(){
        return "admin-index";
    }

    @GetMapping("/shop/detail")
    public String renderAdminShopDetail(){
        return "admin-shop-detail";
    }

    @RequestMapping(value ="/shop/{shopType}", method= RequestMethod.GET)
    public ModelAndView getShopList(@PathVariable String shopType){
        ModelAndView mav = new ModelAndView();
        if(shopType.equals("red")){
            shopType = "0";
        }else{
            shopType = "1";
        }
        List<Shop> commentList;
//        List<Shop> commentListWithOrder;
//        List<Shop> sideCommentListWithOrder;
//        List<Region> regionInfos;
//        regionInfos = regionService.getRegionInfo(Integer.valueOf(regionTypeId));
        commentList = shopService.getAdminShopInfos(shopType);
//        commentListWithOrder = shopService.getShopInfosWithOrder(regionTypeId, shopType, 9);
//        sideCommentListWithOrder = shopService.getShopInfosWithSideOrder(regionTypeId, shopType, 8);
        mav.addObject("payload", commentList);
//        mav.addObject("regionInfo", regionInfos);
//        mav.addObject("priority", commentListWithOrder);
//        mav.addObject("sidePriority", sideCommentListWithOrder);
//        if(shopType.equals("0")){
        mav.setViewName("admin-shop-list");
//        }else{
//            mav.setViewName("submain-green");
//        }

        return mav;
    }

//    @RequestMapping(value ="/{shopId}", method= RequestMethod.GET)
//    public ModelAndView getShopDetail(@PathVariable Integer shopId, @AuthenticationPrincipal AuthUserDetails userDetails){
//        ModelAndView mav = new ModelAndView();
//
//        List<Shop> commentList;
//        List<HashTag> hashTags;
//        commentList = shopService.getShopDetail(shopId);
//        hashTags = tagService.getHashTags(shopId);
//        mav.addObject("payload", commentList);
//
//        mav.addObject("user", userDetails);
//        if(commentList.size() > 0){
//            Integer background = commentList.get(0).getBackground();
//            if(background == 1){
//                mav.setViewName("detail-green");
//            }else if (background == 2){
//                mav.setViewName("detail-red");
//            }else{
//                mav.setViewName("detail-mustard");
//            }
//            mav.addObject("hashTags",hashTags);
//            return mav;
//        }
//        return null;
//    }
//
//    @RequestMapping(value ="/location/{lat}/{lng}/{shopType}", method= RequestMethod.GET)
//    public ModelAndView getShopListWithLocation(@PathVariable String lat, @PathVariable String lng, @PathVariable String shopType){
//        ModelAndView mav = new ModelAndView();
//        if(shopType.equals("red")){
//            shopType = "0";
//        }else{
//            shopType = "1";
//        }
//        List<Shop> commentList;
//        List<Region> regionInfos = new ArrayList<>();
//
//        Region region = new Region();
//        region.setDistrictName("2KM");
//        region.setProvinceName("범위");
//        regionInfos.add(region);
//
//        commentList = shopService.getShopInfoByAddress(lat, lng, shopType);
//        mav.addObject("payload", commentList);
//        mav.addObject("regionInfo", regionInfos);
//        mav.addObject("location", lat+"/"+lng);
//        if(shopType.equals("0")){
//            mav.setViewName("location-submain-red");
//        }else{
//            mav.setViewName("location-submain-green");
//        }
//        return mav;
//    }
}
