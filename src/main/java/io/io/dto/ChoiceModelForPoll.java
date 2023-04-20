package io.io.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"votes"})
public class ChoiceModelForPoll extends ChoiceModel{

}
