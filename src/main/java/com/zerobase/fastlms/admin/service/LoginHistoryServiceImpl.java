package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.entity.LoginHistory;
import com.zerobase.fastlms.admin.mapper.LoginHistoryMapper;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.admin.repository.LoginHistoryRepository;
import com.zerobase.fastlms.admin.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;
    private final LoginHistoryMapper loginHistoryMapper;

    @Override
    public void saveLoginHistory(HttpServletRequest request, String userId) {

        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .loginDt(LocalDateTime.now())
                .ip(request.getRemoteAddr())
                .userAgent(request.getHeader("User-Agent"))
                .build();

        loginHistoryRepository.save(loginHistory);

    }

    @Override
    public List<LoginHistoryDto> getLoginList(MemberParam memberParam) {

        long loginHistoryTotal = loginHistoryMapper.selectListCount(memberParam);

        List<LoginHistoryDto> loginHistoryDtoList = loginHistoryMapper.selectList(memberParam);

        if(loginHistoryDtoList != null && loginHistoryDtoList.size() > 0){
            loginHistoryDtoList.get(0).setTotalCount(loginHistoryTotal);
        }

        int i = 0;
        for(LoginHistoryDto x : loginHistoryDtoList){
            x.setSeq(loginHistoryTotal - memberParam.getPageStart() - i);
            i++;
        }

        return loginHistoryDtoList;
    }
}
