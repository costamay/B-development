package com.bring.sacco.responses;

import com.bring.sacco.entities.Member;
import com.bring.sacco.headers.Header;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
public class MemberResponse {
  private Header header;
  private Member member;

}
