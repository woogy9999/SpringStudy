package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class RecipeController {
	@GetMapping("recipe/list.do")
	public String recipe_list() {
		return "recipe/list";
	}
}
