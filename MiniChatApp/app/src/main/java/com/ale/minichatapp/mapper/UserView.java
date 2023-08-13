package com.ale.minichatapp.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserView {
    private UUID uuid;
    private String username;
    private Role role;
    private String accessToken;
    private String token;
}
