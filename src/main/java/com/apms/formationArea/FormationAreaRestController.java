package com.apms.formationArea;

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
@RequestMapping("/formationArea")
public class FormationAreaRestController {
	
    @Autowired
    private FormationAreaService formationAreaService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<FormationArea>> getAll() {
		List<FormationArea> res;
		try {
			res = formationAreaService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<FormationArea>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<FormationArea>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<FormationArea>>(RESTResponse.FAIL, "Servicios no disponibles.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<FormationArea> getOne(@PathVariable Integer id) {
        FormationArea res;
        try{
            res = formationAreaService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<FormationArea>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<FormationArea>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<FormationArea>(RESTResponse.FAIL, "Area de formacion no registrada.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<FormationArea> post(@RequestBody RESTRequest<FormationArea> formationArea) {
        try {
            if(formationAreaService.getOne(formationArea.getPayload().getId()) != null)
                return new RESTResponse<FormationArea>(RESTResponse.FAIL, "La area de formacion ya existe en el sistema.", null);
            formationAreaService.add(formationArea.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<FormationArea>(RESTResponse.FAIL, "Por el momento no se puede realizar el registro.", null);
        }
        return new RESTResponse<FormationArea>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<FormationArea> patch(@RequestBody RESTRequest<FormationArea> formationArea) {
        try {
            formationAreaService.update(formationArea.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<FormationArea>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<FormationArea>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<FormationArea> put(@RequestBody RESTRequest<FormationArea> formationArea) {
        try {
            formationAreaService.update(formationArea.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<FormationArea>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<FormationArea>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<FormationArea> delete(@PathVariable Integer id) {
        try {
            formationAreaService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<FormationArea>(RESTResponse.FAIL, "Por el momento no se puede realizar el registro.", null);
        }
        return new RESTResponse<FormationArea>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }
}
