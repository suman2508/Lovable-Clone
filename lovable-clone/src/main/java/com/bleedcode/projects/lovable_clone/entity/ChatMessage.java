package com.bleedcode.projects.lovable_clone.entity;

import java.time.Instant;

import com.bleedcode.projects.lovable_clone.enums.MessageRole;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ChatMessage {

    Long id;

    ChatSession chatSession;

    String content;
    MessageRole role;
    String toolCalls; //JSON Array of Tools Called

    Integer tokenUsed;
    Instant createdAt;
}
