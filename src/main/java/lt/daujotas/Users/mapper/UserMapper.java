package lt.daujotas.Users.mapper;

import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserGeneralLoginCredentialsData, UserDto> {
    @Override
    public UserDto toDto(UserGeneralLoginCredentialsData entity) {
        return UserDto.builder()
                .userNameEmail(entity.getUsername())
                .generatedkey(entity.getGeneratedkey())
                .webaddress(entity.getWebaddress())
                .notes(entity.getNotes())
                .dateAdded(entity.getDateAdded())
                .build();
    }

    @Override
    public UserGeneralLoginCredentialsData fromDto(UserDto userDto) {
        return UserGeneralLoginCredentialsData.builder()
                .username(userDto.getUserNameEmail())
                .generatedkey(userDto.getGeneratedkey())
                .webaddress(userDto.getWebaddress())
                .build();


    }
}
