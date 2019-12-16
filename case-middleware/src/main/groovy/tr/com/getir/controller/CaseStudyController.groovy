package tr.com.getir.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import tr.com.getir.persistency.model.Record
import tr.com.getir.persistency.model.RequestPayload
import tr.com.getir.persistency.model.ResponsePayload

import tr.com.getir.service.CaseStudyService

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@RestController
@RequestMapping("/")
class CaseStudyController {

    @Autowired
    private CaseStudyService caseStudyService

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    ResponsePayload postResponsePayload(@RequestBody RequestPayload requestPayload) {
        List<Record> recordList = caseStudyService.getFilteredRecords(requestPayload.getStartDate(), requestPayload.getEndDate(), requestPayload.getMinCount(), requestPayload.getMaxCount())
        ResponsePayload responsePayload = new ResponsePayload()
        responsePayload.setCode(0)
        responsePayload.setMsg("Success")
        responsePayload.setRecordList(recordList)
        return responsePayload
    }
}
