package com.apms.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apms.rest.RESTRequest;
import com.apms.rest.RESTResponse;

@RestController
@RequestMapping("/author")
public class AuthorRestController {

	@Autowired
	private AuthorService authorService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Author>> getAll() {
		List<Author> res;
		try {
			res = authorService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<Author>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Author>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Author>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado, favor de intentarlo mas tarde.",
					null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Author> getOne(@PathVariable Integer id) {
		Author res;
		try {
			res = authorService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Author>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Author>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Author>(RESTResponse.FAIL, "Author no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Author> post(@RequestBody RESTRequest<Author> author) {
		try {
			if(authorService.getOne(author.getPayload().getId()) != null)
                return new RESTResponse<Author>(RESTResponse.FAIL, "Author ya existe en el sistema.", null);
			authorService.add(author.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Author>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Author>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Author> patch(@RequestBody RESTRequest<Author> author) {
		try {
			authorService.update(author.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Author>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Author>(RESTResponse.OK, "Author modificado.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Author> put(@RequestBody RESTRequest<Author> author) {
		try {
			authorService.update(author.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Author>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Author>(RESTResponse.OK, "Author modificado.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Author> delete(@PathVariable Integer id) {
		try {
			authorService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<Author>(RESTResponse.FAIL,
					"Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Author>(RESTResponse.OK, "Author modificado.", null);
	}
}
