package com.first.ramSirRstApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.service.BlogPostService;
import com.first.ramSirRstApi.util.PaginationConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {
	@Autowired
	private BlogPostService blogPostService;

	@GetMapping("/{postId}")
	public ResponseEntity<BlogPostDTO> findBlog(@PathVariable("postId") Integer id) {

		BlogPostDTO getById=blogPostService.findByBlogPostId(id);
		return new ResponseEntity(getById, HttpStatus.OK);
	}

	@PostMapping("/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BlogPostDTO> createBlog(@Valid @RequestBody BlogPostDTO blogPostDTO) {
         System.out.println("------------------------------");
		BlogPostDTO createBlogPost = blogPostService.createObject(blogPostDTO);
		return new ResponseEntity(createBlogPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<BlogPostDTO> findAllBlog(
	        @RequestParam(value = "pageNo", defaultValue = PaginationConstants.PAGENUM, required = false) Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = PaginationConstants.PAGESIZE, required = false) Integer pageSize,
	        @RequestParam(value = "sortBy", defaultValue = PaginationConstants.BLOGID, required = false) String sortBy,
	        @RequestParam(value = "sortDir", defaultValue = PaginationConstants.SORT_ASC, required = false) String sortDir) {

	   

	    Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) 
	                ? Sort.by(sortBy).ascending() 
	                : Sort.by(sortBy).descending();

	    PageRequest pagable = PageRequest.of(pageNo, pageSize, sort);

	    List<BlogPostDTO> student = blogPostService.getAllBlogPost(pagable);
	    return new ResponseEntity(student, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<BlogPostDTO> updateBlogPost(@Valid @RequestBody BlogPostDTO blogPostDTO) {

		BlogPostDTO getById=blogPostService.updateBlogPost(blogPostDTO);
		
		return new ResponseEntity(getById, HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePostById(@PathVariable("postId") Integer postId) {
		BlogPostDTO deletePostById = blogPostService.deletePostById(postId);
		return new ResponseEntity("Data Deleted successully",HttpStatus.OK);
	}

}
