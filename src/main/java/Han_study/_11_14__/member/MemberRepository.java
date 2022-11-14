package Han_study._11_14__.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
