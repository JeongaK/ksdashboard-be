package kshore.dashboard.domain.resource.controller;

import kshore.dashboard.domain.resource.dto.CreateResourceDto;
import kshore.dashboard.domain.resource.dto.LoginRequestDto;
import kshore.dashboard.domain.resource.dto.LoginResponseDto;
import kshore.dashboard.domain.resource.dto.UpdateResourceDto;
import kshore.dashboard.domain.resource.entity.Resource;
import kshore.dashboard.domain.resource.service.ResourceService;
import kshore.dashboard.exception.ApiResponse;
import kshore.dashboard.exception.CustomException;
import kshore.dashboard.exception.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ResourceController {
    private final ResourceService resourceService;

    //로그인
    @PostMapping("/resource-management/resources/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto reqDto) {
        log.info("controller - login: {}", reqDto);
        try{
            LoginResponseDto resDto = resourceService.login(reqDto);
            return ApiResponse.success(SuccessCode.GET_SUCCESS,resDto);
        }catch(CustomException e){
            return ApiResponse.error(e.getErrorCode(), e.getMessage());
        }
    }

    //resource 생성 (회원가입)
    @PostMapping("/resource-management/resources/signup")
    public ResponseEntity<?> createResource(@RequestBody CreateResourceDto dto){
        log.info("controller - createResource: {}", dto);
        Resource resource = resourceService.saveResource(Resource.toEntity(dto));
        return ApiResponse.success(SuccessCode.CREATE_SUCCESS,resource);
    }

    //resource 조회 (by id)
    @GetMapping("/resource-management/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable String id) {
        log.info("controller - getResourceById: {}", id);
        Resource resource = resourceService.getResourceById(id);
        return ApiResponse.success(SuccessCode.GET_SUCCESS, resource);
    }

    //resource 수정
    @PostMapping("/resource-management/{id}")
    public ResponseEntity<?> updateResource(@PathVariable String id, @RequestBody UpdateResourceDto dto) {
        log.info("controller - updateResource: {}", id);
        Resource resource = resourceService.updateResource(id, Resource.toEntity(dto));
        return ApiResponse.success(SuccessCode.UPDATE_SUCCESS);
    }

    //resource 삭제
    public ResponseEntity<?> deleteResource(@PathVariable String id) {
        log.info("controller - deleteResource: {}", id);

        return ApiResponse.success(SuccessCode.DELETE_SUCCESS);
    }

/*
    //이메일 인증 코드 발송
    @PostMapping("/auth/send-verify-code")
    public ResponseEntity<?> sendVerifyCode(@RequestBody EmailVerificationDto dto){
        log.info("controller - sendEmailCode: {}", dto);
        //service code

        return ResponseEntity.ok("Verification code sent to email.");
    }

    //이메일 코드 검증
    @PostMapping("/auth/verify-code")
    public ResponseEntity<?> checkEmailCode(@RequestBody EmailVerificationDto dto){
        log.info("controller - checkEmailCode: {}", dto);
        //service code

        return ResponseEntity.ok("Verification successful");
    }
*/

}
