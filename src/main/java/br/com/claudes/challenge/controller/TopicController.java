package br.com.claudes.challenge.controller;

import br.com.claudes.challenge.dto.topic.CreateTopicRequestDto;
import br.com.claudes.challenge.model.Topic;
import br.com.claudes.challenge.service.ITopicService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/v1")
public class TopicController {

    @Autowired
    private ITopicService iTopicService;

    @PostMapping(value = "/topic" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "API used to create a new topic voting")
    public ResponseEntity<Topic> createTopic(@RequestBody CreateTopicRequestDto createTopicRequestDto){

        log.info("Starting topic creation endpoint");
        Topic newTopic = iTopicService.createANewTopic(createTopicRequestDto);
        log.info("Ending topic creation endpoint");
        return new ResponseEntity<Topic>(newTopic, HttpStatus.OK);
    }

}
