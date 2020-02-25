package com.shop.shoponline.mapper;

import com.shop.shoponline.model.dto.UserAccountDto;
import com.shop.shoponline.model.entity.UserAccount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAccountMapper {
    public UserAccount mapToUserAccount(UserAccountDto userAccountDto) {
        return new UserAccount(
                userAccountDto.getId(),
                userAccountDto.getLogin(),
                userAccountDto.getPassword());
    }

    public UserAccountDto mapToUserAccountDto(UserAccount userAccount) {
        return new UserAccountDto(
                userAccount.getId(),
                userAccount.getLogin(),
                userAccount.getPassword());
    }

    public List<UserAccountDto> mapToUserAccountDtoList(List<UserAccount> userAccounts) {
        return userAccounts.stream()
                .map(userAccount -> new UserAccountDto(
                        userAccount.getId(),
                        userAccount.getLogin(),
                        userAccount.getPassword()))
                .collect(Collectors.toList());
    }
}
