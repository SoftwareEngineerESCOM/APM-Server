package com.apms.bibliographyRelation;

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
@RequestMapping("/bibliographyRelation")
public class BibliographyRelationRestController {
	
    @Autowired
    private BibliographyRelationService bibliographyRelationService;

    /*
    **Return a listing of all the resources
    */
    @GetMapping
	public RESTResponse<List<BibliographyRelation>> getAll() {
		List<BibliographyRelation> res;
		try {
			res = bibliographyRelationService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new RESTResponse<List<BibliographyRelation>>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
		}
		if (!res.isEmpty()) {
			return new RESTResponse<List<BibliographyRelation>>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<List<BibliographyRelation>>(RESTResponse.FAIL, "Los catalogos necesarios no se han cargado.", null);
		}
	}

    /*
    **Return one resource
    */
    @GetMapping("/{id}")
    public RESTResponse<BibliographyRelation> getOne(@PathVariable Integer id) {
        BibliographyRelation res;
        try{
            res = bibliographyRelationService.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<BibliographyRelation>(RESTResponse.DBFAIL, "Inconsistencia en la base de datos.", null);
        }
        if (res != null) {
			return new RESTResponse<BibliographyRelation>(RESTResponse.OK, "", res);
		} else {
			return new RESTResponse<BibliographyRelation>(RESTResponse.FAIL, "BibliographyRelation no registrado.", null);
		}
    }

    /*
    **Store a newly created resource in storage.
    */
    @PostMapping
    public RESTResponse<BibliographyRelation> post(@RequestBody RESTRequest<BibliographyRelation> bibliographyRelation) {
        try {
            if(bibliographyRelationService.getOne(bibliographyRelation.getPayload().getId()) != null)
                return new RESTResponse<BibliographyRelation>(RESTResponse.FAIL, "BibliographyRelation ya existe en el sistema.", null);
            bibliographyRelationService.add(bibliographyRelation.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<BibliographyRelation>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<BibliographyRelation>(RESTResponse.OK, "Registro finalizado exitosamente.", null);
    }

    /*
    **Update the specified resource in storage partially.
    */
    @PatchMapping
    public RESTResponse<BibliographyRelation> patch(@RequestBody RESTRequest<BibliographyRelation> bibliographyRelation) {
        try {
            bibliographyRelationService.update(bibliographyRelation.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<BibliographyRelation>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<BibliographyRelation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
    **Update the specified resource in storage.
    */
    @PutMapping
    public RESTResponse<BibliographyRelation> put(@RequestBody RESTRequest<BibliographyRelation> bibliographyRelation) {
        try {
            bibliographyRelationService.update(bibliographyRelation.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<BibliographyRelation>(RESTResponse.FAIL, "Hubo un error al modificar. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<BibliographyRelation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }

    /*
    **Remove the specified resource from storage.
    */
    @DeleteMapping("/{id}")
    public RESTResponse<BibliographyRelation> delete(@PathVariable Integer id) {
        try {
            bibliographyRelationService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RESTResponse<BibliographyRelation>(RESTResponse.FAIL, "Hubo un error en el registro. Por favor, intentelo mas tarde.", null);
        }
        return new RESTResponse<BibliographyRelation>(RESTResponse.OK, "Los cambios se guardaron exitosamente.", null);
    }
}
