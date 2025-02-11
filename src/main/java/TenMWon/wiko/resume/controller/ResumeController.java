package TenMWon.wiko.resume.controller;

import TenMWon.wiko.User.repository.UserRepository;
import TenMWon.wiko.common.entity.BaseResponse;
import TenMWon.wiko.common.entity.BaseResponseStatus;
import TenMWon.wiko.resume.dto.in.ResumeRequestDto;
import TenMWon.wiko.resume.service.ResumeService;
import TenMWon.wiko.resume.vo.in.ResumeRequestVo;
import TenMWon.wiko.resume.vo.out.ResumeResponseVo;
import TenMWon.wiko.security.util.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Operation(summary = "Resume 등록 API", description = "Resume 등록 API 입니다.", tags = {"Resume"})
    @PostMapping
    public BaseResponse<Void> createResume(
            @RequestHeader("Authorization") String token,
            @RequestBody ResumeRequestVo resumeRequestVo) {
        resumeService.createResume(token, ResumeRequestDto.toDto(resumeRequestVo));
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "Resume 조회 API", description = "userId로 이력서 내용을 조회하는 API 입니다.", tags = {"Resume"})
    @GetMapping("/read")
    public BaseResponse<ResumeResponseVo> readResume(@RequestHeader("Authorization") String token) {
        return new BaseResponse<>(resumeService.readResume(token).toVo());
    }
}
