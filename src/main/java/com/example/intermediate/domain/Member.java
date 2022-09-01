package com.example.intermediate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends Timestamped  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nickname;

  @OneToMany(mappedBy = "member",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;





  @Column(nullable = false)
  @JsonIgnore
  private String password;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Member member = (Member) o;
    return id != null && Objects.equals(id, member.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }



  /*public void pushPostLike(Post post)
  {
    if(!this.postlikelist.contains(post.getId()))
    {
      this.postlikelist.add(post.getId());
      post.pushLike();
      System.out.println("Like!");
    }
    else{
      this.postlikelist.remove(post.getId());
      post.pushDislike();
      System.out.println("이미 좋아요한 게시물입니다.");
    }
  }
  public void pushCommentLike(Comment comment)
  {
    if(!this.commentlikelist.contains(comment.getId()))
    {
      this.commentlikelist.add(comment.getId());
      comment.pushLike();
      System.out.println("Like!");
    }
    else{
      this.commentlikelist.remove(comment.getId());
      comment.pushDislike();
      System.out.println("이미 좋아요한 댓글입니다.");
    }
  }
  public void pushRecommentLike(Recomment recomment)
  {
    if(!this.recommentlikelist.contains(recomment.getId()))
    {
      this.recommentlikelist.add(recomment.getId());
      recomment.pushLike();
      System.out.println("Like!");
    }
    else{
      this.recommentlikelist.remove(recomment.getId());
      recomment.pushDislike();
      System.out.println("이미 좋아요한 대댓글입니다.");
    }
  }*/
  public boolean validatePassword(PasswordEncoder passwordEncoder, String password) {
    return passwordEncoder.matches(password, this.password);
  }
}
