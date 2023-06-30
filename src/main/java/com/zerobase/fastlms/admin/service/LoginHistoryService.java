package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.model.MemberParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginHistoryService {

    void saveLoginHistory(HttpServletRequest request, String userId);
    List<LoginHistoryDto> getLoginList(MemberParam memberParam);
}
