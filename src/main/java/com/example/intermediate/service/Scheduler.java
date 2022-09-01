
package com.example.intermediate.service;

import com.example.intermediate.domain.Post;
import com.example.intermediate.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor // final 멤버 변수를 자동으로 생성합니다.
@Component // 스프링이 필요 시 자동으로 생성하는 클래스 목록에 추가합니다.
public class Scheduler {

    private final PostRepository postRepository;
//    private final PostService postService;


    // 초, 분, 시, 일, 월, 주 순서
    @Scheduled(cron = "0 0 1 * * *")
    public void deleteEmptyComment() throws InterruptedException {

        List<Post> postList = postRepository.findAll();
        boolean check=false;
        for(Post postone:postList)
        {
            if(postone.getComments().size()==0) {
                System.out.println("글" + postone.getTitle() + "이 삭제되었습니다.");
                postRepository.delete(postone);
                check = true;
            }
        }
        if(check==false){
            System.out.println("삭제할 Post가 없습니다.");
        }

    }
}

