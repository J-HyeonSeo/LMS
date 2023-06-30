package com.zerobase.fastlms.banner.model;

import com.zerobase.fastlms.banner.entity.BannerTargetCode;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BannerInput {

    Long id;
    String subject;
    String targetLink;
    @Enumerated(EnumType.STRING)
    BannerTargetCode bannerTarget;
    int SortValue;
    boolean showYn;

    
    //for deletion
    String idList;
    
    //meta-data
    String filename;
    String urlFilename;

}
