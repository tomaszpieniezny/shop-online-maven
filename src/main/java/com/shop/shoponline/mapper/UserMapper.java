package com.shop.shoponline.mapper;

import com.shop.shoponline.model.dto.UserDto;
import com.shop.shoponline.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser (UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getStatus());
    }

    public UserDto mapToUserDto (User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getStatus());
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getStatus()))
                .collect(Collectors.toList());
    }
}
