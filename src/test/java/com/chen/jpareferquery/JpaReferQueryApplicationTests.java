package com.chen.jpareferquery;

import com.chen.jpareferquery.dao.*;
import com.chen.jpareferquery.entity.Comment;
import com.chen.jpareferquery.entity.Post;
import com.chen.jpareferquery.entity.User;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaReferQueryApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;


	@Before
	public void contextLoads() {


	}

	@Test
	public void test1(){
		User one = userRepository.findOne(2L);
		System.err.println(one);
	}


	@Test
	public void test2(){

		commentRepository.deleteAllInBatch();
		postRepository.deleteAllInBatch();

		// ======================================

		Post post = new Post("Hibernate One-To-Many Mapping Example",
				"Learn how to use one to many mapping in hibernate",
				"Entire Post Content with sample code");

		Comment comment1 = new Comment("Great Post!");
		comment1.setPost(post);

		Comment comment2 = new Comment("Really helpful Post. Thanks a lot!");
		comment2.setPost(post);

		post.getComments().add(comment1);
		post.getComments().add(comment2);

		Post save = postRepository.save(post);
		System.err.println(save);
	}

	@Test
	public void test3(){
		Post one = postRepository.findOne(1L);
//		Hibernate.initialize(one.getComments());

		System.err.println(one);

		System.err.println(commentRepository.findOne(1L));

	}

}
