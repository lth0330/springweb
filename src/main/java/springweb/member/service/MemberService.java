package springweb.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springweb.member.repository.MemberRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
}
