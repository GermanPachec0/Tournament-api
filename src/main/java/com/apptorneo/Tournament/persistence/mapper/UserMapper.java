package com.apptorneo.Tournament.persistence.mapper;

import com.apptorneo.Tournament.domain.dto.UserDTO;
import com.apptorneo.Tournament.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
        @Mappings({
                @Mapping(source = "username",target = "user")
        })
        UserDTO toUser(User user);
        List<UserDTO> toUser(List<User> users);

        @InheritInverseConfiguration
        User toUser(UserDTO userDTO);
}
