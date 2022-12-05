package com.unicef.controller.noticeFaq.api;

import com.unicef.aop.annotation.LogAspect;
import com.unicef.aop.annotation.ValidAspect;
import com.unicef.domain.notice.AttachedFile;
import com.unicef.domain.notice.Notice;
import com.unicef.dto.CMRespDto;
import com.unicef.dto.notice.NoticeListRespDto;
import com.unicef.dto.notice.NoticeModificationReqDto;
import com.unicef.dto.notice.NoticeReqDto;
import com.unicef.dto.notice.NoticeWriteRespDto;
import com.unicef.repository.notice.NoticeRepository;
import com.unicef.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class NoticeApi {

    @Value("${file.path}")
    private String filePath;

    private final NoticeRepository noticeRepository;
    private final NoticeService noticeService;

    @PostMapping("/notice")
    public ResponseEntity<?> submit(NoticeReqDto noticeReqDto) throws Exception {

        log.info("{}", noticeReqDto);

        List<AttachedFile> attachedFileList = null;

        MultipartFile firstFile = noticeReqDto.getFiles().get(0);
        String firstFileName = firstFile.getOriginalFilename();

        if(!firstFileName.isBlank()){
            log.info("파일 입출력을 합니다.");

            attachedFileList = new ArrayList<AttachedFile>();

            for(MultipartFile file : noticeReqDto.getFiles()){
                String originFileName = file.getOriginalFilename();

                String uuid = UUID.randomUUID().toString();
                String extension = originFileName.substring(originFileName.lastIndexOf("."));
                String tempFileName = uuid + extension;

                Path uploadPath = Paths.get(filePath, "notice/" + tempFileName);

                File f = new File(filePath + "notice");
                if(!f.exists()) {
                    f.mkdirs();
                }

                try {
                    Files.write(uploadPath, file.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                AttachedFile attachedFile = AttachedFile.builder()
                        .file_origin_name(originFileName)
                        .file_temp_name(tempFileName)
                        .build();

                attachedFileList.add(attachedFile);
            }
        }
        Notice notice = noticeReqDto.toNoticeEntity();
        int result = noticeRepository.save(notice);

        if(result == 0){
            return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "공지사항 작성실패", notice));
        }

        if(attachedFileList != null) {
            for (AttachedFile attachedFile : attachedFileList) {
                attachedFile.setNotice_id(notice.getNotice_id());
                log.info("AttachedFile 객체: {}", attachedFile);
            }
            result = noticeRepository.saveFiles(attachedFileList);

            if(result != attachedFileList.size()){
                return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "파일 업로드 실패", attachedFileList));
            }
        }

        NoticeWriteRespDto noticeWriteRespDto = notice.toNoticeWriteRespDto(attachedFileList);

        noticeService.submit(noticeReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "공지사항 등록완료", noticeWriteRespDto));
    }

    @GetMapping("/noticeList")
    public ResponseEntity<?> getNoticeList() throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeService.getNoticeList()));
    }

//    @GetMapping("/noticeList/{noticeId}")
//    public ResponseEntity<?> read(@PathVariable int noticeId){
//        log.info("{}", noticeId);
//
//        Notice notice = noticeRepository.getNotice(noticeId);
//
//        log.info("{}", notice);
//
//        NoticeListRespDto noticeListRespDto = notice.toListRespDto();
//
//        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeListRespDto));
//    }

    @LogAspect
    @ValidAspect
    @PutMapping("/notice/modification")
    public ResponseEntity<?> updateNotice(@Valid @RequestBody NoticeModificationReqDto noticeModificationReqDto, BindingResult bindingResult) throws Exception {
        log.info("{}", noticeModificationReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeService.updateNotice(noticeModificationReqDto)));
    }

    @DeleteMapping("/notice/{notice_id}")
    public ResponseEntity<?> deleteNotice(@PathVariable int notice_id) throws Exception {
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeService.deleteNotice(notice_id)));
    }
}
