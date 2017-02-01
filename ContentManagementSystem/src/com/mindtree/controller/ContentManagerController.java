package com.mindtree.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.dtos.BlogDataDTO;
import com.mindtree.model.BlogInfo;
import com.mindtree.model.CommentsInfo;
import com.mindtree.service.ContentManagementSystemService;

@Controller
@RequestMapping("/")
public class ContentManagerController {

	@Autowired
	private ContentManagementSystemService blogManagementService;
	
	private List<BlogDataDTO> blogList = new ArrayList<BlogDataDTO>();
	
	public ContentManagerController( ContentManagementSystemService value ) {
		blogManagementService = value;
		fetchLatestBlogs();
	}
	@RequestMapping(value="/faces/uploadBlogs")
	public ModelAndView updateBlog(){
		fetchLatestBlogs();
		return new ModelAndView("home");
	}
	@RequestMapping("/")
	public ModelAndView getPage(){
		fetchLatestBlogs();
		return new ModelAndView("home");
	}
	
	private void fetchLatestBlogs() {
		blogList = new ArrayList<BlogDataDTO>();
		List<BlogInfo> blogs = blogManagementService.fetchBlogs();
		for (Iterator iterator = blogs.iterator(); iterator.hasNext();) {
			BlogInfo blog = (BlogInfo) iterator.next();
			BlogDataDTO blogDTO = new BlogDataDTO();
			blogDTO.setId(blog.getId());
			blogDTO.setBlogTitle(blog.getBlogName());
			blogDTO.setContent(blog.getBlogDetails());
			blogDTO.setAttachment(new File (blog.getBlogAttachments() ) );
			blogDTO.setAttachmentName(blogDTO.getAttachment().getName());
			blogDTO.setComments(blog.getComments());
			blogList.add( blogDTO );
		}
	}	
	
	@RequestMapping("/login")
	public String getLogin(){
		return "login";
	}
	
	@RequestMapping("/faces/logout")
	public ModelAndView logout( HttpServletRequest request, HttpServletResponse response, ModelMap map ) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		map.addAttribute("loggedout",true);
		fetchLatestBlogs();
		return new ModelAndView("home");
	}
	
	@RequestMapping("/faces/addComment")
	public ModelAndView addComment ( @RequestParam("blogId") Integer Id, @RequestParam("name") String name, @RequestParam("comment") String comment )
	{
		CommentsInfo comments = new CommentsInfo();
		BlogInfo blog = new BlogInfo();
		blog.setId(Id);
		comments.setBlog(blog );
		comments.setName(name);
		comments.setCommentText(comment);
		blogManagementService.saveComment( comments );
		return new ModelAndView("home");
	}
	
	
	@RequestMapping("faces/saveBlog")
	public ModelAndView saveBlog( @RequestParam("blogTitle") String title, @RequestParam("blogContent") String blogDetails, @RequestParam("file") MultipartFile file)
	{
		BlogDataDTO blogDTO = new BlogDataDTO();
		FileOutputStream stream = null;
		try {
			byte[] bytes = file.getBytes();
			
			// To Create the directory and store it on file if not present
			if ( bytes.length > 0 ){
				
			String path = "uploads";
			
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();

			// Creates the file on server
			File serverFile = new File(dir
					+ File.separator + file.getOriginalFilename());
			stream = new FileOutputStream(serverFile);
			stream.write(bytes);
			stream.close();
			blogDTO.setAttachment(serverFile);
			}
			blogDTO.setBlogTitle(title);
			blogDTO.setContent(blogDetails);
			blogManagementService.saveBlog( blogDTO );
			fetchLatestBlogs();
		} catch (Exception e) {
			if (stream!=null){
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return new ModelAndView("home");
	}
	public ContentManagementSystemService getBlogManagementService() {
		return blogManagementService;
	}
	public void setBlogManagementService(
			ContentManagementSystemService blogManagementService) {
		this.blogManagementService = blogManagementService;
	}
	
	@ModelAttribute(name="blogList")
	public List<BlogDataDTO> getBlogList() {
		return blogList;
	}
	public void setBlogList(List<BlogDataDTO> blogList) {
		this.blogList = blogList;
	}
	
	
}