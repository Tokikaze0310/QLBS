package controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import businessLogics.SuaBL;
import javaBeans.SuaBean;;

@RestController
public class AuthorRESTController {
	@GetMapping("/milk-rest")
	public List<SuaBean> MilkRest(){
		return SuaBL.getListsua();
	}
	@GetMapping("/milk-rest/{id}")
	public List<SuaBean> MilkRest(@PathVariable(name = "id") String id)
	{
		return SuaBL.getsuaByMa(id);
	}
	@PostMapping("/add-milk-rest")
	public int addauthorRest(@RequestBody SuaBean s)
	{
		return SuaBL.add(s);
	}
//	@PutMapping("/put-milk-rest")
//	public int putAuthorRest(@RequestBody SuaBean s)
//	{
//		return SuaBL.edit(s);
//	}
//	@DeleteMapping("/del-milk-rest/{id}")
//	public int delAuthorRest(@PathVariable(name = "id") String id)
//	{
//		return SuaBL.delete(id);
//	}
}
