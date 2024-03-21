package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    @Autowired
    private PostsService postsService;

    /*
        위 코드에서 @Autowired, final 을 붙히지 않았을 때(의존성 주입을 하지 않았을 때) NullPointerException 발생 이유

        예를 들어, PostsApiController가 PostsService의 메소드를 호출하여 작업을 수행한다고 가정해봅시다.
        PostsApiController가 직접 PostsService의 인스턴스를 생성하면, 두 클래스 사이의 결합도가 높아집니다.
        이로 인해 PostsService의 변경이 PostsApiController에도 영향을 미칠 수 있고, 테스트하기 어려워집니다.

        의존성 주입을 사용하면, PostsService의 인스턴스를 PostsApiController 외부에서 생성하고 이를 PostsApiController에 주입합니다.
        이렇게 하면 PostsApiController는 PostsService의 구현 세부 사항을 알 필요가 없으며, 다른 PostsService 구현으로 쉽게 교체할 수 있게 됩니다.

        제공된 코드에서 PostsService 필드는 초기화되지 않았습니다.
        즉, PostsService의 인스턴스가 생성되어 PostsApiController에 주입되지 않았기 때문에, postsService는 기본값인 null을 가집니다.
        그런 다음 save 메소드에서 postsService.save(requestDto);를 호출하려고 하면,
        실제로는 null.save(requestDto);를 호출하려고 시도하는 것과 같습니다.
        자바에서는 null에 대해 메소드를 호출하려고 하면 NullPointerException이 발생합니다.
    */

    @PostMapping("/api/v1/posts")
    public Object save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
