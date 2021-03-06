package com.example.demo.domain;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.posts.Posts;
import com.example.demo.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() {
		
		//postsRepository.deleteAll();

		//int a;
	}
	
	@Test
	public void 게시글저장_불러오기() {
		//given 
		postsRepository.save(Posts.builder()
					.title("테스트 게시글") 
					.content("테스트 본문") 
					.author("jojoldu@gmail.com") 
					.build()); 
		//when 
		List<Posts> postsList = postsRepository.findAll();
		
		//then 
		Posts posts = postsList.get(0); 
		assertThat(posts.getTitle(), is("테스트 게시글")); 
		assertThat(posts.getContent(), is("테스트 본문"));

		
	}
	
	
	
}
