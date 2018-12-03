package com.apms.thematicUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.apms.subtopic.Subtopic;
import com.apms.subtopic.SubtopicService;
import com.apms.topic.Topic;
import com.apms.topic.TopicService;
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

import com.apms.learningUnit.LearningUnitService;
import com.apms.learningUnit.LearningUnit;

@RestController
@RequestMapping("/thematicUnit")
public class ThematicUnitRestController {

	@Autowired
	private ThematicUnitService thematicUnitService;

	@Autowired
	private SubtopicService subtopicService;

	@Autowired
	private TopicService topicService;

	/*
	 ** Return a listing of all the resources
	 */
	@GetMapping
	public RESTResponse<List<ThematicUnit>> getAll() {
		List<ThematicUnit> res;
		try {
			res = thematicUnitService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.",
					null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.FAIL,
					"Servicios no disponibles.", null);
		}
	}

	/*
	 ** Return one resource
	 */
	@GetMapping("/{id}")
	public RESTResponse<ThematicUnit> getOne(@PathVariable Integer id) {
		ThematicUnit res;
		try {
			res = thematicUnitService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			return new RESTResponse<ThematicUnit>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "Unidad tematica no registrada.", null);
		}
	}

	/*
	 ** Store a newly created resource in storage.
	 */
	@PostMapping
	public RESTResponse<ThematicUnit> post(@RequestBody RESTRequest<ThematicUnit> req) {
		try {
			if(thematicUnitService.getOne(req.getPayload().getId()) != null)
                return new RESTResponse<ThematicUnit>(RESTResponse.FAIL, "La Unidad tematica ya existe en el sistema.", null);
			List<Topic> topics = req.getPayload().getTopics();
			List<Integer> ids = new ArrayList<>();
			for (Iterator<Topic> topic = topics.iterator(); topic.hasNext();) {
				for (Iterator<Subtopic> subtopic = topic.next().getSubtopics().iterator(); subtopic.hasNext();){
					subtopic.next().setId(subtopicService.add(subtopic.next()).getId());
				}
				topic.next().setId(topicService.add(topic.next()).getId());
			}
			thematicUnitService.add(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage partially.
	 */
	@PatchMapping
	public RESTResponse<ThematicUnit> patch(@RequestBody RESTRequest<ThematicUnit> req) {
		try {
			thematicUnitService.update(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Update the specified resource in storage.
	 */
	@PutMapping
	public RESTResponse<ThematicUnit> put(@RequestBody RESTRequest<ThematicUnit> req) {
		try {
			thematicUnitService.update(req.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

	/*
	 ** Remove the specified resource from storage.
	 */
	@DeleteMapping("/{id}")
	public RESTResponse<ThematicUnit> delete(@PathVariable Integer id) {
		try {
			thematicUnitService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<ThematicUnit>(RESTResponse.FAIL,
					"Por el momento no se puede realizar el registro.", null);
		}
		return new RESTResponse<ThematicUnit>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
	}

    @GetMapping("/thematicUnitByLearningUnitId/{id}")
    public RESTResponse<List<ThematicUnit>> thematicUnitByLearningUnitId(@PathVariable Integer id) {
		LearningUnit res;
		try {
			res = learningUnitService.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<User>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (res != null) {
			List<ThematicUnit> aux;
			try {
				aux = thematicUnitService.getThematicUnitByLearningUnitId(id);
			} catch (Exception e) {
				e.printStackTrace();
				return new RESTResponse<List<ThematicUnit>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
			}
			if (!aux.isEmpty()) {
				return new RESTResponse<List<ThematicUnit>>(RESTResponse.OK, "", aux);
			} else {
				return new RESTResponse<List<ThematicUnit>>(RESTResponse.FAIL, "No hay Unidades Temáticas asociadas a esta Unidad de Aprendizaje", null);
			}
		} else {
			return new RESTResponse<List<ThematicUnit>>(RESTResponse.FAIL, "Unidad de Aprendizaje no registrada.", null);
		}
    }
}
