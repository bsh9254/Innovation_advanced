package com.example.intermediate.domain;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recommentlike{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "recomment_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Recomment recomment;

    public boolean validateMember(Member member) {
        return !this.member.equals(member);
    }
}
