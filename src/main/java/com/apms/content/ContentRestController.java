package com.apms.content;

import java.util.Iterator;
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

import com.apms.rest.RESTRequest;import java.util.logging.Logger;
import com.apms.rest.RESTResponse;
import com.apms.syntheticProgram.SyntheticProgram;
import com.apms.syntheticProgram.SyntheticProgramService;
import com.apms.learningUnit.LearningUnit;
import com.apms.learningUnit.LearningUnitService;

@RestController
@RequestMapping("/content")
public class ContentRestController {

	@Autowired
	private ContentService contentService;
	
	@Autowired
	private SyntheticProgramService syntheticProgramService;
	
	@Autowired
	private LearningUnitService learningUnitService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<Content>> getAll() {
		List<Content> res;
		try {
			res = contentService.getAll();
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Content>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<Content>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<Content>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<Content> getOne(@PathVariable Integer id) {
		Content res;
		try {
			res = contentService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Content>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<Content>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<Content>(RESTResponse.FAIL, "Contenido no registrado.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<Content> post(@RequestBody RESTRequest<Content> content) {
		try {
			if (contentService.getOne(content.getPayload().getId()) != null)
				return new RESTResponse<Content>(RESTResponse.FAIL, "El contenido ya existe en el sistema.", null);
			contentService.add(content.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<Content> patch(@RequestBody RESTRequest<Content> content) {
		try {
			contentService.update(content.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<Content> put(@RequestBody RESTRequest<Content> content) {
		try {
			contentService.update(content.getPayload());
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<Content> delete(@PathVariable Integer id) {
		try {
			contentService.delete(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<Content>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<Content>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}
	
	@PostMapping("/saveAll")
	public RESTResponse<List<Content>> saveAll(@RequestBody RESTRequest<List<Content>> req) {
		try {
			for (Iterator<Content> i = req.getPayload().iterator(); i.hasNext();)
				contentService.add(i.next()).getId();
			return new RESTResponse<List<Content>>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Content>>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
	}

	@GetMapping("/contentByLearningUnitId/{id}")
	public RESTResponse<List<Content>> contentByLearningUnitId(@PathVariable Integer id) {
		LearningUnit res;
		try {
			res = learningUnitService.getOne(id);
		} catch (Exception e) {
			Logger.getLogger(null).log(null,"F: ",e);
			return new RESTResponse<List<Content>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (res != null) {
			List<Content> aux;
			try {
				aux = contentService.getContentByLearningUnitId(id);
			} catch (Exception e) {
				Logger.getLogger(null).log(null,"F: ",e);
				return new RESTResponse<List<Content>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<Content>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<Content>>(RESTResponse.FAIL, "La Unidad de Aprendizaje no cuenta con contenidos.", aux);
			}
		} else {
			return new RESTResponse<List<Content>>(RESTResponse.FAIL, "Semestre no registrado.", null);
		}
	}
}
