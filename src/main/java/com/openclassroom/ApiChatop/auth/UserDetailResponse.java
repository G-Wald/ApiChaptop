package com.openclassroom.ApiChatop.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model for the request /me
 * This model will be return if the user has a correct token
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponse {
    private int id;
    private String name;
    private String email;
    private String created_at;
    private String updated_at;
}