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

import java.util.List;

@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/v1")
public class TopicController {

    @Autowired
    private ITopicService iTopicService;

    @PostMapping(value = "/topic", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "API used to create a new topic voting")
    public ResponseEntity<Topic> createTopic(@RequestBody CreateTopicRequestDto createTopicRequestDto){

        log.info("Starting topic creation endpoint");
        Topic newTopic = iTopicService.createANewTopic(createTopicRequestDto);
        log.info("Ending topic creation endpoint");
        return new ResponseEntity<>(newTopic, HttpStatus.OK);
    }

    @GetMapping(value = "/topic" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "API used to get all topics")
    public ResponseEntity<List<Topic>> getAllTopics(){

        log.info("Starting get all topics");
        List<Topic> topics = iTopicService.getAllTopics();
        log.info("Ending  get all topics");
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }
}
