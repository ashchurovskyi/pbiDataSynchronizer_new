package com.barcom.pbiDataSynchronizer.controllers;

import com.barcom.pbiDataSynchronizer.dto.ReportReceivableDTO;
import com.barcom.pbiDataSynchronizer.entities.ReportReceivable;
import com.barcom.pbiDataSynchronizer.services.ReportReceiptsService;
import com.barcom.pbiDataSynchronizer.services.ReportReceivableService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/erp/receivable")
@Api("receivable")
public class ReceivableController extends ApiController {

    private ReportReceivableService service;

    public ReceivableController(ReportReceivableService service){
        this.service = service;
    }

    @PostMapping("/saveErpReceivableList")
    public ResponseEntity<String> saveReceivables(@RequestBody List<ReportReceivableDTO> listDto){
        Runnable exec = () -> {
            isBlocked = true;
            HashMap<LocalDateTime,List<ReportReceivable>> receivableByDates = ReportReceivableDTO.getReceivableByDates(listDto);

            Set<LocalDateTime> datesSet = receivableByDates.keySet();

            datesSet.parallelStream().forEach(date->{
                List<ReportReceivable> list = receivableByDates.get(date);
                service.clearByDate(date);
                service.saveAll(list);
            });
            isBlocked = false;
        };
        return runAsync(exec);
    }

}
