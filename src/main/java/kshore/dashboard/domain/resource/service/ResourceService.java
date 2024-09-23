package kshore.dashboard.domain.resource.service;

import kshore.dashboard.domain.resource.dto.LoginRequestDto;
import kshore.dashboard.domain.resource.dto.LoginResponseDto;
import kshore.dashboard.domain.resource.entity.Resource;
import kshore.dashboard.domain.resource.repository.ResourceRepository;
import kshore.dashboard.exception.CustomException;
import kshore.dashboard.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    //login
    public LoginResponseDto login(LoginRequestDto reqDto) {
        log.info("Call API : login");
        //email 계정 유무 확인
        Optional<Resource> optionalResource = resourceRepository.findByEmail(reqDto.getEmail());
        if(!optionalResource.isPresent())
            throw new CustomException(ErrorCode.DATA_NOT_FOUND, "존재하지 않는 email 입니다.");

        //get resource
        Resource resource = optionalResource.get();

        //password 일치 확인
        if(!resource.getPassword().equals(reqDto.getPassword()))
            throw new CustomException(ErrorCode.BAD_CLIENT_REQUEST, "비밀번호가 일치하지 않습니다");

        LoginResponseDto resDto = new LoginResponseDto();
        resDto.setUuid(resource.getResourceId());

        return resDto;
    }

    //조회
    public Resource getResourceById(String id){
        log.info("Call API : getResourceById");
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        return optionalResource.orElse(null);
    }

    //회원가입
    public Resource saveResource(Resource resource){
        log.info("Call API : saveResource");
        return resourceRepository.save(resource);
    }

    public Resource updateResource(String id, Resource resource){
        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resource not found"));

        //수정 적용 필드 작성
        existingResource.setGender(resource.getGender());
        existingResource.setProfileImg(resource.getProfileImg());

        return resourceRepository.save(existingResource);
    }
    
    //이메일 인증 코드 발송
    //이메일 인증 코드 확인
    
}
