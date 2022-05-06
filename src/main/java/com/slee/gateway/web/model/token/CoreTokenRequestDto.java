package com.slee.gateway.web.model.token;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoreTokenRequestDto {
	private String instCd;
	private String userId;
	private String password;
	private String url;
}
